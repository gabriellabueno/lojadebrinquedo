package br.edu.fatecgru.toybox.service;

import br.edu.fatecgru.toybox.model.entity.Category;
import br.edu.fatecgru.toybox.model.entity.Toy;
import br.edu.fatecgru.toybox.model.entity.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listAllCategory() {
        return categoryRepository.findAll();
    }

    public List<Toy> listToyByCategory(Category category) {
        return categoryRepository.getToyByCategory(category);
    }
}
