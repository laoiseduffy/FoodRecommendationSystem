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
    public List<meals> getRecipes() {
        System.out.println("At the GET!");
        return recipeWorker.getRecommendations();
    }

//    @PostMapping("/recipes")
//    public void addRecipe(@RequestBody meals meal) {
//        recipeRepository.save(meal);
//    }
}
