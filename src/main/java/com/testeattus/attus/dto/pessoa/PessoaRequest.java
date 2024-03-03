package com.testeattus.attus.dto.pessoa;

import lombok.NonNull;

public record PessoaRequest(String nome, String data_nascimento, Long endereco_principal_id) {
    public PessoaRequest(@NonNull Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getData_nascimento(), pessoa.getEndereco_principal_id());
    }
}
