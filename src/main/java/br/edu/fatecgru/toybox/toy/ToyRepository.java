package br.edu.fatecgru.toybox.toy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Integer> {

    List<Toy> findAllByCategoryId(Integer id);

    Toy findByName(String name);

}
