package com.testeattus.attus.dto.endereco;


public record EnderecoRequest(String logradouro, String cep, Long numero, String cidade, String estado, Long pessoa_id) {

}
