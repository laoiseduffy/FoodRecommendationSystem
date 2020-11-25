package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(RecipeRepository recipeRepository) {
        System.out.println("Hello");
        List<meals> meals = (List<meals>) recipeRepository.findAllById(Collections.singleton(1L));
        return args -> {
            System.out.println(meals);
        };
    }

}
