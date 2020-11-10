package com.rawg.rawgspringbackend.service;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.model.UserCredentialsRegister;
import com.rawg.rawgspringbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class UserApiService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserApiService() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public ResponseEntity registerUser(UserCredentialsRegister userCredentialsRegister) {
        Optional<RawGUser> user = userRepository.findByEmail(userCredentialsRegister.getEmail());
        if (user.isEmpty()) {
            RawGUser newUser = RawGUser
                    .builder()
                    .email(userCredentialsRegister.getEmail())
                    .userName(userCredentialsRegister.getUserName())
                    .password(passwordEncoder.encode(userCredentialsRegister.getPassword()))
                    .registrationDate(LocalDateTime.now())
                    .roles(Arrays.asList("ROLE_USER"))
                    .build();
            userRepository.save(newUser);

            Map<Object, Object> model = new HashMap<>();
            model.put("Signed up with: ", userCredentialsRegister.getEmail());
            return ResponseEntity.ok(model);
        } else {
            throw new BadCredentialsException("Email is already in use!");
        }
    }

    public RawGUser signIn(RawGUser user) {
        return null;
    }

    public Optional<RawGUser> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
