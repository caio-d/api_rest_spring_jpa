package com.testeattus.attus.dto.pessoa.exceptions;

import java.util.function.Supplier;

public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(String mensagem) {
        super(mensagem);
    }

}
