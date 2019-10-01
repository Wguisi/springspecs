package br.guisi.specs.springspecs.repository;

import br.guisi.specs.springspecs.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

}
