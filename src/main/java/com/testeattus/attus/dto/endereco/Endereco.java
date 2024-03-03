package com.testeattus.attus.dto.endereco;

import com.testeattus.attus.dto.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tb_endereco")
@Entity(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private Long numero;
    private String cidade;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Endereco(@NonNull EnderecoRequest enderecoRequest){
        this.logradouro = enderecoRequest.logradouro();
        this.cep = enderecoRequest.cep();
        this.numero = enderecoRequest.numero();
        this.cidade = enderecoRequest.cidade();
        this.estado = enderecoRequest.estado();
    }

}
