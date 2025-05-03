package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.entity.UserEntity;
import br.edu.fatecgru.toybox.service.AuthService;
import br.edu.fatecgru.toybox.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private ToyService toyService;

    @Autowired
    private AuthService authService;


    @GetMapping("/home")
    public String adminHome(Model model) {

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserEntity());
        }
        model.addAttribute("method", "post");

        return "pages/admin/admin-home";
    }

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

    @GetMapping("/registration")
    public String registerPage(Model model) {

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserEntity());
        }
        return "pages/admin/registration";
    }


    @PostMapping("/registration")
    public String register(@ModelAttribute("user") UserEntity newUser,
                           RedirectAttributes redirectAttributes) {

        // Verifica se o email já existe antes de tentar salvar
        if (authService.existsByEmail(newUser.getEmail())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Email já cadastrado!");
            redirectAttributes.addFlashAttribute("user", newUser); // Repopula o formulário
            return "redirect:/admin/registration";
        }

        try {
            newUser.setPassword(newUser.getPassword());
            authService.register(newUser);
            redirectAttributes.addFlashAttribute("successMessage", "Usuário cadastrado com sucesso! Faça o login.");
            return "redirect:/admin/registration";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao cadastrar: " + e.getMessage());
            redirectAttributes.addFlashAttribute("user", newUser); // Repopula o formulário
            return "redirect:/admin/registration";
        }

    }




}
