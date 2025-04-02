package br.edu.fatecgru.toybox.model.entity.repository;

import br.edu.fatecgru.toybox.model.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/* REPOSITORY | Camada de Acesso a Dados
 * Usa métodos CRUD herdados da classe JPA
 * Substitui classe DAO
 */

public interface ToyRepository extends JpaRepository<Toy, Integer> {

    List<Toy> findByCategoryId(Integer id);

}
