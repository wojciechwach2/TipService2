package com.example.TipService.services;

import com.example.TipService.dao.UserRepository;
import com.example.TipService.entities.UserEntity;
import com.example.TipService.model.PasswordDto;
import com.example.TipService.model.UserDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    public void editUser(UserDto userProfileDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userProfileDto.getName());
        userEntity.setUsername(userProfileDto.getName());
        userEntity.setEmail(userProfileDto.getEmail());
        userEntity.setPassword(userProfileDto.getPassword());
        userRepository.save(userEntity);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean isUserExist(String email) {
        Optional<UserEntity> userFromDatabase = getAllUsers().stream().filter(user -> user.getEmail().equals(email)).findFirst();
        return userFromDatabase.isPresent();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity getUserByUsername(String loggedUserName) {
        return userRepository.findUserByUsername(loggedUserName);
    }


    public UserEntity getLoggedUserEntity() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return getUserByUsername(((UserDetails) principal).getUsername());
        } else {
            return getUserByUsername(principal.toString());
        }
    }
    public void changePassword(PasswordDto passwordDto) {
        UserEntity user = getLoggedUserEntity();
        String currentPassword = passwordEncoder.encode(passwordDto.getCurrentPassword());
        if (currentPassword.equals(user.getPassword())) {
            if (passwordDto.getNewPassword().equals(passwordDto.getReenteredNewPassword())) {
                user.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
            }
        }
        userRepository.save(user);
    }
}
