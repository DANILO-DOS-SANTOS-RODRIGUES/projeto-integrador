package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Documento;
import com.example.projetointegrador.repositories.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentoServiceImpl implements DocumentoService {
    final DocumentoRepository documentoRepository;//realiza as consutas e incerções no banco
    public DocumentoServiceImpl(DocumentoRepository documentoRepository)
    {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public List<Documento> listar(){
        return documentoRepository.findAll();
    }

    @Override
    public Documento editar(Documento documento){
        return documentoRepository.save(documento);
    }
    @Override
    public Documento salvar(Documento documento){
        return documentoRepository.save(documento);
    }
    @Override
    public void deletar(Long id_documento){
        documentoRepository.deleteById(id_documento);
    }
}
