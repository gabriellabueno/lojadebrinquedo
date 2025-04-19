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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private ToyService toyService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/featured-toys")
    public String getFeaturedToys(Model model) {
        List<ToyEntity> toys = toyService.findAll();

        if( toys.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else
            model.addAttribute("toys", toys);

        return "pages/home";
    }

    @GetMapping("/categories")
    public String getCategories(Model model) {
        List<CategoryEntity> categories = categoryService.findAll();

        if( categories.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else
            model.addAttribute("categories", categories);

        return "catalog/categories";
    }

    // BRINQUEDO POR CATEGORIA
    // http://localhost:8080/store/catalog/category?id=1

    @GetMapping("/category")
    public String getByCategory(@RequestParam("id") Integer id, Model model) {
        List<ToyEntity> toys = toyService.findAllByCategoryId(id);

        if( toys.isEmpty() ) {
            String message = "Não há brinquedos cadastrados para a categoria de ID " + id;
            model.addAttribute("message", message);
        } else
            model.addAttribute("toys", toys);

        return "pages/catalog/category";
    }

    // APRESENTAÇÃO BRINQUEDO
    // http://localhost:8080/store/catalog/toy/1

    @GetMapping("/toy/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        ToyEntity toy = toyService.findById(id);

        if (toy != null) {
            model.addAttribute("toy", toy);
        } else {
            model.addAttribute("message", "Brinquedo de ID " + id + " não encontrado.");
        }

        return "pages/catalog/toy";
    }

}