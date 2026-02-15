package org.wrabz.com.project_with_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.wrabz.com.project_with_security.service.AuthenticationProviderService;

@Configuration
public class SecurityConfig {

    private final AuthenticationProviderService authenticationProvider;

    public SecurityConfig(AuthenticationProviderService authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authenticationProvider(authenticationProvider)
                .formLogin(form -> form
                        .defaultSuccessUrl("/main", true)
                )
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().authenticated()
                );

        return http.build();
    }
}
