package com.example.projetointegrador.controllers;

import com.example.projetointegrador.dto.EnderecoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class EnderecoController {
    @PostMapping(value = "/salvarEndereco")
    public ResponseEntity<Object>salvarEndereco(@RequestBody EnderecoDTO enderecoDTO){
        System.out.println(enderecoDTO);
        return null;
    }
}
