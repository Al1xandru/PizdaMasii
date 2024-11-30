package com.bankingapp.controller;

import com.bankingapp.dto.AccountDTO;
import com.bankingapp.entity.Account;
import com.bankingapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/user/{userId}")
    public List<AccountDTO> getAllAccountsByUser(@PathVariable Long userId) {
        return accountService.getAllAccountsByUser(userId);
    }

    @PostMapping("/user/{userId}")
    public AccountDTO createAccountForUser(@PathVariable Long userId, @RequestBody AccountDTO accountDTO) {
        return accountService.createAccountForUser(userId, accountDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
