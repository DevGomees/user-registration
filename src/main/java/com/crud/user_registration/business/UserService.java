package com.crud.user_registration.business;

import com.crud.user_registration.infrastructure.entitys.User;
import com.crud.user_registration.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.saveAndFlush(user);
    }

    public User searchUserByEamil(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado!")
        );
    }

    public void deleteUserByEmail(String email){
        repository.deleteByEmail(email);
    }

    public void updateUserById(Integer id, User user){
        User userEntity = repository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado!"));
        User updateUser = User.builder()
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .nome(user.getNome() != null ? user.getNome() : userEntity.getNome())
                .id(userEntity.getId())
                .build();
        repository.saveAndFlush(updateUser);
    }
}
