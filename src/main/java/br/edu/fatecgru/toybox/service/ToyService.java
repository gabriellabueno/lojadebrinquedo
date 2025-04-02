package br.edu.fatecgru.toybox.service;

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

    public List<Toy> listAll() {
        return toyRepository.findAll();
    }

    public List<Toy> listByCategory(Integer id) {
        return toyRepository.findByCategoryId(id);
    }

    public Toy getById(Integer id) {
        return toyRepository.findById(id).get();
    }

    public void insert(Toy toy) {
        toyRepository.save(toy);
    }

    public void update(Integer id, Toy toyRequest) {

        Toy toy = toyRepository.findById(id).get();

        toy.setName(toyRequest.getName());
        toy.setPrice(toyRequest.getPrice());
        toy.setBrand(toyRequest.getBrand());
        toy.setImageUrl(toyRequest.getImageUrl());
        toy.setDescription(toyRequest.getDescription());
        toy.setCategoryId(toyRequest.getCategoryId());

        toyRepository.save(toy);
    }

    public void remove(Integer id) {
        toyRepository.deleteById(id);
    }


}
