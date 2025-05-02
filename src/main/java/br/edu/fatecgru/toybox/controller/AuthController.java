package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.service.AuthService;
import br.edu.fatecgru.toybox.entity.UserEntity;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage(Model model) {

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserEntity());
        }
        model.addAttribute("method", "post");
        model.addAttribute("action", "login");
        return "pages/admin/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserEntity user,
                        RedirectAttributes redirectAttributes,
                        HttpServletResponse response) {

            try {
                Cookie cookie = authService.login(
                        user.getEmail(), user.getPassword());
                response.addCookie(cookie);
                return "redirect:/auth/greetings";
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Senha ou usuário inválido!");
                redirectAttributes.addFlashAttribute("user", user);
                return "redirect:/auth/login";
            }
    }

    @GetMapping("/greetings")
    public String greetingPage() {
        return "pages/admin/greetings";
    }

    @GetMapping("/registration")
    public String registerPage() {
        return "pages/admin/registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("user") UserEntity newUser,
                           RedirectAttributes redirectAttributes) {

        // Verifica se o email já existe antes de tentar salvar
        if (authService.existsByEmail(newUser.getEmail())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Email já cadastrado!");
            redirectAttributes.addFlashAttribute("user", newUser); // Repopula o formulário
            return "redirect:/auth/registration";
        }

        try {
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            authService.register(newUser);
            redirectAttributes.addFlashAttribute("successMessage", "Usuário cadastrado com sucesso! Faça o login.");
            return "redirect:/auth/registration";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao cadastrar: " + e.getMessage());
            redirectAttributes.addFlashAttribute("user", newUser); // Repopula o formulário
            return "redirect:/auth/registration";
        }

    }
}
