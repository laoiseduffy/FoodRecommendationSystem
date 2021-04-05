package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})

public class RecipeControllerIntegrationTest {

    @Autowired
    RecipeController recipeController;

    MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:4200/recipes/3"))
                .andExpect(status().isOk());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        assertThat(contentAsString).contains("Exotic avocado salad");
        assertThat(contentAsString).doesNotContain("not set;");
    }

    @Test
    public void getPreRecipesTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:4200/prerecipes"))
                .andExpect(status().isOk());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        assertThat(contentAsString).contains("Exotic avocado salad");
        assertThat(contentAsString).doesNotContain("not set;");
    }

    @Test
    public void getPostRecipes() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:4200/postrecipes"))
                .andExpect(status().isOk());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        assertThat(contentAsString).contains("Exotic avocado salad");
        assertThat(contentAsString).doesNotContain("not set;");
    }

    @Test
    public void getRecoveryRecipes() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:4200/recoveryrecipes"))
                .andExpect(status().isOk());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        assertThat(contentAsString).contains("Exotic avocado salad");
        assertThat(contentAsString).doesNotContain("not set;");
    }

    @Test
    public void getHealthyRecipes() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:4200/healthyrecipes"))
                .andExpect(status().isOk());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        assertThat(contentAsString).contains("Exotic avocado salad");
        assertThat(contentAsString).doesNotContain("not set;");
    }

    @Test
    public void getByKeywordTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:4200/keyword/hello"))
                .andExpect(status().isOk());
    }

}
