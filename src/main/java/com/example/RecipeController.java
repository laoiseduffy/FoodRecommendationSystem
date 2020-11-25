package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://localhost:4200")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/recipes")
    public List<meals> getRecipes() {
        return (List<meals>) recipeRepository.findAllById(Collections.singleton(1L));
    }

    @PostMapping("/recipes")
    public void addRecipe(@RequestBody meals meal) {
        recipeRepository.save(meal);
    }
}
