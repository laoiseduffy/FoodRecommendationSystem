package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/recipes")
    public List<meals> getRecipes() {
        System.out.println("At the GET!");

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
}
