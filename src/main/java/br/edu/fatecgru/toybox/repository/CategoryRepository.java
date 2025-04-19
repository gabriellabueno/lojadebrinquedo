package br.edu.fatecgru.toybox.repository;

import br.edu.fatecgru.toybox.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {


}
