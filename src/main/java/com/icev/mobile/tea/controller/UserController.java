package com.icev.mobile.tea.controller;

import com.icev.mobile.tea.dto.UserCreateRequestDTO;
import com.icev.mobile.tea.domain.User;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id){
        UserResponseDTO userResponseDTO = userService.findUserById(id);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequestDTO userCreateDTORequest) {
        User user = userService.createUser(userCreateDTORequest);

        return ResponseEntity.ok().body(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        System.out.println("chamou");
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        userService.update(id, userUpdateRequestDTO);
        return ResponseEntity.noContent().build();
    }
}
