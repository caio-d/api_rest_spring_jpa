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

    public Pessoa save(Pessoa pessoa) {
        return this.repository.save(pessoa);
    }

    public List<Pessoa> getAll() {
        return this.repository.findAll();
    }

    public Pessoa findById(Long id) throws PessoaNotFoundException {
        return this.repository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada com o ID: " + id));
    }

    public Pessoa deleteById(Long id) {
        Pessoa pessoa = this.findById(id);
        this.repository.deleteById(id);
        return pessoa;
    }

}
