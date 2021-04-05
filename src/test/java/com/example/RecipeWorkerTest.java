package com.example;

import com.example.*;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

public class RecipeWorkerTest {

    private RecipeRepository recipeRepository = mock(RecipeRepository.class);

    private LabelRepository labelRepository = mock(LabelRepository.class);

    @InjectMocks
    private final RecipeWorker recipeWorker = new RecipeWorker(recipeRepository, labelRepository);

    @Test
    public void getMealByIdTest() {
        meals meal = createMeal();
        when(recipeRepository.findById(555L)).thenReturn(Optional.ofNullable(meal));
        when(labelRepository.findById(555L)).thenReturn(java.util.Optional.of(new LabelledRecipe(555L, true, false, true, false)));
        Recipe recipe = recipeWorker.getMealById(555L);
        assertThat(recipe.isRecovery()).isTrue();
        assertThat(recipe.getIngredients()[1]).isEqualTo("caster sugar");
    }

    @Test
    public void invalidIDTest() {
        when(recipeRepository.findById(12345678L)).thenReturn(Optional.empty());
        Recipe recipe = recipeWorker.getMealById(12345678L);
        assertThat(recipe).isNull();
    }

    @Test
    public void unlabelledRecipeTest() {
        meals meal = createMeal();
        when(recipeRepository.findById(555L)).thenReturn(Optional.ofNullable(meal));
        when(labelRepository.findById(555L)).thenReturn(Optional.of(new LabelledRecipe()));
        Recipe recipe = recipeWorker.getMealById(555L);
        assertThat(recipe.isHealthy()).isFalse();
        assertThat(recipe.isRecovery()).isFalse();
        assertThat(recipe.isPre()).isFalse();
        assertThat(recipe.isPost()).isFalse();
    }

    @Test
    public void getByKeywordTest() {
        meals meal = createMeal();
        List<meals> mealsList = new ArrayList<>();
        mealsList.add(meal);
        when(labelRepository.findById(555L)).thenReturn(java.util.Optional.of(new LabelledRecipe(555L, true, false, true, false)));
        when(recipeRepository.findAllByKeyword("sugar")).thenReturn(mealsList);
        List<Recipe> recipes = recipeWorker.getByKeyword("sugar");
        assertThat(recipes.size()).isEqualTo(1);
        assertThat(recipes.get(0).isHealthy()).isFalse();
    }

    @Test
    public void getByKeywordInvalidTest() {
        List<meals> emptyList = new ArrayList<>();
        when(recipeRepository.findAllByKeyword("")).thenReturn(emptyList);
        List<Recipe> emptyRecipeList = recipeWorker.getByKeyword("");
        assertThat(emptyRecipeList).isEmpty();
    }

    @Test
    public void getPreRecipesTest() {
        LabelledRecipe labelledRecipe1 = new LabelledRecipe(1L, true, true, true, true);
        LabelledRecipe labelledRecipe2 = new LabelledRecipe(2L, true, false, true, true);
        LabelledRecipe labelledRecipe3 = new LabelledRecipe(3L, true, false, false, false);
        List<LabelledRecipe> labelledRecipeList = new ArrayList<>();
        labelledRecipeList.add(labelledRecipe1);
        labelledRecipeList.add(labelledRecipe2);
        labelledRecipeList.add(labelledRecipe3);
        when(labelRepository.findAllByPre(Boolean.TRUE)).thenReturn(labelledRecipeList);
        when(labelRepository.findById(any())).thenReturn(java.util.Optional.of(new LabelledRecipe(555L, true, false, true, false)));
        meals meal = createMeal();
        when(recipeRepository.findById(any())).thenReturn(Optional.ofNullable(meal));
        List<Recipe> recipeList = recipeWorker.getPreRecipes();
        assertThat(recipeList.size()).isEqualTo(3);
    }

