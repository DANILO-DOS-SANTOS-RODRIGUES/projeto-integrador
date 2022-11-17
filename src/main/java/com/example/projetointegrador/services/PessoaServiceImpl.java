package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Pessoa;
import com.example.projetointegrador.models.Taxa;
import com.example.projetointegrador.repositories.PessoaRepository;
import com.example.projetointegrador.repositories.TaxaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService{
    final PessoaRepository pessoaRepository;//realiza as consutas e incerções no banco
    final TaxaRepository taxaRepository;
    public PessoaServiceImpl(PessoaRepository pessoaRepository, TaxaRepository taxaRepository)
    {
        this.pessoaRepository = pessoaRepository;
        this.taxaRepository = taxaRepository;
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
    public Pessoa salvar(Pessoa pessoa) throws Exception {
        List<Pessoa> listaDePessoa = pessoaRepository.findAll();

        for(Pessoa pessoa1 : listaDePessoa){
            if(pessoa.getDocumento().getCpf().equals(pessoa1.getDocumento().getCpf()) || pessoa.getDocumento().getIdentidade().equals(pessoa1.getDocumento().getIdentidade())){
                throw new Exception("Esse documento ja existe, insira outro documento");
            }
            if(pessoa.getEndereco().getNumeroCasa().equals(pessoa1.getEndereco().getNumeroCasa())){
                throw new Exception("Esse numero de casa ja foi cadastrado, por favor insira outro numero");
            }
        }
        return pessoaRepository.save(pessoa);
    }
    @Override
    public void deletar(Long id_pessoa){
        pessoaRepository.deleteById(id_pessoa);
    }


    public void adicionarTaxa() {
        List<Pessoa> listaDeTaxa = pessoaRepository.findAll();
        for(Pessoa pessoa2 : listaDeTaxa){

            if(pessoa2.getCarteira().getSaldoAtual() != null && pessoa2.getTaxa() != null && pessoa2.getTaxa().getPorcentagem() != null){
                Double saldoAtual = pessoa2.getCarteira().getSaldoAtual();
                Double juros = pessoa2.getTaxa().getPorcentagem();
                Double rendimento = saldoAtual + (saldoAtual * (juros/100));
                pessoa2.getCarteira().setSaldoAtual(rendimento);
                pessoaRepository.save(pessoa2);
            }

        }

    }
}
