package ucan.edu.appetitobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucan.edu.appetitobackend.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