    @Test
    public void getPostRecipesTest() {
        LabelledRecipe labelledRecipe1 = new LabelledRecipe(1L, true, true, true, true);
        LabelledRecipe labelledRecipe2 = new LabelledRecipe(2L, true, false, true, true);
        LabelledRecipe labelledRecipe3 = new LabelledRecipe(3L, true, false, false, false);
        LabelledRecipe labelledRecipe4 = new LabelledRecipe(4L, true, true, true, true);
        LabelledRecipe labelledRecipe5 = new LabelledRecipe(5L, true, false, true, true);
        LabelledRecipe labelledRecipe6 = new LabelledRecipe(6L, true, false, false, false);
        LabelledRecipe labelledRecipe7 = new LabelledRecipe(7L, true, true, true, true);
        LabelledRecipe labelledRecipe8 = new LabelledRecipe(8L, true, false, true, true);
        LabelledRecipe labelledRecipe9 = new LabelledRecipe(9L, true, false, false, false);
        LabelledRecipe labelledRecipe10 = new LabelledRecipe(10L, true, true, true, true);
        LabelledRecipe labelledRecipe11 = new LabelledRecipe(11L, true, false, true, true);
        LabelledRecipe labelledRecipe12 = new LabelledRecipe(12L, true, false, false, false);
        List<LabelledRecipe> labelledRecipeList = new ArrayList<>();
        labelledRecipeList.add(labelledRecipe1);
        labelledRecipeList.add(labelledRecipe2);
        labelledRecipeList.add(labelledRecipe3);
        labelledRecipeList.add(labelledRecipe4);
        labelledRecipeList.add(labelledRecipe5);
        labelledRecipeList.add(labelledRecipe6);
        labelledRecipeList.add(labelledRecipe7);
        labelledRecipeList.add(labelledRecipe8);
        labelledRecipeList.add(labelledRecipe9);
        labelledRecipeList.add(labelledRecipe10);
        labelledRecipeList.add(labelledRecipe11);
        labelledRecipeList.add(labelledRecipe12);
        when(labelRepository.findAllByPost(Boolean.TRUE)).thenReturn(labelledRecipeList);
        when(labelRepository.findById(any())).thenReturn(java.util.Optional.of(new LabelledRecipe(555L, true, false, true, false)));
        meals meal = createMeal();
        when(recipeRepository.findById(any())).thenReturn(Optional.ofNullable(meal));
        List<Recipe> recipes = recipeWorker.getPostRecipes();
        assertThat(recipes.size()).isEqualTo(10);
    }

    @Test
    public void getRecoveryRecipesTest() {
        List<LabelledRecipe> emptyList = new ArrayList<>();
        when(labelRepository.findAllByRecovery(Boolean.TRUE)).thenReturn(emptyList);
        List<Recipe> recipes = recipeWorker.getRecoveryRecipes();
        assertThat(recipes).isEmpty();
    }

    @Test
    public void getRecoveryRecipesValidTest() {
        LabelledRecipe labelledRecipe1 = new LabelledRecipe(1L, true, true, true, true);
        LabelledRecipe labelledRecipe2 = new LabelledRecipe(2L, true, false, true, true);
        LabelledRecipe labelledRecipe3 = new LabelledRecipe(3L, true, false, true, false);
        List<LabelledRecipe> labelledRecipeList = new ArrayList<>();
        labelledRecipeList.add(labelledRecipe1);
        labelledRecipeList.add(labelledRecipe2);
        labelledRecipeList.add(labelledRecipe3);
        when(labelRepository.findAllByRecovery(Boolean.TRUE)).thenReturn(labelledRecipeList);
        when(labelRepository.findById(any())).thenReturn(java.util.Optional.of(new LabelledRecipe(555L, true, false, true, false)));
        meals meal = createMeal();
        when(recipeRepository.findById(any())).thenReturn(Optional.ofNullable(meal));
        List<Recipe> recipeList = recipeWorker.getRecoveryRecipes();
        assertThat(recipeList.size()).isEqualTo(3);
    }

    @Test
    public void getHealthyRecipesTest() {
        LabelledRecipe labelledRecipe1 = new LabelledRecipe(1L, true, true, true, true);
        LabelledRecipe labelledRecipe2 = new LabelledRecipe(2L, true, false, true, true);
        LabelledRecipe labelledRecipe3 = new LabelledRecipe(3L, true, false, true, true);
        List<LabelledRecipe> labelledRecipeList = new ArrayList<>();
        labelledRecipeList.add(labelledRecipe1);
        labelledRecipeList.add(labelledRecipe2);
        labelledRecipeList.add(labelledRecipe3);
        when(labelRepository.findAllByHealthy(Boolean.TRUE)).thenReturn(labelledRecipeList);
        when(labelRepository.findById(any())).thenReturn(java.util.Optional.of(new LabelledRecipe(555L, true, false, true, true)));
        meals meal = createMeal();
        when(recipeRepository.findById(any())).thenReturn(Optional.ofNullable(meal));
        List<Recipe> recipeList = recipeWorker.getHealthyRecipes();
        assertThat(recipeList.size()).isEqualTo(3);
    }

    @Test
    public void splitIngredientsTest() {
        String ingredientsFromDb = "not set; small  aubergine, trimmed and cut into chunks ; courgette trimmed and cut into chunks ; red onion, thinly sliced; garlic cloves, unpeeled and left whole; olive oil; tomato; penne pasta ; basil leaves";
        String[] splitIngredients = recipeWorker.splitIngredients(ingredientsFromDb);
        assertThat(splitIngredients.length).isEqualTo(8);
        assertThat(splitIngredients[4]).isEqualTo("olive oil");
    }

