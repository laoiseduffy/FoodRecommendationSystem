package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RecipeWorker {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeWorker(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
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

    public List<Recipe> advancedSearch(String one, String two) {
        List<meals> filteredMeals = findSearchCase(one,two);
        // TODO add case for vegan and vegetarian
        List<Recipe> filteredRecipes = new ArrayList<>();
        for (meals meal: filteredMeals) {
            Recipe recipe = convertMealToRecipe(meal);
            filteredRecipes.add(recipe);
        }
        return filteredRecipes;
    }

    public List<meals> findSearchCase(String one, String two) {
        List<meals> filteredMeals = null;
        if (one.contains("low") && two.contains("low")) {
            filteredMeals = recipeRepository.findLowLowCustomSearch(findNutritionalValue(one),findNutritional(one),findNutritionalValue(two),findNutritional(two));
        } else if (one.contains("low") && two.contains("high")) {
            filteredMeals = recipeRepository.findLowHighCustomSearch(findNutritionalValue(one),findNutritional(one),findNutritionalValue(two),findNutritional(two));
        } else if (one.contains("high") && two.contains("low")) {
            filteredMeals = recipeRepository.findLowHighCustomSearch(findNutritionalValue(two),findNutritional(two),findNutritionalValue(one),findNutritional(one));
        } else if (one.contains("high") && two.contains("high")) {
            filteredMeals = recipeRepository.findHighHighCustomSearch(findNutritionalValue(one),findNutritional(one),findNutritionalValue(two),findNutritional(two));
        }
        return filteredMeals;
    }

    public Long findNutritionalValue(String param) {
        long value = 0L;
        switch (param) {
            case "low cal":
            case "high cal":
                value = 500L;
                break;
            case "low fat":
            case "high fat":
                value = 10L;
                break;
        }
        return value;
    }

    public String findNutritional(String param) {
        String nutrition = "";
        switch (param) {
            case "low cal":
            case "high cal":
                nutrition = "kcal";
                break;
            case "low fat":
            case "high fat":
                nutrition = "fat";
                break;
        }
        return nutrition;
    }

    public Recipe getMealById(Long mealId) {
        meals meal = recipeRepository.findById(mealId).orElse(null);
        return convertMealToRecipe(meal);
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
        double cookTimeInMinutes = meal.getCookTime()/60.0;
        double prepTimeInMinutes = meal.getPrepTime()/60.0;

        return new Recipe(meal.getMealid(), meal.getCarbs(), cookTimeInMinutes, meal.getDescription(), meal.getFat(),
                meal.getFibre(), meal.getImage_url(), ingredients, meal.getKcal(), keywords, method,
                prepTimeInMinutes, meal.getProtein(), meal.getRating(), meal.getSalt(), meal.getSaturates(),
                meal.getSugars(), meal.getTitle(), proteinPercentage, carbPercentage, fatPercentage);
    }

    public String[] splitIngredients(String ingredients) {
        String[] ingredientList = new String[0];
        if (ingredients.length() > 8) {
            String ingredientString = ingredients.substring(8);
            ingredientList = ingredientString.split(";");
            for (int i = 0; i<ingredientList.length; i++) {
                ingredientList[i] = ingredientList[i].trim();
            }
        } else {
            System.out.println(ingredients);
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
