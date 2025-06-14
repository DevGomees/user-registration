package com.crud.user_registration.infrastructure.repository;

import com.crud.user_registration.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail (String email);

    @Transactional
    void deleteByEmail(String email);
}
