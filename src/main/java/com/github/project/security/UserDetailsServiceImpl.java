package com.github.project.security;

import com.github.project.model.Client;
import com.github.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client byEmail = clientRepository.findByEmail(s);
        if (byEmail == null) {
            throw new UsernameNotFoundException(s);
        }
        return new ClientUserDetails(byEmail.getEmail(), byEmail.getPassword(), byEmail.isEnabled(), byEmail.getRole());
    }
}
