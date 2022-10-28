package com.example.projetointegrador.controllers;

import com.example.projetointegrador.dto.TaxaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class TaxaController {
    @PostMapping(value = "/salvarTaxa")
    public ResponseEntity<Object>salvarTaxa(@RequestBody TaxaDTO taxaDTO){
        System.out.println(taxaDTO);
        return null;
    }
}
