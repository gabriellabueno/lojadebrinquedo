package br.edu.fatecgru.toybox.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("store")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/catalog")
    public String getAll(Model model) {
        List<CategoryEntity> categories = service.findAll();

        if( categories.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else
            model.addAttribute("categories", categories);

        return "catalog/catalog";
    }

}
