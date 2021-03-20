package com.example;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<meals, Long> {

    @Query(value = "SELECT * FROM fooddb.meals WHERE ingredients like %:word% AND keywords like %:word%", nativeQuery = true)
    List<meals> findAllByKeyword(@Param("word") String word);

}

