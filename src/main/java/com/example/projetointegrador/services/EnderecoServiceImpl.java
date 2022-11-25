package com.example.projetointegrador.services;


import com.example.projetointegrador.dto.EnderecoDTO;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
import com.example.projetointegrador.models.Endereco;
import com.example.projetointegrador.models.Taxa;
import com.example.projetointegrador.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService{
    final EnderecoRepository enderecoRepository;//realiza as consutas e incerções no banco
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository)
    {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<Endereco> listar() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco editar(EnderecoDTO enderecoDTO) {
        Endereco endereco = Endereco.builder()
                .logradouro(enderecoDTO.getLogradouro())
                .numeroCasa(enderecoDTO.getNumeroCasa())
                .referencia(enderecoDTO.getReferencia())
                .cep(enderecoDTO.getCep())
                .build();
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco salvar(EnderecoDTO enderecoDTO) throws Exception {
        List<Endereco> listaDeEndereco = enderecoRepository.findAll();

        for(Endereco endereco1 : listaDeEndereco){
            if(enderecoDTO.getCep() != null  && enderecoDTO.getCep().equals(endereco1.getCep())){
                throw new EntityNotFoundException("Esse cep ja existe, insira outro cep");
            }
        }

        Endereco endereco = Endereco.builder()
                .logradouro(enderecoDTO.getLogradouro())
                .numeroCasa(enderecoDTO.getNumeroCasa())
                .referencia(enderecoDTO.getReferencia())
                .cep(enderecoDTO.getCep())
                .build();

        return enderecoRepository.save(endereco);
    }

    @Override
    public void deletar(Long id_endereco){
        enderecoRepository.deleteById(id_endereco);
    }

}
