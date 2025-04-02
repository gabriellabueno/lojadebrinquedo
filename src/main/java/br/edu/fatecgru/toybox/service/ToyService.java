package br.edu.fatecgru.toybox.service;

import br.edu.fatecgru.toybox.model.entity.Category;
import br.edu.fatecgru.toybox.model.entity.Toy;
import br.edu.fatecgru.toybox.model.entity.repository.ToyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* SERVICE | Camada de Lógica de Negócio
 * Atua entre Controller e Repository
 * Garante validações e cálculos antes do acesso aos dados
 */

@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;

    public List<Toy> listAllToy() {
        return toyRepository.findAll();
    }

    public Toy getToyById(Integer id) {
        return toyRepository.findById(id).get();
    }

    public void insertToy(Toy toy) {
        toyRepository.save(toy);
    }

    public void updateToy(Toy toy) {
        toyRepository.save(toy);
    }

    public void removeToy(Integer id) {
        toyRepository.deleteById(id);
    }

}
