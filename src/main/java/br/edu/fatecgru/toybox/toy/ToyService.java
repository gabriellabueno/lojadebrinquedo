package br.edu.fatecgru.toybox.toy;

import br.edu.fatecgru.toybox.category.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {

    @Autowired
    private ToyRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;


    public List<ToyEntity> findAll() {
        return repository.findAll();
    }

    public List<ToyEntity>findAllByCategoryId(Integer id) {
        return repository.findAllByCategoryId(id);
    }

    public ToyEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public ToyEntity create(ToyEntity obj) {

        ToyEntity toy = repository.findByName( obj.getName() );
        if (toy != null ) {
            throw new IllegalArgumentException(
                    "Brinquedo já cadastrado com nome: " + obj.getName() );
        }

        boolean categoryExists = categoryRepository.existsById( obj.getCategoryId() );
        if (!categoryExists) {
            throw new IllegalArgumentException(
                    "Categoria não encontrada com ID: " + obj.getCategoryId() );
        }

        return repository.save(obj);
    }


    public ToyEntity update(Integer id, ToyEntity obj) {

        ToyEntity toy = repository.findById(id).get();

        if ( toy.getId().equals(id) ) {
            throw new IllegalArgumentException(
                    "Brinquedo não encontrado com ID: " + id);
        }

        boolean categoryExists = categoryRepository.existsById( obj.getCategoryId() );
        if ( !categoryExists ) {
            throw new IllegalArgumentException(
                    "Categoria não encontrada com ID: " + obj.getCategoryId());
        }

        toy.setName(obj.getName());
        toy.setBrand(obj.getBrand());
        toy.setPrice(obj.getPrice());
        toy.setDescription(obj.getDescription());
        toy.setImageUrl(obj.getImageUrl());
        toy.setCategoryId(obj.getCategoryId());

        return repository.save(toy);
    }

    public void delete(Integer id) {
        if ( !repository.existsById(id) ) {
            throw new IllegalArgumentException(
                    "Brinquedo não encontrado com ID: " + id);
        }

        repository.deleteById(id);
    }

}
