package ucan.edu.appetitobackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ucan.edu.appetitobackend.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);
}
