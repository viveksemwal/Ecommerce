package com.ecommerce.colab.service.allimplmentation;

import com.ecommerce.colab.dto.SignupDto;
import com.ecommerce.colab.model.User;

import com.ecommerce.colab.model.VerificationToken;
import com.ecommerce.colab.repository.UserRepository;
import com.ecommerce.colab.repository.VerificationTokenRepository;

import com.ecommerce.colab.service.allinterface.AddService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class AddServiceImpl implements AddService {
    UserRepository userRepository;
    VerificationTokenRepository verificationTokenRepository;
    PasswordEncoder encode;
    private JavaMailSender mailSender;




    @Transactional
    @Override
    public Boolean addUser(SignupDto signupDto) {
        try {

            User user = new User();
            user.setEmail(signupDto.getEmail());
            user.setPassword(encode.encode(signupDto.getPassword()));
            user.setUsername(signupDto.getUsername());
            user.setCreated(Instant.now());
            user.setEnabled(false);System.out.println("before save user");

            user = userRepository.save(user);
            System.out.println("after");



            final String token = UUID.randomUUID().toString();
            final VerificationToken verificationToken = VerificationToken.builder()
                    .expiredon(Instant.now().plus(7, ChronoUnit.DAYS))
                    .token(token).userid(user)
                    .build();


            verificationTokenRepository.save(verificationToken);

             //code for user email verificaation mail

            boolean result=sendUserVerficationCode(verificationToken.getToken(),user.getUsername(),user.getEmail());


            if(result){
                System.out.println("result is true");
                return true;
            }else{
                throw new RuntimeException("unable to send mail");
            }

        }catch (Exception e){
            log.error(e.getMessage());

        }


        return false;

    }



    private boolean sendUserVerficationCode(String token,String username,String email){

        try{
            String toAddress = email;
            String fromAddress = "viveksemwal1997@gmail.com";
            String senderName = "E-Commerce";
            String subject = "Please verify your registration in Ecommerce";
            String content = "Dear [[name]],<br>"
                    + "Please click the link below to verify your registration:<br>"
                    + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                    + "Thank you,<br>"
                    + "Ecommerce.";
            String websiteUrl="http://localhost:8080/auth/verification";
            String URL=websiteUrl+"/verify?code="+token;
            String name=username;
            content=content.replace("[[URL]]",URL);
            content=content.replace("[[name]]",name);

            MimeMessage mimeMessage=mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setFrom(fromAddress,senderName);
            mimeMessageHelper.setText(content,true);

            mailSender.send(mimeMessage);

            return true;
        }catch (Exception ex){
                log.error(ex.getMessage());
        }
        return false;
    }


}
