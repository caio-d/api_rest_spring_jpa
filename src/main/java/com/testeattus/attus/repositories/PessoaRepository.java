package com.testeattus.attus.repositories;

import com.testeattus.attus.dto.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
