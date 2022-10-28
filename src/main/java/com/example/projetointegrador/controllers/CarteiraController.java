package com.example.projetointegrador.controllers;

import com.example.projetointegrador.dto.CarteiraDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/api")
@CrossOrigin
public class CarteiraController {
    @PostMapping(value= "/salvarCarteira")
    public ResponseEntity<Object> salvarCarteira(@RequestBody CarteiraDTO carteiraDTO){
        System.out.println(carteiraDTO);
        return null;
    }
}
