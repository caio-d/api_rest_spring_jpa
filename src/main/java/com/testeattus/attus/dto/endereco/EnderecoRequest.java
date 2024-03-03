package com.testeattus.attus.dto.endereco;

import lombok.NonNull;

public record EnderecoRequest(String logradouro, String cep, Long numero, String cidade, String estado) {
    public EnderecoRequest(@NonNull Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado());
    }
}
