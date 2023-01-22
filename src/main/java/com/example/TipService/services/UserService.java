package com.example.TipService.services;

import com.example.TipService.dao.UserRepository;
import com.example.TipService.entities.UserEntity;
import com.example.TipService.model.UserDto;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEnabled(true);

        userRepository.save(userEntity);


    }
}
