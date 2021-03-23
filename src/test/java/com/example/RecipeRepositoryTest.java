package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void findAllByKeywordTest() {
        meals m1 = createMeal("healthy, nice, good food, summer", "chicken; fajitas", 1L);
        meals m2 = createMeal("healthy, chicken, casserole", "chicken; potatoes; potato", 2L);
        meals m3 = createMeal("indulgent, treat", "chicken", 3L);

        entityManager.persist(m1);
        entityManager.persist(m2);
        entityManager.persist(m3);
        entityManager.flush();

        List<meals> chickenMeals = recipeRepository.findAllByKeyword("chicken");
        assertThat(chickenMeals.size()).isEqualTo(3);

        List<meals> indulgentMeals = recipeRepository.findAllByKeyword("indulgent");
        assertThat(indulgentMeals.size()).isEqualTo(1);
        assertThat(indulgentMeals.get(0).getIngredients()).isEqualTo("chicken");

    }

    public List<meals> createMealsForDB() {
        List<meals> mealsList = new ArrayList<>();
        meals m1 = createMeal("healthy, nice, good food, summer", "chicken; fajitas", 1L);
        meals m2 = createMeal("healthy, chicken, casserole", "chicken; potatoes; potato", 2L);
        meals m3 = createMeal("indulgent, treat", "chicken", 3L);
        mealsList.add(m1);
        mealsList.add(m2);
        mealsList.add(m3);
        return mealsList;
    }

    public meals createMeal(String keywords, String ingredients, Long id) {
        meals meal = new meals();
        meal.setMealid(id);
        meal.setCarbs(5L);
        meal.setCookTime(1500);
        meal.setDescription("This rich red onion chutney is easy to make and will enhance any salad - or try serving it with warm goat's cheese on toast.");
        meal.setFat(1);
        meal.setFibre(1);
        meal.setImage_url("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/recipe-image-legacy-id-1074487_11-c44d11c.jpg");
        meal.setIngredients(ingredients);
        meal.setKcal(24);
        meal.setKeywords(keywords);
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


}
