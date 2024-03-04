package com.testeattus.attus.servicestest;

import com.testeattus.attus.dto.endereco.Endereco;
import com.testeattus.attus.dto.pessoa.Pessoa;
import com.testeattus.attus.dto.pessoa.PessoaRequest;
import com.testeattus.attus.dto.pessoa.PessoaResponse;
import com.testeattus.attus.dto.pessoa.exceptions.PessoaNotFoundException;
import com.testeattus.attus.repositories.PessoaRepository;
import com.testeattus.attus.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @MockBean
    private PessoaRepository pessoaRepository;

    @Test
    public void insert() {
        PessoaRequest pessoaRequest = new PessoaRequest("nome", "data", 1l);
        Pessoa pessoa = new Pessoa(pessoaRequest);

        PessoaResponse pessoaResponse = new PessoaResponse(pessoa);

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);
        Pessoa result = pessoaService.save(pessoa);

        assertEquals(pessoa, result);
    }

    @Test
    public void getAll() {

        PessoaRequest pessoaRequest = new PessoaRequest("nome", "data", 1l);
        PessoaRequest pessoaRequest2 = new PessoaRequest("nome", "data", null);
        Pessoa pessoa = new Pessoa(pessoaRequest);
        Pessoa pessoa2 = new Pessoa(pessoaRequest2);

        List<Pessoa> pessoasList = Arrays.asList(pessoa, pessoa2);

        when(pessoaRepository.findAll()).thenReturn(pessoasList);

        List<Pessoa> result = pessoaService.getAll();

        assertEquals(pessoasList, result);
    }

    @Test
    public void findById() {
        Long id = 0l;
        PessoaRequest pessoaRequest = new PessoaRequest("nome", "data", 1l);
        Pessoa pessoa = new Pessoa(pessoaRequest);

        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));

        Pessoa result = pessoaService.findById(id);

        assertEquals(pessoa, result);
    }

    @Test
    public void testFindByIdNotFound() {
        when(pessoaRepository.findById(1l)).thenReturn(Optional.empty());
        assertThrows(PessoaNotFoundException.class, () -> pessoaService.findById(1l));
    }

}
