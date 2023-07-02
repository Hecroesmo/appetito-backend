package ucan.edu.appetitobackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ucan.edu.appetitobackend.model.Person;
import ucan.edu.appetitobackend.model.PersonRequest;
import ucan.edu.appetitobackend.service.ClientsService;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientsService clientsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person save(@RequestBody PersonRequest personRequest) {
        return clientsService.save(personRequest);
    }

}
