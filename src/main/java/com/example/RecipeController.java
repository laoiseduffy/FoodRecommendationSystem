package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {

    private final RecipeWorker recipeWorker;

    public RecipeController(RecipeWorker recipeWorker) {
        this.recipeWorker = recipeWorker;
    }

    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return recipeWorker.getRecommendations();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeWorker.getMealById(id);
    }

    @GetMapping("/prerecipes")
    public List<Recipe> getPreRecipes() {
        return  recipeWorker.getPreRecipes();
    }

    @GetMapping("/postrecipes")
    public List<Recipe> getPostRecipes() {
        return  recipeWorker.getPostRecipes();
    }

    @GetMapping("/recoveryrecipes")
    public List<Recipe> getRecoveryRecipes() {
        return  recipeWorker.getRecoveryRecipes();
    }

    @GetMapping("/healthyrecipes")
    public List<Recipe> getHealthyRecipes() {
        return  recipeWorker.getHealthyRecipes();
    }
}
