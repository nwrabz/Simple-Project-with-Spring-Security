package org.wrabz.com.project_with_security.service;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.wrabz.com.project_with_security.CustomUserDetails;

@Service
public class AuthenticationProviderService implements AuthenticationProvider {

    private final JpaUserDetailService userDetailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SCryptPasswordEncoder sCryptPasswordEncoder;

    public AuthenticationProviderService(JpaUserDetailService userDetailService, BCryptPasswordEncoder bCryptPasswordEncoder, SCryptPasswordEncoder sCryptPasswordEncoder) {
        this.userDetailService = userDetailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.sCryptPasswordEncoder = sCryptPasswordEncoder;
    }


    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication
                .getCredentials().toString();

        CustomUserDetails user =
                userDetailService.loadUserByUsername(username);

        return switch (user.getUser().getAlgorithm()) {
            case BCRYPT -> checkPassword(user, password, bCryptPasswordEncoder);
            case SCRYPT -> checkPassword(user, password, sCryptPasswordEncoder);
        };
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }

    private Authentication checkPassword(CustomUserDetails user,
                                         String rawPassword,
                                         PasswordEncoder encoder) {
        if (encoder.matches(rawPassword, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    user.getAuthorities());
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }
}
