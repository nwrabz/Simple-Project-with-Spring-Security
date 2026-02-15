package org.wrabz.com.project_with_security.service;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.wrabz.com.project_with_security.CustomUserDetails;
import org.wrabz.com.project_with_security.model.User;
import org.wrabz.com.project_with_security.repository.UserRepository;

import java.util.function.Supplier;

@Service
public class JpaUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    JpaUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException>  supplier =
                () -> new UsernameNotFoundException(
                        "Username not found: " + username
                );

        var user = userRepository.findUserByUsername(username)
                .orElseThrow(supplier);

        return new CustomUserDetails(user);
    }
}
