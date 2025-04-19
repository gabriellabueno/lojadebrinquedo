package br.edu.fatecgru.toybox.repository;

import br.edu.fatecgru.toybox.entity.ToyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToyRepository extends JpaRepository<ToyEntity, Integer> {

    List<ToyEntity> findAllByCategoryId(Integer id);


    boolean existsByName(String name);
}
