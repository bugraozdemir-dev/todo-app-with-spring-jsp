package com.practice.springboot.todowebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or Database
    //In memory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails = createNewUser("bozdemir", "test");
        UserDetails userDetails2 = createNewUser("rnulas", "test");
        return new InMemoryUserDetailsManager(userDetails, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        UserDetails userDetails = User.builder()
                .passwordEncoder(input -> passwordEncoder().encode(input))
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
            .formLogin(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}
