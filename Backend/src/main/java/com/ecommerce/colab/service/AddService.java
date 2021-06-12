package com.ecommerce.colab.service;

import com.ecommerce.colab.dto.SignupDto;

public interface AddService {
    public Boolean addUser(SignupDto signupDto);
}
