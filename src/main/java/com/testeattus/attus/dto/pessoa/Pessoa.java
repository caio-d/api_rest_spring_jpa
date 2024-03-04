package com.testeattus.attus.dto.pessoa;

import com.testeattus.attus.dto.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "tb_pessoa")
@Entity(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String data_nascimento;
    private Long endereco_principal_id;

    @OneToMany(mappedBy = "pessoa_id", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(PessoaRequest pessoaRequest) {
        this.nome = pessoaRequest.nome();
        this.data_nascimento = pessoaRequest.data_nascimento();
    }
}


