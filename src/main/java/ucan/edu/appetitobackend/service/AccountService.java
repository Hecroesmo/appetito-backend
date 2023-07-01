package ucan.edu.appetitobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucan.edu.appetitobackend.model.Account;
import ucan.edu.appetitobackend.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
