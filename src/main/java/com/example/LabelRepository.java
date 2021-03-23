package com.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends CrudRepository<LabelledRecipe, Long> {
    List<LabelledRecipe> findAllByPre(Boolean pre);
    List<LabelledRecipe> findAllByPost(Boolean post);
    List<LabelledRecipe> findAllByRecovery(Boolean recovery);
    List<LabelledRecipe> findAllByHealthy(Boolean healthy);
}
