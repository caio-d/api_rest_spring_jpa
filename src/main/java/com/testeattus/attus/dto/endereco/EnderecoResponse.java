package com.testeattus.attus.dto.endereco;

import lombok.NonNull;

public record EnderecoResponse(Long id, String logradouro, String cep, Long numero, String cidade, String estado, Long pessoa_id) {
    public EnderecoResponse(@NonNull Endereco endereco) {
        this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado(), endereco.getPessoa_id());
    }
}
