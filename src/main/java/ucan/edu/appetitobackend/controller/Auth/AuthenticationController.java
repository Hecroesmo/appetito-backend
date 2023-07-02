package ucan.edu.appetitobackend.controller.Auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ucan.edu.appetitobackend.model.AuthenticationRequest;
import ucan.edu.appetitobackend.model.AuthenticationResponse;
import ucan.edu.appetitobackend.model.Person;
import ucan.edu.appetitobackend.model.PersonRequest;
import ucan.edu.appetitobackend.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authReq) {
        return service.authenticate(authReq);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Person register(@RequestBody PersonRequest personReq) {
        return service.register(personReq);
    }
}
