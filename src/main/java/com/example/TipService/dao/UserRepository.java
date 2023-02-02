package com.example.TipService.dao;

import com.example.TipService.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);


    UserEntity findUserByUsername(String loggedUserName);


}

