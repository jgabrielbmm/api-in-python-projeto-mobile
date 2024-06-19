package com.icev.mobile.tea.controller;

import com.icev.mobile.tea.dto.UserCreateDTORequest;
import com.icev.mobile.tea.domain.User;
import com.icev.mobile.tea.dto.UserResponseDTO;
import com.icev.mobile.tea.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id){
        UserResponseDTO userResponseDTO = userService.findUserById(id);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserCreateDTORequest userCreateDTORequest) {
        User user = userService.createUser(userCreateDTORequest);

        return ResponseEntity.ok().body(user);
    }
}
