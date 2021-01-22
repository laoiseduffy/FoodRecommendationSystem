import com.example.Recipe;
import com.example.RecipeRepository;
import com.example.RecipeWorker;
import com.example.meals;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RecipeWorkerTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private final RecipeWorker recipeWorker = new RecipeWorker(recipeRepository);

    @Test
    public void splitIngredientsTest() {
        String ingredientsFromDb = "not set; small  aubergine, trimmed and cut into chunks ; courgette trimmed and cut into chunks ; red onion, thinly sliced; garlic cloves, unpeeled and left whole; olive oil; tomato; penne pasta ; basil leaves";
        String[] splitIngredients = recipeWorker.splitIngredients(ingredientsFromDb);
        assertThat(splitIngredients.length).isEqualTo(8);
        assertThat(splitIngredients[4]).isEqualTo("olive oil");
    }

    @Test
    public void removeHTMLFromStringTest() {
        String methodBefore = "not set; <p>If your barbecue hasn&rsquo;t already been heated, light and heat until the ashes turn grey. Put the potatoes in a large saucepan of cold water and bring to the boil. Once boiling, cook for 5 mins until slightly tender.</p>; <p>Drain and leave to steam-dry for 2 mins. Transfer to a large sheet of foil, coat in the olive oil and season well. Make sure the potatoes are sitting flat against the foil so each one gets charred when grilled. Wrap in the foil like a parcel, and wrap again to ensure the potatoes are completely covered. Cook on the barbecue for 10 mins.</p>; <p>Check they are cooked by inserting a skewer into one of the potatoes. Carefully remove from the foil and serve in a dish.</p>";
        String methodAfter = recipeWorker.removeHTMLFromString(methodBefore);
        assertThat(methodAfter.contains("<p>")).isFalse();
        assertThat(methodAfter.contains("not set;")).isFalse();
        assertThat(methodAfter.contains("</p>")).isFalse();
        assertThat(methodAfter.contains(";")).isFalse();
    }

    @Test
    public void calculateMacros() {
        long value = 90;
        long kcal = 300;
        double perc = recipeWorker.calculateMacros(value, kcal);
        assertThat(perc).isEqualTo(0.3);
    }

    @Test
    public void advancedSearchTest() {

        meals meal1 = new meals(1L, 45L, 5400, "Cold nights require comfort food", 4L, 8, "imageurl", "not set; baking potatoes; sunflower oil; carrot, diced; celerystalk, diced; can haricot beans, drained; tomatoes, chopped; paprika- choose sweet or hot depending on taste; Worcestershire sauce; chopped chives, to serve", 237, "Carrot, Carrots, Easy, Five a day, Low fat, Super healthy, Vitamin c, Worcestershire sauce, Baked potato fillings, Baking potato, Baking potatoes, Cowboy beans, Haricot bean, Haricot beans, Home-made baked beans, Jacket potatoes, Paprika, Silvana Franco",
                "not set; <p>Heat oven to 200C/180C fan/gas 6. Scrub the potatoes and dry well, then prick in several places with a fork. Bake directly on the oven shelf for 1-1&frac12; hrs, until they feel soft when squeezed.</p>; <p>After 30 mins, heat the oil in a pan and gently cook the carrot and celery for 10 mins until softened. Add the beans, tomatoes and paprika and cook gently for a further 5 mins until the tomatoes are softened and pulpy. Stir in 100ml water and the Worcestershire sauce, cook for a further 5 mins then cover and keep warm.</p>; <p>Split open the potatoes and spoon in the beans. Scatter with chives and serve.</p>",
                600, 8, 3.55, 0, 0, 5, "Jacket potatoes with home-baked beans");
        List<meals> meals = null;
        meals.add(meal1);

        meals meal2 = new meals(2L, 136L, 5400, "Cold nights require comfort food", 9L, 8, "imageurl", "not set; baking potatoes; sunflower oil; carrot, diced; celerystalk, diced; can haricot beans, drained; tomatoes, chopped; paprika- choose sweet or hot depending on taste; Worcestershire sauce; chopped chives, to serve", 783, "Carrot, Carrots, Easy, Five a day, Low fat, Super healthy, Vitamin c, Worcestershire sauce, Baked potato fillings, Baking potato, Baking potatoes, Cowboy beans, Haricot bean, Haricot beans, Home-made baked beans, Jacket potatoes, Paprika, Silvana Franco",
                "not set; <p>Heat oven to 200C/180C fan/gas 6. Scrub the potatoes and dry well, then prick in several places with a fork. Bake directly on the oven shelf for 1-1&frac12; hrs, until they feel soft when squeezed.</p>; <p>After 30 mins, heat the oil in a pan and gently cook the carrot and celery for 10 mins until softened. Add the beans, tomatoes and paprika and cook gently for a further 5 mins until the tomatoes are softened and pulpy. Stir in 100ml water and the Worcestershire sauce, cook for a further 5 mins then cover and keep warm.</p>; <p>Split open the potatoes and spoon in the beans. Scatter with chives and serve.</p>",
                600, 23, 3.55, 0, 0, 5, "High Cal, Low Fat");


        when(recipeRepository.findLowLowCustomSearch(500L, "kcal", 10L, "fat")).thenReturn(meals);

        // test one = low cal, low fat
        // test two = low fat, high cal
        // test three = high cal, low fat
        // test four = high fat, high cal

        //public List<Recipe> advancedSearch(String one, String two) {

        String lowCal = "low cal";
        String lowFat = "low fat";
        String highCal = "high cal";
        String highFat = "high fat";

        //Test One
        List<Recipe> recipeList = recipeWorker.advancedSearch(lowCal, lowFat);
    }

}
