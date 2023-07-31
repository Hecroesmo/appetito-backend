package ucan.edu.appetitobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ucan.edu.appetitobackend.model.Account;
import ucan.edu.appetitobackend.repository.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepo;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Account> findAll() {
        return accountRepo.findAll();
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Account findByEmailAccount(@PathVariable String email) {
        return accountRepo.findByEmail(email).get();
    }
}
