package org.eazybank.outh2sociallogin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    

    @Autowired
    private CustomSuccessHandler successHandler;

    @Bean
    SecurityFilterChain defualtSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(request -> request
                .requestMatchers("/secure").authenticated()
                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    ClientRegistrationRepository clientRegistrationRepository(){
        ClientRegistration google = googleClientRegistration();
        return new InMemoryClientRegistrationRepository(gitHubClientRegistration(),google);
    }


    private ClientRegistration gitHubClientRegistration(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("Ov23li36377wye1slvN4")
                .clientSecret("a66796d7635b1d3618cb9bf6e8ab6259c91e48db")
                .build();
    }
    private ClientRegistration googleClientRegistration(){
        return CommonOAuth2Provider.GOOGLE.getBuilder("google")
                .clientId("259104623345-6orqh1rja4ahggc50ed1gvnfge8vrgj2.apps.googleusercontent.com")
                .clientSecret("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")
                .build();
    }
}
