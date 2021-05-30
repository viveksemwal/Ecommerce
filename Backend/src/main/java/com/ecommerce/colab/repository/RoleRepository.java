package com.ecommerce.colab.repository;

import com.ecommerce.colab.model.Role;
import com.ecommerce.colab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
