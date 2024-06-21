package com.icev.mobile.tea.services;

import com.icev.mobile.tea.dto.UserCreateRequestDTO;
import com.icev.mobile.tea.domain.User;
import com.icev.mobile.tea.dto.UserResponseDTO;
import com.icev.mobile.tea.dto.UserUpdateRequestDTO;
import com.icev.mobile.tea.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public User createUser(UserCreateRequestDTO userCreateDto) {
        User user = new User();
        user.setName(userCreateDto.name());
        user.setEmail(userCreateDto.email());
        user.setGender(userCreateDto.gender());
        user.setDateOfBirth(userCreateDto.dateOfBirth());
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

    public UserResponseDTO findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponseDTO(user.getName(), user.getEmail(), user.getDateOfBirth(), user.getGender(),
                    user.getCity(), user.getState(), user.getIsASD(), user.getKnowSomeoneWithASD());
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setDeleted(true);

        userRepository.save(user);
    }

    public void update(Long id, UserUpdateRequestDTO userUpdateRequestDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getDeleted()) {
            throw new RuntimeException("User deleted");
        }
        user.setName(userUpdateRequestDTO.name());
        user.setEmail(userUpdateRequestDTO.email());
        user.setGender(userUpdateRequestDTO.gender());
        user.setCity(userUpdateRequestDTO.city());
        user.setState(userUpdateRequestDTO.state());
        user.setDateOfBirth(userUpdateRequestDTO.dateOfBirth());
        user.setIsASD(userUpdateRequestDTO.isASD());
        user.setKnowSomeoneWithASD(userUpdateRequestDTO.knowSomeoneWithASD());

        userRepository.save(user);
    }
}
