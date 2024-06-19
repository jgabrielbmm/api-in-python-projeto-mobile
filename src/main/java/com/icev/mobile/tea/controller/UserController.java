package com.icev.mobile.tea.controller;

import com.icev.mobile.tea.dto.UserCreateDTORequest;
import com.icev.mobile.tea.domain.User;
import com.icev.mobile.tea.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserCreateDTORequest userCreateDTORequest) {
        User user = userService.createUser(userCreateDTORequest);

        return ResponseEntity.ok().body(user);
    }
}
