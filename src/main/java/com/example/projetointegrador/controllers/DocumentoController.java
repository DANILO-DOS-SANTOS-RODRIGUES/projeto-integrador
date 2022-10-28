package com.example.projetointegrador.controllers;

import com.example.projetointegrador.dto.DocumentoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class DocumentoController {
    @PostMapping(value ="/salvarDocumento")
    public ResponseEntity<Object>salvarDocumento(@RequestBody DocumentoDTO documentoDTO){
        System.out.println(documentoDTO);
        return null;
    }
}
