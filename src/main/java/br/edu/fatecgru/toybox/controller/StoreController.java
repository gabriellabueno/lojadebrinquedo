package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StoreController {

    @Autowired
    private ToyService toyService;

    @GetMapping("/home")
    public String getFeaturedToys(Model model) {

        // Busca todos os brinquedos
        // Filtra os brinquedos com Preço > 80
        // Coleta resultado do filtro
        List<ToyEntity> toys = toyService.findAll()
                .stream()
                .filter( toy ->  toy.getPrice().doubleValue() > 80.00)
                .collect(Collectors.toList());


        if( toys.isEmpty() ) {
            model.addAttribute("message", "Não há brinquedos cadastrados.");
        } else {
            model.addAttribute("toys", toys);
        }

        return "pages/home";
    }


    @GetMapping("/about")
    public String about() {
        return "pages/about";
    }



}
