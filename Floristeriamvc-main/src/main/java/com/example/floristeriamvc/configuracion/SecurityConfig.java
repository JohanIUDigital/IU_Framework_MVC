package com.example.floristeriamvc.configuracion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para simplificar (no recomendado en producción)
                .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/flores", "/pedidos").authenticated() // Rutas que requieren autenticación
                                .anyRequest().permitAll() // Otras rutas accesibles sin autenticación
                )
                .formLogin((form) -> form
                                .loginPage("/login") // Página personalizada de inicio de sesión
                                .permitAll()
                )
                .logout((logout) -> logout.permitAll()); // Configurar logout

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("password")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Override
    public String toString() {
        return "SecurityConfig []";
    }
}
