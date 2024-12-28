package com.example.api_gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.endpoint.WebClientReactiveAuthorizationCodeTokenResponseClient;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.function.client.WebClient;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public WebClientReactiveAuthorizationCodeTokenResponseClient webClientReactiveAuthorizationCodeTokenResponseClient(
            WebClient.Builder webClientBuilder
    ) {
        var webClientReactiveAuthorizationCodeTokenResponseClient = new WebClientReactiveAuthorizationCodeTokenResponseClient();
        webClientReactiveAuthorizationCodeTokenResponseClient.setWebClient(webClientBuilder.build());
        return webClientReactiveAuthorizationCodeTokenResponseClient;
    }

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .authorizeHttpRequests(req -> req.anyRequest().authenticated())
                .authorizeExchange(req -> req.anyExchange().authenticated())
                .oauth2Login(Customizer.withDefaults())
//                .
                .build();
    }
}
