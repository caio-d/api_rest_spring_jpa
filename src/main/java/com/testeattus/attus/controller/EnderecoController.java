package com.testeattus.attus.controller;

import com.testeattus.attus.dto.endereco.Endereco;
import com.testeattus.attus.dto.endereco.EnderecoRequest;
import com.testeattus.attus.dto.endereco.EnderecoResponse;
import com.testeattus.attus.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService service;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.service = enderecoService;
    }

    @PostMapping
    public ResponseEntity<EnderecoResponse> insert(@RequestBody EnderecoRequest enderecoRequest) {
        Endereco endereco = new Endereco(enderecoRequest);
        service.save(endereco);
        return ResponseEntity.ok().body(new EnderecoResponse(endereco));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> getAll() {
        List<EnderecoResponse> response = service.getAll().stream()
                .map(EnderecoResponse::new).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnderecoResponse> findById(@PathVariable Long id) {
        Endereco endereco = service.findById(id);
        return ResponseEntity.ok(new EnderecoResponse(endereco));
    }

    @PatchMapping("{id}")
    public ResponseEntity<EnderecoResponse> patch(@PathVariable Long id, @RequestBody EnderecoRequest enderecoRequest) {

        Endereco endereco = service.findById(id);

        if (enderecoRequest.logradouro() != null) endereco.setLogradouro(enderecoRequest.logradouro());
        if (enderecoRequest.cep() != null) endereco.setCep(enderecoRequest.cep());
        if (enderecoRequest.numero() != null) endereco.setNumero(enderecoRequest.numero());
        if (enderecoRequest.cidade() != null) endereco.setCidade(enderecoRequest.cidade());
        if (enderecoRequest.estado() != null) endereco.setEstado(enderecoRequest.estado());
        if (enderecoRequest.pessoa_id() != null) endereco.setPessoa_id(enderecoRequest.pessoa_id());

        service.save(endereco);

        return ResponseEntity.ok().body(new EnderecoResponse(endereco));
    }

}
