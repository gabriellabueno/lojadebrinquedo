package br.edu.fatecgru.toybox.service;

import br.edu.fatecgru.toybox.entity.CategoryEntity;
import br.edu.fatecgru.toybox.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> findAll() {
            return categoryRepository.findAll();    }

}
