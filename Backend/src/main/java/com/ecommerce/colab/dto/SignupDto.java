package com.ecommerce.colab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupDto {
    @Size(min = 2,message = "Size of username is less than 2")
    String username;
    @Size(min=8,message = "password length must be grater than 7 ")
    String password;
    @Email(message = "email dont have valid format")
    String email;
    @NotNull(message = "Role cannot be null")
    String role;

}
