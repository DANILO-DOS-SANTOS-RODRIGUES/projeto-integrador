package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Pessoa;
import com.example.projetointegrador.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService{
    final PessoaRepository pessoaRepository;//realiza as consutas e incerções no banco
    public PessoaServiceImpl(PessoaRepository pessoaRepository)
    {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa editar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    @Override
    public Pessoa salvar(Pessoa pessoa){

        return pessoaRepository.save(pessoa);
    }
    @Override
    public void deletar(Long id_pessoa){
        pessoaRepository.deleteById(id_pessoa);
    }

    /*
    Validações
[ ] Não deixar salvar uma pessoa com o mesmo cpf ou identidade;
[ ] Não deixar salvar uma pessoa com o mesmo numero da casa;
[ ] Não deixar salvar uma cateira com o mesmo nome;


[ ] Não deixar salvar uma taxa com o mesmo nome;
[ ] Não deixar salvar um documento com o mesmo cpf ou identidade;

     */
}
