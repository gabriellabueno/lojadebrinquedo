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

        model.addAttribute("user", new UserEntity());
        model.addAttribute("method", "post");
        model.addAttribute("action", "login");
        return "pages/admin/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserEntity userInput,
                        RedirectAttributes redirectAttributes,
                        HttpServletResponse response) {

        UserEntity user = authService.findByEmail(userInput.getEmail());

        if (user != null) {
            Cookie cookie = authService.login(user.getUsername(), passwordEncoder.encode(user.getPassword()));
            response.addCookie(cookie);
            return "redirect:pages/admin/greetings";

        }

        redirectAttributes.addFlashAttribute("errorMessage", "Usuário não encontrado!");
        return "redirect:pages/admin/login";

    }

    @GetMapping("/registration")
    public String registerPage() {
        return "pages/admin/registration";
    }

    @PostMapping("/registration")
    public String register(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String password,
                           RedirectAttributes redirectAttributes) {

            try {
                UserEntity newUser = new UserEntity();
                newUser.setName(name);
                newUser.setEmail(email);
                newUser.setPassword(passwordEncoder.encode(password));
                authService.register(newUser);
                redirectAttributes.addFlashAttribute("successMessage", "Usuário cadastrado com sucesso!");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            }

            return "redirect:pages/admin/registration";

    }

    @GetMapping("/greetings")
    public String greetingPage() {

        return "redirect:pages/admin/greetings";
    }

}
