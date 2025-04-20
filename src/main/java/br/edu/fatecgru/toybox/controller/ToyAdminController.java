package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.service.CategoryService;
import br.edu.fatecgru.toybox.service.ToyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class ToyAdminController {

    @Autowired
    private ToyService toyService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        List<ToyEntity> toys = toyService.findAll();

        if( toys.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else
            model.addAttribute("toys", toys);

        return "admin/dashboard";
    }

    @GetMapping("/new-toy")
    public String newToy(Model model) {
        model.addAttribute("toy", new ToyEntity());
        model.addAttribute("categories", categoryService.findAll());
        return "pages/admin/create";
    }

    @PostMapping("/new-toy")
    public String create(@ModelAttribute("toy") ToyEntity toy, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "pages/admin/create";
        }

        try {
            toyService.create(toy);
            return "redirect:/admin/new-toy?success";
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("toy", toy); // Mantém os dados preenchidos
            model.addAttribute("categories", categoryService.findAll());
            return "pages/admin/create";
        }
    }


    @PutMapping("update-toy/{id}")
    public String update(@PathVariable("id")  Long id, @ModelAttribute ToyEntity toy, Model model) {
        try {
            toyService.update(id, toy);
        } catch (EntityNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("toy", toy);
            return "edit";
        }
        return "redirect:pages/admin/edit";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        try {
            toyService.delete(id);
        } catch (EntityNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:pages/admin/dashboard";
    }
}