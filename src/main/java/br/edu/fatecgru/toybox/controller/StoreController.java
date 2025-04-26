package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private ToyService toyService;

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


    @GetMapping("admin/dashboard")
    public String adminDashboard(Model model) {
        List<ToyEntity> toys = toyService.findAll();

        if( toys.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else {
            model.addAttribute("toys", toys);
        }

        return "pages/admin/dashboard";
    }


    @GetMapping("/about")
    public String about() {
        return "pages/about";
    }

}
