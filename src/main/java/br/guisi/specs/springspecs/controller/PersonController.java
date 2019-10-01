package br.guisi.specs.springspecs.controller;

import br.guisi.specs.springspecs.entity.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Marks a class as a Swagger resource. */
@Api(value = "PersonControler", tags = "Pessoas")
/** Inicia a classe como um recurso rest, já com Controller e ResponseBody */
@RestController
public class PersonController {

    /** Anotação para o verb GET
     * Usando sem paramâmetros para buscar todas as pessoas
     */
    @GetMapping("/persons")
    /** Para documentacao com o swagger */
    @ApiOperation(value = "Retorna uma lista de pessoas", response = Iterable.class, tags = "Pessoas")
    public List<Person> getPerson(){
        return null;
    }

    /**
     * Anotação para o verb GET
     * Usando com parâmetro para buscar uma pessoa específica
     * @param id
     * @return Person
     */
    @GetMapping("persons/{id}")
    /** Para documentacao com o swagger */
    @ApiOperation(value = "Retorna uma pessoa", response = Person.class, tags = "Pessoas")
    /** PathParam, usado para passar parâmetro que faz parte da URL, sem o uso da ?
     * NAO CONSEGUI USAR, TIVE QUE APELAR
     */
    public Person getOnePerson(@RequestParam("id") Long id){
        return null;
    }

    /**
     * Anotação para o verb POST
     * Usado para criar uma pessoa
     * Pode ser utilizado para executar um business
     * @param person
     * @return Person
     */
    @PostMapping("/persons")
    /** Para documentacao com o swagger */
    @ApiOperation(value = "Inclui uma pessoa", tags = "Pessoas")
    /** RequestBody, usado para passar o objeto que virá no Body do request  */
    public Person add(@RequestBody() Person person) {
        Person person1 = person.builder().firstName("first").lastName("last").build();
        person1 = person1.builder().firstName("second").build();
        person1 = person1.builder().lastName("last2").build();
        person1 = person1.toBuilder().build();
        person1 = person1.toBuilder().lastName("lasthree").build();
        return null;
    }

    /**
     * Anotação para o verb PUT
     * Usado para fazer uma alteração inteira de Person
     * @param id
     * @param person
     */
    @PutMapping("/persons/{id}")
    /** Para documentacao com o swagger */
    @ApiOperation(value = "Alterar uma pessoa", tags = "Pessoas")
    /** PathVariable, usado para passar parâmetro que faz parte da URL, sem o uso da ? */
    public void update(@PathVariable("id") Integer id, @RequestBody() Person person) {
        System.out.println();
    }

    /**
     * Anotação para o verb DELETE
     * Utilizado para remover Person
     * IMPORTANTE: Precisa passar a ?id=valor pra funcionar
     * @param id
     */
    @DeleteMapping("/persons")
    /** Para documentacao com o swagger */
    @ApiOperation(value = "Apagar uma pessoa", tags = "Pessoas")
    /** RequestParam usado para passar a variavel, com a ? */
    public void delete(@RequestParam("id") Integer id) {
        System.out.println();
    }

}
