package com.testeattus.attus.controller;

import com.testeattus.attus.dto.endereco.Endereco;
import com.testeattus.attus.dto.endereco.exceptions.EnderecoNotFoundException;
import com.testeattus.attus.dto.pessoa.Pessoa;
import com.testeattus.attus.dto.pessoa.PessoaRequest;
import com.testeattus.attus.dto.pessoa.PessoaResponse;
import com.testeattus.attus.service.EnderecoService;
import com.testeattus.attus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;
    private final EnderecoService enderecoService;

    @Autowired
    public PessoaController(PessoaService pessoaService, EnderecoService enderecoService) {
        this.pessoaService = pessoaService;
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> insert(@RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoa = new Pessoa(pessoaRequest);
        pessoaService.save(pessoa);
        return ResponseEntity.ok().body(new PessoaResponse(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> getAll() {
        List<PessoaResponse> response = pessoaService.getAll().stream()
                .map(PessoaResponse::new).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok(new PessoaResponse(pessoa));
    }

    @PatchMapping("{id}")
    public ResponseEntity<PessoaResponse> patch(@PathVariable Long id, @RequestBody PessoaRequest pessoaRequest) {

        Pessoa pessoa = pessoaService.findById(id);

        if (pessoaRequest.nome() != null) pessoa.setNome(pessoaRequest.nome());
        if (pessoaRequest.data_nascimento() != null) pessoa.setData_nascimento(pessoaRequest.data_nascimento());

        if (pessoaRequest.endereco_principal_id() != null) {
            enderecoService.findById(pessoaRequest.endereco_principal_id());
            pessoa.setEndereco_principal_id(pessoaRequest.endereco_principal_id());
        }

        pessoaService.save(pessoa);

        return ResponseEntity.ok().body(new PessoaResponse(pessoa));
    }


}
