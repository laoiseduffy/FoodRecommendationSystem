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
    public List<meals> getRecommendations() {
        List<meals> allMeals = (List<meals>) recipeRepository.findAll();
        Random rand = new Random();
        List<meals> recommendedMeals = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int randInt = rand.nextInt(allMeals.size());
            meals m = allMeals.get(randInt);
            recommendedMeals.add(m);
        }
        return recommendedMeals;
    }

    public meals getMealById(Long mealId) {
        return recipeRepository.findById(mealId).orElse(null);
    }
}
