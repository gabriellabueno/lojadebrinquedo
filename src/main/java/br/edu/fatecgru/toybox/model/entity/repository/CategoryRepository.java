package br.edu.fatecgru.toybox.model.entity.repository;

import br.edu.fatecgru.toybox.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
