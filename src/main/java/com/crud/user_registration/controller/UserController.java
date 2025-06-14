package com.crud.user_registration.controller;

import com.crud.user_registration.business.UserService;
import com.crud.user_registration.infrastructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<User> searchUserByEmail(@RequestBody String email){
        return ResponseEntity.ok(userService.searchUserByEamil(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email){
        userService.deleteUserByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUserById(@RequestParam Integer id, @RequestBody User user){
        userService.updateUserById(id, user);
        return ResponseEntity.ok().build();
    }
}
