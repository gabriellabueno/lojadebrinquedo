package br.edu.fatecgru.toybox.security;

import br.edu.fatecgru.toybox.entity.UserEntity;
import br.edu.fatecgru.toybox.repository.UserRepository;
import br.edu.fatecgru.toybox.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers(
                                        "/css/**",
                                        "/images/**",
                                        "/home",
                                        "/about",
                                        "/category/**",
                                        "/toy/**",
                                        "/auth/login"
                                ).permitAll()

                        .requestMatchers("/auth/**").permitAll()

//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers( "/auth/register").hasRole("ADMIN")

                        .requestMatchers("/admin/**").permitAll()
                        .requestMatchers( "/auth/register").permitAll()

                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

                UserEntity admin = new UserEntity();
                admin.setName("root");
                admin.setEmail("root@teste.com");
                admin.setPassword(passwordEncoder.encode("167@fatec"));
                admin.setUserRole(UserRole.ADMIN);
                userRepository.save(admin);

        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
