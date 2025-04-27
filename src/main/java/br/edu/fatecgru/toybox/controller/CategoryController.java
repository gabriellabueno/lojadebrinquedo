package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.entity.CategoryEntity;
import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.service.CategoryService;
import br.edu.fatecgru.toybox.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ToyService toyService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("category")
    public String getCategories(Model model) {
        List<CategoryEntity> categories = categoryService.findAll();

        if( categories.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else {
            model.addAttribute("categories", categories);
        }

        return "pages/catalog";
    }

    // BRINQUEDOS DA CATEGORIA
    @GetMapping("category/{name}/{id}")
    public String getCategoryToys(
            @PathVariable("id") Integer categoryId,
            Model model
    ) {
        CategoryEntity category = categoryService.findById(categoryId);
        List<ToyEntity> toys = toyService.findAllByCategoryId(categoryId);
        String message = "";

        if (category == null) {
            message = "Categoria não encontrada";
            model.addAttribute("message", message);
            return "pages/category";
        } else

        if (toys.isEmpty()) {
            message = "Nenhum brinquedo encontrado na categoria " + category.getName();
            model.addAttribute("message", message);
        } else {
            model.addAttribute("toys", toys);
            model.addAttribute("categoryName", category.getName());
        }

        return "pages/category";
    }



}