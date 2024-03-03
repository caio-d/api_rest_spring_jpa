package com.testeattus.attus.service;

import com.testeattus.attus.dto.endereco.Endereco;
import com.testeattus.attus.dto.endereco.exceptions.EnderecoNotFoundException;
import com.testeattus.attus.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.repository = enderecoRepository;
    }

    public void save(Endereco endereco) {
        this.repository.save(endereco);
    }

    public List<Endereco> getAll() {
        return this.repository.findAll();
    }

    public Endereco findById(Long id) throws EnderecoNotFoundException {
        return this.repository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException("Carteira não encontrada com o ID: " + id));
    }
}
