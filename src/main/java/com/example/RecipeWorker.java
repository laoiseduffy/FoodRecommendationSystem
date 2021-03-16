package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    public List<Recipe> getRecommendations() {
        List<meals> allMeals = (List<meals>) recipeRepository.findAll();
        List<meals> randomMeals = getRandomTenMeals(allMeals);
        List<Recipe> recipeList = new ArrayList<>();
        for (meals meal: randomMeals) {
            Recipe recipe = convertMealToRecipe(meal);
            recipeList.add(recipe);
        }
        return recipeList;
    }

    public Recipe getMealById(Long mealId) {
        meals meal = recipeRepository.findById(mealId).orElse(null);
        return convertMealToRecipe(meal);
    }

    public List<Label> getPreRecipes() {
        List<Label> recipeList = new ArrayList<>();
        List<LabelledRecipe> preRecipes = labelRepository.findAllByPre(Boolean.TRUE);
        for (LabelledRecipe recipe: preRecipes) {
            Label label = convertLabelledRecipeToLabel(recipe);
            recipeList.add(label);
        }
        return recipeList;
    }

    public List<Label> getPostRecipes() {
        List<Label> recipeList = new ArrayList<>();
        List<LabelledRecipe> postRecipes = labelRepository.findAllByPost(Boolean.TRUE);
        for (LabelledRecipe recipe: postRecipes) {
            Label label = convertLabelledRecipeToLabel(recipe);
            recipeList.add(label);
        }
        return recipeList;
    }

    public List<Label> getRecoveryRecipes() {
        List<Label> recipeList = new ArrayList<>();
        List<LabelledRecipe> recoveryRecipes = labelRepository.findAllByRecovery(Boolean.TRUE);
        for (LabelledRecipe recipe: recoveryRecipes) {
            Label label = convertLabelledRecipeToLabel(recipe);
            recipeList.add(label);
        }
        return recipeList;
    }

    public List<Label> getHealthyRecipes() {
        List<Label> recipeList = new ArrayList<>();
        List<LabelledRecipe> healthyRecipes = labelRepository.findAllByHealthy(Boolean.TRUE);
        for (LabelledRecipe recipe: healthyRecipes) {
            Label label = convertLabelledRecipeToLabel(recipe);
            recipeList.add(label);
        }
        return recipeList;
    }

    public Label convertLabelledRecipeToLabel(LabelledRecipe preRecipe) {
        return new Label(preRecipe.getMealid(), preRecipe.isPre(), preRecipe.isPost(), preRecipe.isRecovery(), preRecipe.isHealthy());
    }

    public List<meals> getRandomTenMeals(List<meals> allMeals) {
        Random rand = new Random();
        List<meals> randomMeals = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int randInt = rand.nextInt(allMeals.size());
            meals m = allMeals.get(randInt);
            randomMeals.add(m);
        }
        return randomMeals;
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

        return new Recipe(meal.getMealid(), meal.getCarbs(), cookTimeInMinutes, meal.getDescription(), meal.getFat(),
                meal.getFibre(), meal.getImage_url(), ingredients, meal.getKcal(), keywords, method,
                prepTimeInMinutes, meal.getProtein(), meal.getRating(), meal.getSalt(), meal.getSaturates(),
                meal.getSugars(), meal.getTitle(), proteinPercentage, carbPercentage, fatPercentage);
    }

    public String[] splitIngredients(String ingredients) {
        String ingredientString = ingredients.substring(8,ingredients.length());
        String[] ingredientList = ingredientString.split(";");
        for (int i = 0; i<ingredientList.length; i++) {
            ingredientList[i] = ingredientList[i].trim();
        }
        return ingredientList;
    }

    public String removeHTMLFromString(String string) {
        String[] wordsToRemove = {"not set;", "<p>", "</p>", ";"};
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
