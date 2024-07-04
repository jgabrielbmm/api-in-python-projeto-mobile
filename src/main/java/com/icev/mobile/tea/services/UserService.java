package com.icev.mobile.tea.services;

import com.icev.mobile.tea.controller.UserController;
import com.icev.mobile.tea.dto.UserCreateRequestDTO;
import com.icev.mobile.tea.domain.User;
import com.icev.mobile.tea.dto.UserInfoRequestDTO;
import com.icev.mobile.tea.dto.UserResponseDTO;
import com.icev.mobile.tea.dto.UserUpdateRequestDTO;
import com.icev.mobile.tea.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public User createOrUpdateUser(UserCreateRequestDTO userCreateDto) {
        User user = userRepository.findByEmail(userCreateDto.email());
        if (user == null) {
            return createUser(userCreateDto);
        } else {
            return update(userCreateDto, user);
        }
    }

    public User createUser(UserCreateRequestDTO userCreateDto) {
        User user = new User();
        user.setName(userCreateDto.name());
        user.setEmail(userCreateDto.email());
        user.setGender(userCreateDto.gender());
        user.setCity(userCreateDto.city());
        user.setState(userCreateDto.state());
        user.setIsASD(userCreateDto.isASD());
        user.setKnowSomeoneWithASD(userCreateDto.knowSomeoneWithASD());
        user.setDeleted(false);
        user.setCreatedAt(new Date());
        user.setUpdateAt(new Date());

        userRepository.save(user);

        return user;
    }

    public UserResponseDTO findUserByEmail(UserInfoRequestDTO userInfoRequestDTO) {
        User user = userRepository.findByEmail(userInfoRequestDTO.email());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (user.getDeleted()) {
            throw new RuntimeException("User deleted");
        }

        return new UserResponseDTO(user.getName(), user.getEmail(), user.getGender(),
                    user.getCity(), user.getState(), user.getIsASD(), user.getKnowSomeoneWithASD());
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setDeleted(true);

        userRepository.save(user);
    }

    public User update(UserCreateRequestDTO userCreateRequestDTO, User user) {

        if (user.getDeleted()) {
            throw new RuntimeException("User deleted");
        }

        user.setGender(userCreateRequestDTO.gender());
        user.setCity(userCreateRequestDTO.city());
        user.setState(userCreateRequestDTO.state());
        user.setIsASD(userCreateRequestDTO.isASD());
        user.setKnowSomeoneWithASD(userCreateRequestDTO.knowSomeoneWithASD());

        return userRepository.save(user);
    }
}
