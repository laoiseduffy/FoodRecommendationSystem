import com.example.LabelRepository;
import com.example.RecipeRepository;
import com.example.RecipeWorker;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class RecipeWorkerTest {

    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private LabelRepository labelRepository;

    @InjectMocks
    private final RecipeWorker recipeWorker = new RecipeWorker(recipeRepository, labelRepository);

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

}
