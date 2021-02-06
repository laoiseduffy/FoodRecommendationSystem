package com.example;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<meals, Long> {

    @Query(value = "SELECT * FROM fooddb.meals WHERE kcal < :nutritionRequest1 AND " +
            "fat < :nutritionRequest2 AND ingredients like %:meat% AND ingredients like %:carbs%", nativeQuery = true)
    List<meals> findLowLowCustomSearch(@Param("nutritionRequest1") Long nutritionRequest1,
                                       @Param("nutritionRequest2") Long nutritionRequest2,
                                       @Param("meat") String meat,
                                       @Param("carbs") String carbs);

    //select * from fooddb.meals where
    //    kcal > 500 and
    //    fat < 10 and
    //    ingredients like '%chicken%'

}

