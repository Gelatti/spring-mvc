package br.com.grupopanvel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa")
public class PessoaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cidade_natal")
    private String cidadeNatal;

    @Column(name = "data_de_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_de_modificacao")
    private LocalDateTime dataModificacao;
}
