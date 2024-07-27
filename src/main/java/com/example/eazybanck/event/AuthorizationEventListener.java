package com.example.eazybanck.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthorizationEventListener {

    @EventListener
    public void onFailure(AuthorizationDeniedEvent authorizationDeniedEvent) {
        log.info("Login Successful for user {} error: {}",
                authorizationDeniedEvent.getAuthentication().get().getName()
                ,authorizationDeniedEvent.getAuthorizationDecision().toString());
    }
}
