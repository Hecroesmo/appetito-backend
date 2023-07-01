package ucan.edu.appetitobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucan.edu.appetitobackend.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}
