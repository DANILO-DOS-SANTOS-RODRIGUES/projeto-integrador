package com.example.projetointegrador.controllers;

import com.example.projetointegrador.dto.DocumentoDTO;
import com.example.projetointegrador.models.Documento;
import com.example.projetointegrador.services.DocumentoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class DocumentoController {
    final DocumentoServiceImpl documentoServiceImpl;

    public DocumentoController(DocumentoServiceImpl documentoService) {
        this.documentoServiceImpl = documentoService;
    }

    @PostMapping(value= "/salvarDocumento")
    public ResponseEntity<Object> salvarDocumento(@RequestBody DocumentoDTO documentoDTO) throws Exception {
        Documento response = documentoServiceImpl.salvar(documentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping(value="/buscarDocumento")
    public ResponseEntity<Object> buscarDocumento(){
        List<Documento> response = documentoServiceImpl.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(response) ;
    }
    @PutMapping(value = "/alterarDocumento")
    public ResponseEntity<Object> alterarDocumento(@RequestBody DocumentoDTO documentoDTO){
        Documento response = documentoServiceImpl.editar(documentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping(value ="/deletarDocumento")
    public ResponseEntity<Object>deletarDocumento(Long id_documento){
        documentoServiceImpl.deletar(id_documento);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
