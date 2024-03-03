package com.testeattus.attus.service;

import com.testeattus.attus.dto.pessoa.Pessoa;
import com.testeattus.attus.dto.pessoa.exceptions.PessoaNotFoundException;
import com.testeattus.attus.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.repository = pessoaRepository;
    }

    public void save(Pessoa pessoa) {
        this.repository.save(pessoa);
    }

    public List<Pessoa> getAll() {
        return this.repository.findAll();
    }

    public Pessoa findById(Long id) throws PessoaNotFoundException {
        return this.repository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Carteira não encontrada com o ID: " + id));
    }

}
