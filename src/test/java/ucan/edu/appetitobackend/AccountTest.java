package ucan.edu.appetitobackend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ucan.edu.appetitobackend.repository.AccountRepository;

@SpringBootTest
public class AccountTest {
    @Autowired
    AccountRepository accountRepo;
    @Test
    public void findByEmail() {
        final String emailExpected = "hecroesmo@gmail.com";
        assertEquals(
            emailExpected,
            accountRepo.findByEmail(emailExpected)
        );
    }
}
