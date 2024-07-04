package com.icev.mobile.tea.controller;

import com.icev.mobile.tea.dto.UserCreateRequestDTO;
import com.icev.mobile.tea.domain.User;
import com.icev.mobile.tea.dto.UserInfoRequestDTO;
import com.icev.mobile.tea.dto.UserResponseDTO;
import com.icev.mobile.tea.dto.UserUpdateRequestDTO;
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

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/info")
    public ResponseEntity<UserResponseDTO> getUser(@RequestBody UserInfoRequestDTO userInfoRequestDTO){
        UserResponseDTO userResponseDTO = userService.findUserByEmail(userInfoRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping()
    public ResponseEntity<User> createOrUpdateUser(@RequestBody UserCreateRequestDTO userCreateDTORequest) {
        User user = userService.createOrUpdateUser(userCreateDTORequest);

        return ResponseEntity.ok().body(user);
    }
}
