package com.example.projetointegrador.services;

import com.example.projetointegrador.dto.PessoaDTO;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
import com.example.projetointegrador.models.Pessoa;
import com.example.projetointegrador.repositories.PessoaRepository;
import com.example.projetointegrador.repositories.TaxaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public Pessoa editar(PessoaDTO pessoaDTO){
        Pessoa pessoaEdita = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .genero(pessoaDTO.getGenero())
                .idade(pessoaDTO.getIdade())
                .estadoCivil(pessoaDTO.getEstadoCivil())
                .dependentes(pessoaDTO.getDependentes())
                .rendimentoMensal(pessoaDTO.getRendimentoMensal())
                .documento(pessoaDTO.getDocumento())
                .carteira(pessoaDTO.getCarteira())
                .endereco(pessoaDTO.getEndereco())
                .taxa(pessoaDTO.getTaxa())
                .build();
        return pessoaRepository.save(pessoaEdita);
    }
    @Override
    public Pessoa salvar(PessoaDTO pessoaDTO) throws Exception {
        List<Pessoa> listaDePessoa = pessoaRepository.findAll();

        for(Pessoa pessoa1 : listaDePessoa){
            if(pessoaDTO.getDocumento().getCpf().equals(pessoa1.getDocumento().getCpf()) || pessoaDTO.getDocumento().getIdentidade().equals(pessoa1.getDocumento().getIdentidade())){
                throw new EntityNotFoundException("Esse documento ja existe, insira outro documento");
            }
            if(pessoaDTO.getEndereco().getNumeroCasa().equals(pessoa1.getEndereco().getNumeroCasa())){
                throw new EntityNotFoundException("Esse numero de casa ja foi cadastrado, por favor insira outro numero");
            }
            if(pessoaDTO.getEndereco().getCep().equals(pessoa1.getEndereco().getCep())){
                throw new EntityNotFoundException("Esse cep de casa ja foi cadastrado, por favor insira outro cep");
            }
        }
        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .genero(pessoaDTO.getGenero())
                .idade(pessoaDTO.getIdade())
                .estadoCivil(pessoaDTO.getEstadoCivil())
                .dependentes(pessoaDTO.getDependentes())
                .rendimentoMensal(pessoaDTO.getRendimentoMensal())
                .documento(pessoaDTO.getDocumento())
                .carteira(pessoaDTO.getCarteira())
                .endereco(pessoaDTO.getEndereco())
                .taxa(pessoaDTO.getTaxa())
                .build();
        return pessoaRepository.save(pessoa);
    }
    @Override
    public void deletar(Long id_pessoa){
        pessoaRepository.deleteById(id_pessoa);
    }


    public void adicionarTaxa() {

        List<Pessoa> listaDeTaxa = pessoaRepository.findAll();
        for(Pessoa pessoa2 : listaDeTaxa){
            PessoaDTO pessoaDTO = new PessoaDTO();
            if(pessoa2.getCarteira().getSaldoAtual() != null && pessoa2.getTaxa() != null && pessoa2.getTaxa().getPorcentagem() != null){
                Double saldoAtual = pessoa2.getCarteira().getSaldoAtual();
                BigDecimal juros = pessoa2.getTaxa().getPorcentagem();
                Double rendimento = saldoAtual + (saldoAtual * (juros.doubleValue()/100));
                pessoa2.getCarteira().setSaldoAtual(rendimento);

                pessoa2 = Pessoa.builder()
                        .nome(pessoaDTO.getNome())
                        .genero(pessoaDTO.getGenero())
                        .idade(pessoaDTO.getIdade())
                        .estadoCivil(pessoaDTO.getEstadoCivil())
                        .dependentes(pessoaDTO.getDependentes())
                        .rendimentoMensal(pessoaDTO.getRendimentoMensal())
                        .documento(pessoaDTO.getDocumento())
                        .carteira(pessoaDTO.getCarteira())
                        .endereco(pessoaDTO.getEndereco())
                        .taxa(pessoaDTO.getTaxa())
                        .build();
                pessoaRepository.save(pessoa2);
            }

        }

    }
}
