package com.example.projetointegrador.services;


import com.example.projetointegrador.models.Endereco;
import com.example.projetointegrador.repositories.EnderecoRepository;

import org.springframework.stereotype.Service;

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
    public Endereco editar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void deletar(Long id_endereco){
        enderecoRepository.deleteById(id_endereco);
    }

}
