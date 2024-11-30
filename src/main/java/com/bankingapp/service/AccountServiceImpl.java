package com.bankingapp.service;

import com.bankingapp.dto.AccountDTO;
import com.bankingapp.entity.Account;
import com.bankingapp.entity.User;
import com.bankingapp.repository.AccountRepository;
import com.bankingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AccountDTO> getAllAccountsByUser(Long userId) {
        return accountRepository.findByUserId(userId)
                .stream()
                .map(account -> new AccountDTO(account.getId(), account.getAccountNumber(),
                        account.getBalance(), account.getUser().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO createAccountForUser(Long userId, AccountDTO accountDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = new Account();
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setBalance(accountDTO.getBalance());
        account.setUser(user);

        Account savedAccount = accountRepository.save(account);
        return new AccountDTO(savedAccount.getId(), savedAccount.getAccountNumber(),
                savedAccount.getBalance(), savedAccount.getUser().getId());
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
