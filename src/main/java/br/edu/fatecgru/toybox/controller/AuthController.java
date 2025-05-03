package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.service.AuthService;
import br.edu.fatecgru.toybox.entity.UserEntity;
import br.edu.fatecgru.toybox.service.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    private JwtService jwtService;


    @GetMapping("/login")
    public String loginPage(Model model,
                            @CookieValue(value = "auth_token", required = false) String authToken) {


        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserEntity());
        }

        if (authToken != null) {
            String subject = jwtService.validateToken(authToken);
            if (subject != null) {
                return "redirect:/admin/home";
            }
        }

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

                return "redirect:/admin/home";
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Senha ou usuário inválido!");
                redirectAttributes.addFlashAttribute("user", user);
                return "redirect:/auth/login";
            }
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response,
                         HttpServletRequest request) {

        // Invalida a sessão HTTP (caso use HttpSession em algum lugar)
        if (request.getSession(false) != null) {
            request.getSession().invalidate();
        }

        // Remove o cookie JWT definindo-o com maxAge=0
        Cookie cookie = new Cookie("auth_token", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);


        return "redirect:/auth/login";
    }


}
