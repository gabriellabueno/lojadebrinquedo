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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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
        } else {
            model.addAttribute("toys", toys);
        }

        return "pages/admin/dashboard";
    }

    @GetMapping("/new-toy")
    public String newToy(Model model) {

        model.addAttribute("readOnly", false);
        model.addAttribute("toy", new ToyEntity());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "Cadastrar");
        return "pages/admin/create";
    }

    @PostMapping("/new-toy")
    public String create(@ModelAttribute("toy") ToyEntity toy, Model model, RedirectAttributes redirectAttributes) {

        model.addAttribute("action", "Cadastrar");
        model.addAttribute("categories", categoryService.findAll());

        try {
            toyService.create(toy);
            model.addAttribute("successMessage", "Brinquedo cadastrado com sucesso!");
            return "pages/admin/create";
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("toy", toy); // Mantém os dados preenchidos
            model.addAttribute("categories", categoryService.findAll());
            return "pages/admin/create";
        }
    }

    @GetMapping("/update-toy/{id}")
    public String editToy(@PathVariable("id") Long id, Model model) {
        ToyEntity toy = toyService.findById(id);

        model.addAttribute("readOnly", true);
        model.addAttribute("toy", toy);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "Atualizar");

        return "pages/admin/update";
    }


    @PutMapping("update-toy/{id}")
    public String update(@ModelAttribute("toy") ToyEntity toy, @PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {

        model.addAttribute("action", "Atualizar");

        try {
            toyService.update(id, toy);
            model.addAttribute("successMessage", "Brinquedo atualizado com sucesso!");
            return "pages/admin/update";
        } catch (EntityNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("toy", toy);
        }

        return "pages/admin/update/" + id;

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        try {
            toyService.delete(id);
        } catch (EntityNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "pages/admin/dashboard";
    }
}