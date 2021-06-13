package com.ecommerce.colab.service.allimplmentation;

import com.ecommerce.colab.model.User;
import com.ecommerce.colab.model.VerificationToken;
import com.ecommerce.colab.repository.UserRepository;
import com.ecommerce.colab.repository.VerificationTokenRepository;
import com.ecommerce.colab.service.allinterface.EnableAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EnableAccountServiceImpl implements EnableAccountService {
    VerificationTokenRepository verificationTokenRepository;
    UserRepository userRepository;

    @Override
    public Long enableUser(String code) {
        Optional<VerificationToken> verificationToken= verificationTokenRepository.findByToken(code);

        if(verificationToken.isPresent()){
            System.out.println("inside is present");
            if(verificationToken.get().getUserid() instanceof User){
                System.out.println("found user");
            }
            User user =verificationToken.get().getUserid();
            System.out.println(user);
            user.setEnabled(true);
            userRepository.save(user);
            return user.getId();
        }else{
            return Long.parseLong("0");
        }
    }
}
