package com.example.TipService.services;

import com.example.TipService.dao.UserRepository;
import com.example.TipService.entities.UserEntity;
import com.example.TipService.model.UserDto;
import com.example.TipService.model.UserProfileDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(UserDto userDto) {
        if (!isUserExist(userDto.getEmail())) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userDto.getName());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPassword(userDto.getPassword());
            userEntity.setEnabled(true);
            userRepository.save(userEntity);
        }

    }

    public void editUser(UserProfileDto userProfileDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userProfileDto.getName());
        userEntity.setUsername(userProfileDto.getName());
        userEntity.setEmail(userProfileDto.getEmail());
        //  userEntity.setPassword(userProfileDto.getPassword());
        userRepository.save(userEntity);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean isUserExist(String email) {
        Optional<UserEntity> userFromDatabase = getAllUsers()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
        return userFromDatabase.isPresent();
    }


}