package com.example.projetointegrador.services;

import com.example.projetointegrador.dto.DocumentoDTO;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
import com.example.projetointegrador.models.Documento;
import com.example.projetointegrador.models.Taxa;
import com.example.projetointegrador.repositories.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public Documento editar(DocumentoDTO documentoDTO){
        Documento documento = Documento.builder()
                .cpf(documentoDTO.getCpf())
                .cnpj(documentoDTO.getCnpj())
                .identidade(documentoDTO.getRg())
                .build();
        return documentoRepository.save(documento);
    }
    @Override
    public Documento salvar(DocumentoDTO documentoDTO) throws Exception {
        List<Documento> listaDeDocumento = documentoRepository.findAll();

        for(Documento documento1 : listaDeDocumento){
            if(documentoDTO.getCpf().equals(documento1.getCpf()) || documentoDTO.getIdentidade().equals(documento1.getIdentidade()) ){
                throw new EntityNotFoundException("Esse documento ja existe, insira outro documento");
            }
        }
        Documento documento = Documento.builder()
                .cpf(documentoDTO.getCpf())
                .cnpj(documentoDTO.getCnpj())
                .identidade(documentoDTO.getRg())
                .build();
        return documentoRepository.save(documento);
    }
    @Override
    public void deletar(Long id_documento){
        documentoRepository.deleteById(id_documento);
    }
}
