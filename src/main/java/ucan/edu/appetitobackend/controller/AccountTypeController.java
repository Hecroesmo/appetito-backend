package ucan.edu.appetitobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ucan.edu.appetitobackend.model.AccountType;
import ucan.edu.appetitobackend.repository.AccountTypeRepository;

@RestController
@RequestMapping("account-type")
public class AccountTypeController {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Iterable<AccountType> getAll() {
        return accountTypeRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AccountType save(@RequestBody AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }

}
