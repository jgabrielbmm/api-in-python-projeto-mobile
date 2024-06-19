package com.icev.mobile.tea.services;

import com.icev.mobile.tea.dto.UserCreateDTORequest;
import com.icev.mobile.tea.domain.User;
import com.icev.mobile.tea.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public User createUser(UserCreateDTORequest userCreateDto) {
        User user = new User();
        user.setName(userCreateDto.name());
        user.setEmail(userCreateDto.email());
        user.setDateOfBirth(userCreateDto.dateOfBirth());
        user.setIsASD(userCreateDto.isASD());
        user.setKnowSomeoneWithASD(userCreateDto.knowSomeoneWithASD());
        user.setDeleted(false);
        user.setCreatedAt(new Date());
        user.setUpdateAt(new Date());

        userRepository.save(user);

        return user;
    }
}
