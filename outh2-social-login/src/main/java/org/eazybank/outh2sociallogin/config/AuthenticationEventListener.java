package org.eazybank.outh2sociallogin.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component

public class AuthenticationEventListener {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent authenticationSuccessEvent) {
        log.info("Login Successful for user {}", authenticationSuccessEvent.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent authenticationFailureEvent) {
        log.info("Login Successful for user {} error: {}", authenticationFailureEvent.getAuthentication().getName(),authenticationFailureEvent.getException());
    }
}
