package ucan.edu.appetitobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucan.edu.appetitobackend.model.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

}