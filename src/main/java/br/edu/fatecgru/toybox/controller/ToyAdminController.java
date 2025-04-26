package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.service.CategoryService;
import br.edu.fatecgru.toybox.service.ToyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String newToyForm(Model model) {

        model.addAttribute("title", "Cadastrar");
        model.addAttribute("method", "post");
        model.addAttribute("action", "/admin/new-toy");
        model.addAttribute("readOnly", false);
        model.addAttribute("categories", categoryService.findAll());

        // Se o atributo "toy" estiver presente nos Flash Attributes (após erro),
        // é automaticamente adicionado ao Model
        // Caso contrário, novo ToyEntity é criado
        if (!model.containsAttribute("toy")) {
            model.addAttribute("toy", new ToyEntity());
        }

        return "pages/admin/create-update";
    }

    @PostMapping("/new-toy")
    public String create(@ModelAttribute("toy") ToyEntity toy,
                         RedirectAttributes redirectAttributes) {

        try {
            toyService.create(toy);
            redirectAttributes.addFlashAttribute("successMessage",
                    "Brinquedo cadastrado com sucesso!");
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());

            // Mantém dados preenchidos via Flash Attribute
            redirectAttributes.addFlashAttribute("toy", toy);
        }

        return "redirect:/admin/new-toy";
    }



    @GetMapping("/update-toy/{id}")
    public String editToyForm(@PathVariable("id") Long id, Model model) {

        model.addAttribute("title", "Atualizar");
        model.addAttribute("method", "put");
        model.addAttribute("action", "/admin/update-toy/" + id);
        model.addAttribute("readOnly", true);

        model.addAttribute("toy", toyService.findById(id));
        model.addAttribute("categories", categoryService.findAll());

        return "pages/admin/create-update";
    }

    @PutMapping("update-toy/{id}")
    public String update(@ModelAttribute("toy") ToyEntity toy,
                         @PathVariable("id") Long id,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        try {
            toyService.update(id, toy);
            redirectAttributes.addFlashAttribute("successMessage",
                    "Brinquedo atualizado com sucesso!");
        } catch (EntityNotFoundException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        }

        model.addAttribute("toy", toy); // Mantém dados preenchidos

        return "redirect:/admin/update-toy/" + id;
    }


    @DeleteMapping("remove-toy/{id}")
    public String delete(@PathVariable("id") Long id,
                         RedirectAttributes redirectAttributes) {

        try {
            toyService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage",
                    "Brinquedo removido com sucesso!");
        } catch (EntityNotFoundException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        }

        return "redirect:/admin/dashboard";
    }
}