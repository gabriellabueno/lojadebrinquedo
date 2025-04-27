package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.service.AuthService;
import br.edu.fatecgru.toybox.entity.UserEntity;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "pages/admin/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,
                        Model model,
                        HttpServletResponse response) {


        if ( service.existsByEmail(email) ) {
            Cookie cookie = service.login(email, passwordEncoder.encode(password));
            response.addCookie(cookie);
            return "redirect:pages/admin/greetings";

        }

        model.addAttribute("errorMessage", "Usuário não encontrado!");
        return "redirect:pages/admin/login";

    }

    @GetMapping("/register")
    public String registerPage() {
        return "pages/admin/login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String password,
                                   Model model) {

            try {
                UserEntity newUser = new UserEntity();
                newUser.setName(name);
                newUser.setEmail(email);
                newUser.setPassword(passwordEncoder.encode(password));
                service.register(newUser);
                model.addAttribute("successMessage", "Usuário cadastrado com sucesso!");
            } catch (Exception e) {
                model.addAttribute("errorMessage", e.getMessage());
            }

            return "pages/admin/register";

    }

}