    @Test
    public void removeHTMLFromStringTest() {
        String methodBefore = "not set; <p>If your barbecue hasn&rsquo;t already been heated, light and heat until the ashes turn grey. &nbsp; Put the potatoes in a large saucepan of cold water and bring to the boil. Once boiling, cook for 5 mins until slightly tender.</p>; <p>Drain and leave to steam-dry for 2 mins. Transfer to a large sheet of foil, coat in the olive oil and season well. Make sure the potatoes are sitting flat against the foil so each one gets charred when grilled. Wrap in the foil like a parcel, and wrap again to ensure the potatoes are completely covered. Cook on the barbecue for 10 mins.</p>; <p>Check they are cooked by inserting a skewer into one of the potatoes. Carefully remove from the foil and serve in a dish.</p>";
        String methodAfter = recipeWorker.removeHTMLFromString(methodBefore);
        assertThat(methodAfter.contains("<p>")).isFalse();
        assertThat(methodAfter.contains("not set;")).isFalse();
        assertThat(methodAfter.contains("</p>")).isFalse();
        assertThat(methodAfter.contains(";")).isFalse();
        assertThat(methodAfter.contains("&nbsp;")).isFalse();
    }

    @Test
    public void calculateMacros() {
        long value = 90;
        long kcal = 300;
        double perc = recipeWorker.calculateMacros(value, kcal);
        assertThat(perc).isEqualTo(0.3);
    }

    @Test
    public void convertLabelledRecipeToLabelTest() {
        LabelledRecipe labelledRecipe = new LabelledRecipe(1L, true, false, true, false);
        Label result = recipeWorker.convertLabelledRecipeToLabel(labelledRecipe);
        assertThat(result).isNotNull();
        assertThat(result.isPre()).isTrue();
        assertThat(result.isRecovery()).isTrue();
        assertThat(result.isPost()).isFalse();
        assertThat(result.isHealthy()).isFalse();
    }

    @Test
    public void convertMealToRecipeTest() {
        when(labelRepository.findById(555L)).thenReturn(java.util.Optional.of(new LabelledRecipe(555L, true, false, true, false)));
        meals meal = createMeal();
        Recipe recipe = recipeWorker.convertMealToRecipe(meal);
        assertThat(recipe.getCarbs()).isEqualTo(5L);
        assertThat(recipe.getIngredients().length).isEqualTo(5);
        assertThat(recipe.getKeywords().length).isEqualTo(14);
        assertThat(recipe.getMethod()).doesNotContain("</p>");
        assertThat(recipe.getProteinPercentage()).isEqualTo((1.0*4.0)/24.0);
        assertThat(recipe.getCookTime()).isEqualTo(1500.0/60.0);
        assertThat(recipe.isPre()).isTrue();
        assertThat(recipe.isHealthy()).isFalse();
    }

    @Test
    public void convertBlankMealToRecipeTest() {
        when(labelRepository.findById(0L)).thenReturn(Optional.empty());
        meals meal = createBlankMeal();
        Recipe blankRecipe = recipeWorker.convertMealToRecipe(meal);
        assertThat(blankRecipe.getMealid()).isEqualTo(0L);
    }

    private meals createMeal() {
        meals meal = new meals();
        meal.setMealid(555L);
        meal.setCarbs(5L);
        meal.setCookTime(1500);
        meal.setDescription("This rich red onion chutney is easy to make and will enhance any salad - or try serving it with warm goat's cheese on toast.");
        meal.setFat(1);
        meal.setFibre(1);
        meal.setImage_url("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/recipe-image-legacy-id-1074487_11-c44d11c.jpg");
        meal.setIngredients("not set; red onions, sliced; caster sugar; red wine vinegar; red wine; dash grenadine syrup");
        meal.setKcal(24);
        meal.setKeywords("BBC Good Food, Chutney, Condiment, Good Food, Grenadine, Kevin dundon, Onion chutney, Preserves, Red onion, Red onions, Red wine, Red wine vinegar, Slow cooker, Slow cooking");
        meal.setMethod("not set; <p>Place the onions and sugar in a saucepan, cover and cook over medium heat until soft, about 10 mins. Pour in the red wine vinegar and red wine, then simmer uncovered until the liquid has reduced and the mixture is sticky, about 10 mins more. Add the grenadine syrup and mix well. Leave to cool, then transfer to a sterilised jar and seal.</p>");
        meal.setPrepTime(1200);
        meal.setProtein(1);
        meal.setRating(4.65);
        meal.setSalt(0);
        meal.setSaturates(0);
        meal.setSugars(3);
        meal.setTitle("Red Onion Cutney");

        return meal;
    }

    public meals createBlankMeal() {
        meals meal = new meals();
        meal.setMealid(0);
        meal.setCarbs(0);
        meal.setCookTime(0);
        meal.setDescription("");
        meal.setFat(0);
        meal.setFibre(0);
        meal.setImage_url("");
        meal.setIngredients("");
        meal.setKcal(0);
        meal.setKeywords("");
        meal.setMethod("");
        meal.setPrepTime(0);
        meal.setProtein(0);
        meal.setRating(0);
        meal.setSalt(0);
        meal.setSaturates(0);
        meal.setSugars(0);
        meal.setTitle("");

        return meal;
    }

}
