package com.ecommerce.colab.service;

import com.ecommerce.colab.dto.SignupDto;
import com.ecommerce.colab.model.User;

import com.ecommerce.colab.repository.UserRepository;
import com.ecommerce.colab.repository.VerificationTokenRepository;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;


@AllArgsConstructor
@Slf4j
public class AddServiceImpl implements AddService {
    UserRepository userRepository;
    VerificationTokenRepository verificationTokenRepository;
    PasswordEncoder encode;




    @Override
    public Boolean addUser(SignupDto signupDto,String role) {
        try {
            User user = new User();
            user.setEmail(signupDto.getEmail());
            user.setPassword(encode.encode(signupDto.getPassword()));
            user.setUsername(signupDto.getUsername());
            user.setCreated(Instant.now());
            user.setEnabled(false);
            user = userRepository.save(user);
           if(user.getId()!=null){
               return true;
           }

            /*
            final String token = UUID.randomUUID().toString();
            final VerificationToken verificationToken = VerificationToken.builder()
                    .expiredon(Instant.now().plus(7, ChronoUnit.DAYS))
                    .token(token)
                    .user(user)
                    .build();

            verificationTokenRepository.save(verificationToken);
            */
             //code for user email verificaation mail


        }catch (Exception e){
            log.error(e.getMessage());

        }


        return false;

    }
}
