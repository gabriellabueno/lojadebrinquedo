package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.service.CategoryService;
import br.edu.fatecgru.toybox.service.ToyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Base64;


@Controller
public class ToyController {

    @Autowired
    private ToyService toyService;

    @Autowired
    private CategoryService categoryService;

    // READ
    @GetMapping("toy/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {

        ToyEntity toy = toyService.findById(id);

        if (toy != null) {
            // Converte o byte[] para Base64
            String base64Image = Base64.getEncoder().encodeToString(toy.getImage());
            model.addAttribute("toy", toy);
            model.addAttribute("imageBase64", base64Image);
        } else {
            model.addAttribute("message", "Brinquedo de ID " + id + " não encontrado.");
        }

        return "pages/toy";
    }

    // CREATE
    @GetMapping("admin/new-toy")
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

    @PostMapping("admin/new-toy")
    public String create(@ModelAttribute("toy") ToyEntity toy,
                         @RequestParam("imageFile") MultipartFile imageFile,
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

    // UPDATE
    @GetMapping("admin/update-toy/{id}")
    public String editToyForm(@PathVariable("id") Long id, Model model) {

        model.addAttribute("title", "Atualizar");
        model.addAttribute("method", "put");
        model.addAttribute("action", "/admin/update-toy/" + id);
        model.addAttribute("readOnly", true);

        model.addAttribute("toy", toyService.findById(id));
        model.addAttribute("categories", categoryService.findAll());

        return "pages/admin/create-update";
    }

    @PutMapping("admin/update-toy/{id}")
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


    // DELETE
    @DeleteMapping("admin/remove-toy/{id}")
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