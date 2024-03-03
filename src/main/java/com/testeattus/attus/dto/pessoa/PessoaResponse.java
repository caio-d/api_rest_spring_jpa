package com.testeattus.attus.dto.pessoa;

import com.testeattus.attus.dto.endereco.Endereco;
import lombok.NonNull;

import java.util.List;

public record PessoaResponse(Long id, String nome, String data_nascimento, List<Endereco> enderecos, Long endereco_principal_id) {
    public PessoaResponse(@NonNull Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getData_nascimento(), pessoa.getEnderecos(), pessoa.getEndereco_principal_id());
    }
}
