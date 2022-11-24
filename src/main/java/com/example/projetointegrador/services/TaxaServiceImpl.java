package com.example.projetointegrador.services;

import com.example.projetointegrador.dto.TaxaDTO;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
import com.example.projetointegrador.models.Taxa;
import com.example.projetointegrador.repositories.TaxaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class TaxaServiceImpl implements TaxaService{
    final TaxaRepository taxaRepository;//realiza as consutas e incerções no banco
    public TaxaServiceImpl(TaxaRepository taxaRepository)
    {
        this.taxaRepository = taxaRepository;
    }

    @Override
    public List<Taxa> listar(){
        return taxaRepository.findAll();
    }

    @Override
    public Taxa editar(TaxaDTO taxaDTO){
        Taxa taxa = Taxa.builder()
                .nome(taxaDTO.getTaxaNome())
                .porcentagem(taxaDTO.getPorcentagem() != null ? new BigDecimal(taxaDTO.getPorcentagem()) : null)
                .build();
        return taxaRepository.save(taxa);
    }
    @Override
    public Taxa salvar(TaxaDTO taxaDTO) throws Exception {
        List<Taxa> listaDeTaxa = taxaRepository.findAll();

        for(Taxa nomeTaxa : listaDeTaxa){
            if(taxaDTO.getTaxaNome().equals(nomeTaxa.getNome())){
                throw new EntityNotFoundException("Esse nome de taxa ja existe, insira outro nome de taxa");
            }
        }
        Taxa taxa = Taxa.builder()
                .nome(taxaDTO.getTaxaNome())
                .porcentagem(taxaDTO.getPorcentagem() != null ? new BigDecimal(taxaDTO.getPorcentagem()) : null)
                .build();

        return taxaRepository.save(taxa);
    }
    @Override
    public void deletar(Long id_taxa){
        taxaRepository.deleteById(id_taxa);
    }
}
