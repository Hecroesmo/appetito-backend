package ucan.edu.appetitobackend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ucan.edu.appetitobackend.model.Account;
import ucan.edu.appetitobackend.model.AuthenticationRequest;
import ucan.edu.appetitobackend.model.AuthenticationResponse;
import ucan.edu.appetitobackend.model.Person;
import ucan.edu.appetitobackend.model.PersonRequest;
import ucan.edu.appetitobackend.model.Role;
import ucan.edu.appetitobackend.repository.AccountRepository;
import ucan.edu.appetitobackend.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AccountRepository accountRepo;
    private final PersonRepository personRepo;
    private final PasswordEncoder passwordEncoder;

    public Person register(PersonRequest newPerson) {
        Person person = new Person();
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        person.setPhoneNumber(newPerson.getPhoneNumber());

        Account account = new Account();
        account.setEmail(newPerson.getEmail());
        account.setPassword(passwordEncoder.encode(newPerson.getPassword()));
        account.setRole(Role.USER);
        person.setAccount(account);
        person = personRepo.save(person);
        return person;
    }

    public Person registerAdmin(PersonRequest newPerson) {
        Person person = new Person();
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        person.setPhoneNumber(newPerson.getPhoneNumber());

        Account account = new Account();
        account.setEmail(newPerson.getEmail());
        account.setPassword(passwordEncoder.encode(newPerson.getPassword()));
        account.setRole(Role.ADMIN);
        person.setAccount(account);
        person = personRepo.save(person);
        return person;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authReq) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authReq.getEmail(),
                        authReq.getPassword()));

        var user = accountRepo.findByEmail(authReq.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
