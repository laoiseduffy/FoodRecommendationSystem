package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

public class RecipeWorker {

    private final RecipeRepository recipeRepository;

    public RecipeWorker(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Autowired
    public List<meals> getRecommendations() {
        List<meals> allMeals = (List<meals>) recipeRepository.findAll();
        Random rand = new Random();
        List<meals> recommendedMeals = null;
        for (int i = 0; i < 10; i++) {
            meals m = allMeals.get(rand.nextInt(allMeals.size()));
            recommendedMeals.add(m);
        }
        return recommendedMeals;
    }
}
