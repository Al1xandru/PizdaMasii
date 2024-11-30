package com.bankingapp.service;

import com.bankingapp.dto.UserDTO;
import com.bankingapp.entity.User;
import com.bankingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
