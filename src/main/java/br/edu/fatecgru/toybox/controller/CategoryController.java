package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.model.entity.Category;
import br.edu.fatecgru.toybox.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store/catalog")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> listCatalog() {
        return categoryService.listAllCategory();
    }

}
