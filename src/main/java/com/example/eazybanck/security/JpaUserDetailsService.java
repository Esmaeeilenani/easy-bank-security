package com.example.eazybanck.security;

import com.example.eazybanck.model.Customer;
import com.example.eazybanck.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("user is not found"));


        return User.builder()
                .username(customer.getEmail())
                .password(customer.getPwd())
                .authorities(customer
                        .getAuthorities()
                        .stream()
                        .map(a-> new SimpleGrantedAuthority(a.getName()))
                        .toList()
                )
                .build();
    }
}
