package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class RecipeWorker {

    private final RecipeRepository recipeRepository;
    private final LabelRepository labelRepository;

    @Autowired
    public RecipeWorker(RecipeRepository recipeRepository, LabelRepository labelRepository) {
        this.recipeRepository = recipeRepository;
        this.labelRepository = labelRepository;
    }

    public Recipe getMealById(Long mealId) {
        meals meal = recipeRepository.findById(mealId).orElse(null);
        if (meal != null) {
            return convertMealToRecipe(meal);
        } else {
            return null;
        }
    }

    public List<Recipe> getByKeyword(String word) {
        List<meals> allMeals = recipeRepository.findAllByKeyword(word);
        List<Recipe> recipeList = new ArrayList<>();
        for (meals meal: allMeals) {
            Recipe recipe = convertMealToRecipe(meal);
            recipeList.add(recipe);
        }
        return recipeList;
    }

    public List<Recipe> getPreRecipes() {
        List<Label> recipeList = new ArrayList<>();
        List<LabelledRecipe> preRecipes = labelRepository.findAllByPre(Boolean.TRUE);
        for (LabelledRecipe recipe: preRecipes) {
            Label label = convertLabelledRecipeToLabel(recipe);
            recipeList.add(label);
        }
        List<Integer> randomIDs = getTenRandomMealids(recipeList);
        List<Recipe> recipes = new ArrayList<>();
        for (int id: randomIDs) {
            recipes.add(getMealById((long) id));
        }
        return recipes;
    }

    public List<Recipe> getPostRecipes() {
        List<Label> recipeList = new ArrayList<>();
        List<LabelledRecipe> postRecipes = labelRepository.findAllByPost(Boolean.TRUE);
        for (LabelledRecipe recipe: postRecipes) {
            Label label = convertLabelledRecipeToLabel(recipe);
            recipeList.add(label);
        }
        List<Integer> randomIDs = getTenRandomMealids(recipeList);
        List<Recipe> recipes = new ArrayList<>();
        for (int id: randomIDs) {
            recipes.add(getMealById((long) id));
        }
        return recipes;
    }

    public List<Recipe> getRecoveryRecipes() {
        List<Label> recipeList = new ArrayList<>();
        List<LabelledRecipe> recoveryRecipes = labelRepository.findAllByRecovery(Boolean.TRUE);
        for (LabelledRecipe recipe: recoveryRecipes) {
            Label label = convertLabelledRecipeToLabel(recipe);
            recipeList.add(label);
        }
        List<Integer> randomIDs = getTenRandomMealids(recipeList);
        List<Recipe> recipes = new ArrayList<>();
        for (int id: randomIDs) {
            recipes.add(getMealById((long) id));
        }
        return recipes;
    }

    public List<Recipe> getHealthyRecipes() {
        List<Label> recipeList = new ArrayList<>();
        List<LabelledRecipe> healthyRecipes = labelRepository.findAllByHealthy(Boolean.TRUE);
        for (LabelledRecipe recipe: healthyRecipes) {
            Label label = convertLabelledRecipeToLabel(recipe);
            recipeList.add(label);
        }
        List<Integer> randomIDs = getTenRandomMealids(recipeList);
        List<Recipe> recipes = new ArrayList<>();
        for (int id: randomIDs) {
            recipes.add(getMealById((long) id));
        }
        return recipes;
    }

    public Label convertLabelledRecipeToLabel(LabelledRecipe preRecipe) {
        return new Label(preRecipe.getMealid(), preRecipe.isPre(), preRecipe.isPost(), preRecipe.isRecovery(), preRecipe.isHealthy());
    }

    public List<Integer> getTenRandomMealids(List<Label> recipes) {
        Random rand = new Random();
        List<Integer> randomIDs = new ArrayList<>();
        int randomSize = recipes.size();
        if (recipes.size() > 10) {
            randomSize = 10;
        }
        for (int i =0; i < randomSize; i++) {
            int randInt = rand.nextInt(recipes.size());
            Label l = recipes.get(randInt);
            randomIDs.add((int)l.getMealid());
        }
        return randomIDs;
    }

    public Recipe convertMealToRecipe(meals meal) {
        String[] ingredients = splitIngredients(meal.getIngredients());
        String[] keywords = meal.getKeywords().split(",");
        String method = removeHTMLFromString(meal.getMethod());
        double proteinPercentage = calculateMacros(meal.getProtein()*4,meal.getKcal());
        double fatPercentage = calculateMacros(meal.getFat()*9, meal.getKcal());
        double carbPercentage = calculateMacros(meal.getCarbs()*4, meal.getKcal());
        double cookTimeInMinutes = meal.getCookTime()/60;
        double prepTimeInMinutes = meal.getPrepTime()/60;
        Optional<LabelledRecipe> optionalLabels = labelRepository.findById(meal.getMealid());
        LabelledRecipe labels = optionalLabels.orElse(new LabelledRecipe(meal.getMealid(), false, false, false, false));

        return new Recipe(meal.getMealid(), meal.getCarbs(), cookTimeInMinutes, meal.getDescription(), meal.getFat(),
                meal.getFibre(), meal.getImage_url(), ingredients, meal.getKcal(), keywords, method,
                prepTimeInMinutes, meal.getProtein(), meal.getRating(), meal.getSalt(), meal.getSaturates(),
                meal.getSugars(), meal.getTitle(), proteinPercentage, carbPercentage, fatPercentage, labels.isPre(), labels.isPost(), labels.isRecovery(), labels.isHealthy());
    }


    public String[] splitIngredients(String ingredients) {
        String[] ingredientList;
        if (!ingredients.isEmpty() && ingredients.length()>7) {
            String ingredientString = ingredients.substring(8,ingredients.length());
            ingredientList = ingredientString.split(";");
            for (int i = 0; i<ingredientList.length; i++) {
                ingredientList[i] = ingredientList[i].trim();
            }
        } else {
            ingredientList = new String[0];
        }
        return ingredientList;
    }

    public String removeHTMLFromString(String string) {
        String[] wordsToRemove = {"not set;", "<p>", "</p>", ";", "&nbsp;"};
        for (String currentWordToRemove : wordsToRemove) {
            if (string.contains(currentWordToRemove)) {
                string = string.replaceAll(currentWordToRemove, "");
                String tempWord = " " + currentWordToRemove;
                string = string.replaceAll(tempWord, "");
                tempWord = currentWordToRemove + " ";
                string = string.replaceAll(tempWord, "");
            }
        }
        return string.trim();
    }

    public double calculateMacros(long value, long kcal) {
        if (kcal != 0) {
            return (double)value/kcal;
        } else {
            return 0.0;
        }
    }

}
