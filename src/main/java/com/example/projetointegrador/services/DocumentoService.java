package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Documento;
import java.util.List;

public interface DocumentoService {
    List<Documento> listar();
    Documento editar(Documento documento);
    Documento salvar(Documento documento) throws Exception;
    void deletar(Long id_documento);
}
