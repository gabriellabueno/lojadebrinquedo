package br.edu.fatecgru.toybox.model.entity.repository;

import br.edu.fatecgru.toybox.model.entity.Category;
import br.edu.fatecgru.toybox.model.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT t FROM Toy t WHERE t.category = :category")
    List<Toy> getToyByCategory(@Param("category") Category category);
}
