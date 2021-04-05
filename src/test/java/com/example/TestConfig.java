package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class TestConfig {

    @Bean
    public RecipeRepository recipeRepository() {
        return new RecipeRepository() {
            @Override
            public <S extends meals> S save(S s) {
                return null;
            }

            @Override
            public <S extends meals> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<meals> findById(Long aLong) {
                return mealExample();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<meals> findAll() {
                return null;
            }

            @Override
            public Iterable<meals> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(meals meals) {

            }

            @Override
            public void deleteAll(Iterable<? extends meals> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<meals> findAllByKeyword(String word) {
                return mealListExample();
            }
        };
    }

    @Bean
    public LabelRepository labelRepository() {
        return new LabelRepository() {
            @Override
            public List<LabelledRecipe> findAllByPre(Boolean pre) {
                return labelledRecipesExample();
            }

            @Override
            public List<LabelledRecipe> findAllByPost(Boolean post) {
                return labelledRecipesExample();
            }

            @Override
            public List<LabelledRecipe> findAllByRecovery(Boolean recovery) {
                return labelledRecipesExample();
            }

            @Override
            public List<LabelledRecipe> findAllByHealthy(Boolean healthy) {
                return labelledRecipesExample();
            }

            @Override
            public <S extends LabelledRecipe> S save(S s) {
                return null;
            }

            @Override
            public <S extends LabelledRecipe> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<LabelledRecipe> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<LabelledRecipe> findAll() {
                return null;
            }

            @Override
            public Iterable<LabelledRecipe> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(LabelledRecipe labelledRecipe) {

            }

            @Override
            public void deleteAll(Iterable<? extends LabelledRecipe> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

    @Bean
    public RecipeWorker recipeWorker() {
        return new RecipeWorker(recipeRepository(), labelRepository());
    }

    @Bean
    public RecipeController recipeController() {
        return new RecipeController(recipeWorker());
    }

    public List<meals> mealListExample() {
        List<meals> mealsList = new ArrayList<>();
        mealsList.add(mealExample().orElse(null));
        mealsList.add(mealExample().orElse(null));
        return mealsList;
    }

    public Optional<meals> mealExample() {
        meals m = new meals();
        m.setMealid(3);
        m.setCarbs(11);
        m.setCookTime(1200);
        m.setDescription("Savour sharp, sweet flavours in this exotic avocado salad");
        m.setFat(22);
        m.setFibre(5);
        m.setImage_url("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/recipe-image-legacy-id-381451_12-794c668.jpg");
        m.setIngredients("not set; 2 tbsp  pumpkin seeds; ripe papaya; ripe avocado; bag trimmed and washed watercress; half small pack fresh mint; juice of half lime; 1 tbsp  olive oil");
        m.setKcal(260);
        m.setKeywords("Advocado, Avocado, Avocados, BBC Good Food, Caribbean, Emma Sharp, Good Food, Lime, Limes, Mint, Papaya, Papayas, Pumpkin seed, Pumpkin seeds, Salad, Watercress");
        m.setMethod("not set; <p>Dry-fry the pumpkin seeds in a frying pan for a few minutes, tossing and turning them until they look toasted. Tip them out of the pan and let them go cold. Peel the papayas, halve them lengthways and scoop out the seeds. Cut the flesh into long, thin slices. Halve the avocados and remove the stones, then peel off the skin and slice the flesh lengthways into thin slices.</p>; <p>Put the papayas, avocados, pumpkin seeds and watercress into a large bowl. Chop about 1 tbsp of the mint leaves and set aside. Pick the remaining leaves from the stalks and tear them into the bowl.</p>; <p>Mix the lime juice and olive oil with the rest of the chopped mint to make a dressing, and season with salt and pepper to taste. Pour over the salad and gently mix all the ingredients together with your hands. Taste and add more salt and pepper if you think it needs it, then transfer to a serving platter.</p>");
        m.setPrepTime(0);
        m.setProtein(4);
        m.setRating(4.15);
        m.setSalt(0);
        m.setSaturates(3);
        m.setSugars(5);
        m.setTitle("Exotic avocado salad");
        return Optional.of(m);
    }

    public List<LabelledRecipe> labelledRecipesExample() {
        LabelledRecipe recipe = new LabelledRecipe(2L, true, true, true, true);
        LabelledRecipe recipe2 = new LabelledRecipe(3L, true, true, true, true);
        List<LabelledRecipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);
        recipeList.add(recipe2);
        return recipeList;
    }
}
