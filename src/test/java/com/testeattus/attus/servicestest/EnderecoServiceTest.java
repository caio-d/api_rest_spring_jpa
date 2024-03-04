package com.testeattus.attus.servicestest;

import com.testeattus.attus.dto.endereco.Endereco;
import com.testeattus.attus.dto.endereco.EnderecoRequest;
import com.testeattus.attus.dto.pessoa.Pessoa;
import com.testeattus.attus.repositories.EnderecoRepository;
import com.testeattus.attus.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnderecoServiceTest {

    @Autowired
    private EnderecoService pessoaService;

    @MockBean
    private EnderecoRepository repository;

    @Test
    public void insert() {

        EnderecoRequest request = new EnderecoRequest("logradouro", "cep", 1l, "blumenau", "sc", 1l);
        Endereco endereco = new Endereco(request);

        when(repository.save(any(Endereco.class))).thenReturn(endereco);

        Endereco result = pessoaService.save(endereco);

        assertEquals(endereco, result);

    }

}
