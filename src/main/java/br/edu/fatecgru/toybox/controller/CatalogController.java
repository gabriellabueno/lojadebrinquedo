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
public class CatalogController {

    @Autowired
    private ToyService toyService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public String getFeaturedToys(Model model) {
        List<ToyEntity> toys = toyService.findAll();

        if( toys.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else {
            model.addAttribute("toys", toys);
        }

        return "pages/home";
    }

    @GetMapping("/catalog")
    public String getCategories(Model model) {
        List<CategoryEntity> categories = categoryService.findAll();

        if( categories.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else {
            model.addAttribute("categories", categories);
        }

        return "pages/catalog";
    }

    // BRINQUEDO POR CATEGORIA
    @GetMapping("/catalog/category/{categoryName}/{id}")
    public String getToysByCategory(
            @PathVariable("id") Integer categoryId,
            @PathVariable("categoryName") String categoryName,
            Model model
    ) {
        CategoryEntity category = categoryService.findById(categoryId);
        List<ToyEntity> toys = toyService.findAllByCategoryId(categoryId);
        String message = "";

        if (category == null) {
            message = "Categoria não encontrada";
            model.addAttribute("message", message);
            return "pages/category";
        }

        if (toys.isEmpty()) {
            message = "Nenhum brinquedo encontrado na categoria " + category.getName();
            model.addAttribute("message", message);
        } else {
            model.addAttribute("toys", toys);
            model.addAttribute("categoryName", category.getName());
        }

        return "pages/category";
    }

    // APRESENTAÇÃO BRINQUEDO
    // http://localhost:8080/store/catalog/toy/1

    @GetMapping("/toy/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {

        ToyEntity toy = toyService.findById(id);

        if (toy != null) {
            model.addAttribute("toy", toy);
        } else {
            model.addAttribute("message", "Brinquedo de ID " + id + " não encontrado.");
        }

        return "pages/toy";
    }

}