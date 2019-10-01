package br.guisi.specs.springspecs.entity;

import br.guisi.specs.springspecs.entity.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;

/** Não precisa setar, só coloquei pra lembrar como poderia desabilitar o second-level-cache */
@Cacheable
/** Definição da estratégia de cache. NONSTRICT_READ_WRITE garante menos rigidez nas coleções */
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
/** Para habilitar essa classe como uma Entidade JPA */
@Entity
/** Defining the table name */
@Table(name="person")
/** A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields */
@Data
/** Cria um builder para a classe. Setando toBuilder como true, mantém as antigas variáveis já setadas. */
@Builder(toBuilder = true)
public class Person {

    /** Define a chave primaria */
    @Id
    /** Significa que a estratégia sera feita pelo tipo do campo */
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    /** Se esse item vem setado, caso o builder não crie já seta o valor definido como default */
    @Builder.Default
    @Column(name = "first_name")
    private String firstName = "noname";

    /** Define o nome da coluna e outros atributos */
    @Column(name = "last_name", length = 255, nullable = false)
    private String lastName;

    /** Quando não quer persistir o valor */
    @Transient
    private Integer age;

    /** Definindo que vira de um enum, pelo nome, nao pela ordinal */
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

}
