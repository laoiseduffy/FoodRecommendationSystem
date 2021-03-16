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
    public List<Label> getPreRecipes() {
        return  recipeWorker.getPreRecipes();
    }
}
