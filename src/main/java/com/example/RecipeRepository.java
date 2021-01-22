package com.example;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<meals, Long> {

    @Query(value = "SELECT * FROM fooddb.meals WHERE :nutrition1 < :value1 AND " +
            ":nutrition2 < :value2", nativeQuery = true)
    List<meals> findLowLowCustomSearch(@Param("value1") Long value1,
                                       @Param("nutrition1") String nutrition1,
                                       @Param("value2") Long value2,
                                       @Param("nutrition2") String nutrition2);

    @Query(value = "SELECT * FROM fooddb.meals WHERE :nutrition1 < :value1 AND " +
            ":nutrition2 > :value2", nativeQuery = true)
    List<meals> findLowHighCustomSearch(@Param("value1") Long value1,
                                       @Param("nutrition1") String nutrition1,
                                       @Param("value2") Long value2,
                                       @Param("nutrition2") String nutrition2);

    @Query(value = "SELECT * FROM fooddb.meals WHERE :nutrition1 > :value1 AND " +
            ":nutrition2 > :value2", nativeQuery = true)
    List<meals> findHighHighCustomSearch(@Param("value1") Long value1,
                                       @Param("nutrition1") String nutrition1,
                                       @Param("value2") Long value2,
                                       @Param("nutrition2") String nutrition2);



//    @Query(value = "SELECT * FROM fooddb.meals WHERE kcal < :nutritionRequest1 AND " +
//            "fat > :nutritionRequest2 AND ingredients like %:meat% AND ingredients like %:carbs%", nativeQuery = true)
//    List<meals> findLowHighCustomSearch(@Param("nutritionRequest1") Long nutritionRequest1,
//                                       @Param("nutritionRequest2") Long nutritionRequest2,
//                                       @Param("meat") String meat,
//                                       @Param("carbs") String carbs);
//
//    @Query(value = "SELECT * FROM fooddb.meals WHERE kcal > :nutritionRequest1 AND " +
//            "fat > :nutritionRequest2 AND ingredients like %:meat% AND ingredients like %:carbs%", nativeQuery = true)
//    List<meals> findHighHighCustomSearch(@Param("nutritionRequest1") Long nutritionRequest1,
//                                        @Param("nutritionRequest2") Long nutritionRequest2,
//                                        @Param("meat") String meat,
//                                        @Param("carbs") String carbs);

}

