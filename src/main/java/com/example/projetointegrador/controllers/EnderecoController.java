package com.example.projetointegrador.controllers;


import com.example.projetointegrador.models.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projetointegrador.services.EnderecoServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class EnderecoController {
    final EnderecoServiceImpl enderecoServiceImpl;

    public EnderecoController(com.example.projetointegrador.services.EnderecoServiceImpl enderecoService) {
        enderecoServiceImpl = enderecoService;
    }


    @PostMapping(value = "/salvarEndereco")
    public ResponseEntity<Object>salvarEndereco(@RequestBody Endereco endereco){
        Endereco response = enderecoServiceImpl.salvar(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping(value = "/buscarEndereco")
    public ResponseEntity<Object>buscarCarteira(){
        List<Endereco> response = enderecoServiceImpl.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value ="/alterarEndereco")
    public ResponseEntity<Object>alterarCarteira(@RequestBody Endereco endereco){
        Endereco response = enderecoServiceImpl.editar(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
