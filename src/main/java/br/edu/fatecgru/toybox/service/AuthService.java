package br.edu.fatecgru.toybox.service;

import br.edu.fatecgru.toybox.entity.UserEntity;
import br.edu.fatecgru.toybox.repository.UserRepository;
import br.edu.fatecgru.toybox.user.UserRole;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public Cookie login(String email, String password) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(email, password);
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = jwtService.generateToken((UserEntity) auth.getPrincipal());

        Cookie cookie = new Cookie("auth_token", token);
        cookie.setPath("/"); // Disponível para todas as rotas
        cookie.setHttpOnly(true);

        // Adiciona token em cookie
        return cookie;
    }


    public UserEntity register(UserEntity user){
        UserRole userRole = UserRole.ADMIN;
        UserEntity newUser = new UserEntity(
                user.getName(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                userRole
        );

        return userRepository.save(newUser);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
