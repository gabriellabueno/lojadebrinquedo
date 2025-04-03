package br.edu.fatecgru.toybox.toy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToyController {

    @Autowired
    private ToyService service;

    // TELA HOME
    @GetMapping("/home")
    public String getAll(Model model) {
        List<ToyEntity> toys = service.findAll();

        if( toys.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else
            model.addAttribute("toys", toys);

        return "home";
    }


    // TELA CATÁLOGO - BRINQUEDO POR CATEGORIA

    @GetMapping("/category/{id}")
    public String getByCategory(@PathVariable("id") Integer id, Model model) {
        List<ToyEntity> toys = service.findAllByCategoryId(id);

        if( toys.isEmpty() ) {
            String message = "Não há brinquedos cadastrados para a categoria de ID " + id;
            model.addAttribute("message", message);
        } else
            model.addAttribute("toys", toys);

        return "catalog/category";
    }

    // APRESENTAÇÃO BRINQUEDO
    @GetMapping("/toys/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        ToyEntity toy = service.findById(id);

        if (toy != null) {
            model.addAttribute("toy", toy);
        } else {
            model.addAttribute("message", "Brinquedo de ID " + id + " não encontrado.");
        }

        return "catalog/toy";
    }


    // TELA ADMIN

    @GetMapping("/adm")
    public String getAllAdm(Model model) {
        List<ToyEntity> toys = service.findAll();

        if( toys.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else
            model.addAttribute("toys", toys);

        return "adm/adm";
    }

    @PostMapping("/adm/create")
    public String create(@ModelAttribute ToyEntity toy, Model model) {
        try {
            service.create(toy);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("toy", toy);
            return "create";
        }
        return "redirect:/adm/create";

    }

    @PutMapping("/adm/edit/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute ToyEntity toy, Model model) {
        try {
            service.update(id, toy);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("toy", toy);
            return "edit";
        }
        return "redirect:/adm/edit";
    }

    @DeleteMapping("/adm/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        try {
            service.delete(id);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/adm";

    }


}
