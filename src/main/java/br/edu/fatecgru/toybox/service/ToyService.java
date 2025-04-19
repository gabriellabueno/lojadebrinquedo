package br.edu.fatecgru.toybox.service;

import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.repository.CategoryRepository;

import br.edu.fatecgru.toybox.repository.ToyRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    // @Transacional = reutiliza a mesma conexão do BD para todas as operações do metodo
    // garante Commit se tudo der certo e Rollback e ocorrer exceção

    @Transactional(readOnly = true)
    public List<ToyEntity> findAll() {
        return toyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ToyEntity>findAllByCategoryId(Integer id) {
        return toyRepository.findAllByCategoryId(id);
    }

    @Transactional(readOnly = true)
    public ToyEntity findById(Integer id) {
        return toyRepository.findById(id).orElse(null);
    }

   @Transactional
    public ToyEntity create(ToyEntity obj) {

        if ( toyRepository.existsByName(obj.getName()) ) {
            throw new EntityExistsException(
                    "Brinquedo já cadastrado com nome: " + obj.getName() );
        }

//        if ( !categoryRepository.existsById( obj.getCategoryId()) ) {
//            throw new EntityNotFoundException(
//                    "Categoria não encontrada com ID: " + obj.getCategoryId() );
//        }


        ToyEntity toy = new ToyEntity();
        return getToyEntity(obj, toy);
   }

    @Transactional
    public ToyEntity update(Integer id, ToyEntity obj) {

        if ( !toyRepository.existsById(id) ) {
            throw new EntityNotFoundException(
                    "Brinquedo não encontrado com ID: " + id);
        }

        if ( !categoryRepository.existsById( obj.getCategoryId()) ) {
            throw new EntityNotFoundException(
                    "Categoria não encontrada com ID: " + obj.getCategoryId());
        }

        ToyEntity toy = toyRepository.findById(id).get();
        return getToyEntity(obj, toy);
    }

    private ToyEntity getToyEntity(ToyEntity obj, ToyEntity toy) {
        toy.setName(        obj.getName());
        toy.setBrand(       obj.getBrand());
        toy.setPrice(       obj.getPrice());
        toy.setDescription( obj.getDescription());
        toy.setImageUrl(    obj.getImageUrl());
        toy.setCategoryId(  obj.getCategoryId());

        return toyRepository.save(toy);
    }

    public void delete(Integer id) {
        if ( !toyRepository.existsById(id) ) {
            throw new EntityNotFoundException(
                    "Brinquedo não encontrado com ID: " + id);
        }

        toyRepository.deleteById(id);
    }

}
