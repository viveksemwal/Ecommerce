package com.ecommerce.colab.service;

import com.ecommerce.colab.dto.SignupDto;
import com.ecommerce.colab.model.User;
import com.ecommerce.colab.model.VerificationToken;
import com.ecommerce.colab.repository.UserRepository;
import com.ecommerce.colab.repository.VerificationTokenRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Slf4j
public class AddServiceImpl implements AddService {
    UserRepository userRepository;
    VerificationTokenRepository verificationTokenRepository;




    @Override
    public Boolean addUser(SignupDto signupDto,String role) {
        try {
            User user = new User();
            user.setEmail(signupDto.getEmail());
            user.setPassword(signupDto.getPassword());
            user.setUsername(signupDto.getUsername());
            user.setCreated(Instant.now());
            user.setEnabled(false);
            user = userRepository.save(user);
            final String token = UUID.randomUUID().toString();
            final VerificationToken verificationToken = VerificationToken.builder()
                    .expiredon(Instant.now().plus(7, ChronoUnit.DAYS))
                    .token(token)
                    .user(user)
                    .build();

            verificationTokenRepository.save(verificationToken);

        }catch (Exception e){
            log.error(e.getMessage());
        }



    }
}
