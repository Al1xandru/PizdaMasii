package com.bankingapp.service;

import com.bankingapp.dto.AccountDTO;
import com.bankingapp.entity.Account;

import java.util.List;


import java.util.List;

public interface AccountService {
    List<AccountDTO> getAllAccountsByUser(Long userId);
    AccountDTO createAccountForUser(Long userId, AccountDTO accountDTO);
    void deleteAccount(Long id);
}
