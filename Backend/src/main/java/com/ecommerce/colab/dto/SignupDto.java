package com.ecommerce.colab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupDto {
    String username;
    String password;
    String email;
    String Role;

}
