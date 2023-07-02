package ucan.edu.appetitobackend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ucan.edu.appetitobackend.model.Person;
import ucan.edu.appetitobackend.model.PersonRequest;
import ucan.edu.appetitobackend.model.Role;
import ucan.edu.appetitobackend.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class ClientsService {
    private final PasswordEncoder passwordEncoder;
    private final PersonRepository service;

    public Person save(PersonRequest newPerson) {
        Person person = new Person();
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        person.setPhoneNumber(newPerson.getPhoneNumber());
        person.getAccount().setEmail(newPerson.getEmail());
        person.getAccount().setRole(Role.USER);
        person.getAccount().setPassword(passwordEncoder.encode(newPerson.getPassword()));
        return service.save(person);
    }
}
