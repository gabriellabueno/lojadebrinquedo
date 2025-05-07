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
    public ToyEntity findById(Long id) {
        return toyRepository.findById(id);
    }

   @Transactional
    public ToyEntity create(ToyEntity toy) {

        if ( toyRepository.existsById( toy.getId()) ) {
           throw new EntityExistsException(
                   "Brinquedo já cadastrado! ID: " + toy.getId() );
        }

        if ( !categoryRepository.existsById( toy.getCategoryId()) ) {
            throw new EntityNotFoundException(
                    "Categoria não encontrada com ID: " + toy.getCategoryId() );
        }


       return toyRepository.save(toy);
   }

    @Transactional
    public ToyEntity update(Long id,  ToyEntity obj) {

        if ( !toyRepository.existsById( id ) ) {
           throw new EntityNotFoundException(
                   "Brinquedo não encontrado com ID: " + id );
        }

        if ( !categoryRepository.existsById( obj.getCategoryId()) ) {
            throw new EntityNotFoundException(
                    "Categoria não encontrada com ID: " + obj.getCategoryId());
        }

        obj.setId(id);
        return toyRepository.save(obj);

    }

    @Transactional
    public void delete(Long id) {
        if ( !toyRepository.existsById(id) ) {
            throw new EntityNotFoundException(
                    "Brinquedo não encontrado com ID: " + id);
        }

        toyRepository.deleteById(id);
    }

}
