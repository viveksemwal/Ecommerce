package com.ecommerce.colab.repository;

import com.ecommerce.colab.model.UserDetailInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsInfoRepository extends JpaRepository<UserDetailInfo,Long> {

}
