package com.bankingapp.service;

import com.bankingapp.dto.UserDTO;
import com.bankingapp.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    void deleteUser(Long id);
}
