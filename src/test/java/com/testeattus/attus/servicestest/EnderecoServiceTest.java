package com.testeattus.attus.servicestest;

import com.testeattus.attus.dto.endereco.Endereco;
import com.testeattus.attus.dto.endereco.EnderecoRequest;
import com.testeattus.attus.dto.endereco.exceptions.EnderecoNotFoundException;
import com.testeattus.attus.repositories.EnderecoRepository;
import com.testeattus.attus.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnderecoServiceTest {

    @Autowired
    private EnderecoService service;

    @MockBean
    private EnderecoRepository repository;

    @Test
    public void testInsert() {

        EnderecoRequest request = new EnderecoRequest("logradouro", "cep", 1l, "blumenau", "sc", 1l);
        Endereco endereco = new Endereco(request);

        when(repository.save(any(Endereco.class))).thenReturn(endereco);

        Endereco result = service.save(endereco);

        assertEquals(endereco, result);

    }

    @Test
    public void testGetAll() {

        EnderecoRequest request = new EnderecoRequest("logradouro", "cep", 1l, "blumenau", "sc", 1l);
        Endereco endereco = new Endereco(request);
        EnderecoRequest request2 = new EnderecoRequest("logradouro", "cep", 999l, "blumenau", "sc", 2l);
        Endereco endereco2 = new Endereco(request2);

        List<Endereco> list = Arrays.asList(endereco, endereco2);

        when(repository.findAll()).thenReturn(list);

        List<Endereco> result = service.getAll();

        assertEquals(list, result);
    }

    @Test
    public void testFindById() {
        Long id = 1l;
        EnderecoRequest request = new EnderecoRequest("logradouro", "cep", 1l, "blumenau", "sc", 1l);
        Endereco endereco = new Endereco(request);
        when(repository.findById(id)).thenReturn(Optional.of(endereco));
        Endereco result = service.findById(id);
        assertEquals(endereco, result);
    }

    @Test
    public void testFindByIdNotFound() {
        when(repository.findById(1l)).thenReturn(Optional.empty());
        assertThrows(EnderecoNotFoundException.class, () -> service.findById(1l));
    }

}
