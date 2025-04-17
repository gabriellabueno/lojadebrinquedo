package br.edu.fatecgru.toybox.toy;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("store")
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

        return "pages/home";
    }


    // TELA CATÁLOGO - BRINQUEDO POR CATEGORIA

    @GetMapping("/catalog/category/{id}")
    public String getByCategory(@PathVariable("id") Integer id, Model model) {
        List<ToyEntity> toys = service.findAllByCategoryId(id);

        if( toys.isEmpty() ) {
            String message = "Não há brinquedos cadastrados para a categoria de ID " + id;
            model.addAttribute("message", message);
        } else
            model.addAttribute("toys", toys);

        return "pages/catalog/category";
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

        return "pages/catalog/toy";
    }


    // TELA ADMIN

    @GetMapping("/adm")
    public String getAllAdm(Model model) {
        List<ToyEntity> toys = service.findAll();

        if( toys.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else
            model.addAttribute("toys", toys);

        return "pages/adm/adm";
    }

    @PostMapping("/adm/create")
    public String create(@ModelAttribute ToyEntity toy, Model model) {
        try {
            service.create(toy);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("toy", toy);
            return "create";
        }
        return "redirect:pages/adm/create";

    }

    @PutMapping("/adm/edit/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute ToyEntity toy, Model model) {
        try {
            service.update(id, toy);
        } catch (EntityNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("toy", toy);
            return "edit";
        }
        return "redirect:pages/adm/edit";
    }

    @DeleteMapping("/adm/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:pages/adm/adm";

    }

    @GetMapping("/about")
    public String about() {
        return "pages/about";
    }


}
