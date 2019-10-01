package br.guisi.specs.springspecs.service.impl;

import br.guisi.specs.springspecs.entity.Person;
import br.guisi.specs.springspecs.repository.IPersonRepository;
import br.guisi.specs.springspecs.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Anotação service marca a classe como injetável, voltado ao business */
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }

}
