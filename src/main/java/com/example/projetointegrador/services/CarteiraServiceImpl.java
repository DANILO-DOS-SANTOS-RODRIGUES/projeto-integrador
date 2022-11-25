package com.example.projetointegrador.services;

import com.example.projetointegrador.dto.CarteiraDTO;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
import com.example.projetointegrador.models.Carteira;
import com.example.projetointegrador.repositories.CarteiraRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarteiraServiceImpl implements CarteiraService{
    final CarteiraRepository carteiraRepository;

    public CarteiraServiceImpl(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }
    @Override
    public List<Carteira> listar(){
        return carteiraRepository.findAll();
    }
    @Override
    public Carteira editar(CarteiraDTO carteiraDTO){
        Carteira carteira = Carteira.builder()
                .nome(carteiraDTO.getNome() != null ? carteiraDTO.getNome() : null)
                .saldoAtual(carteiraDTO.getSaldoAtual() != null ? carteiraDTO.getSaldoAtual() : null)
                .dataInicioInvestimento(carteiraDTO.getDataInicioInvestimento())
                .dataTerminoInvestimento(carteiraDTO.getDataTerminoInvestimento())
                .build();

        return carteiraRepository.save(carteira);
    }

    @Override
    public Carteira salvar(CarteiraDTO carteiraDTO) throws Exception { // é o ultimo passo e é onde valida a regra de negocio
       // List<Carteira> listaDeCarteiras = carteiraRepository.findCarteiraByNome(carteira.getNome());

        List<Carteira> listaDeCarteiras = carteiraRepository.findAll();

        for(Carteira nomeCarteira : listaDeCarteiras){
            if(carteiraDTO.getNome().equals(nomeCarteira.getNome())){
                throw new EntityNotFoundException("Esse nome ja existe, insira outro nome");
            }
        }

        Carteira carteira = Carteira.builder()
                .nome(carteiraDTO.getNome() )
                .saldoAtual(carteiraDTO.getSaldoAtual() )
                .dataInicioInvestimento(carteiraDTO.getDataInicioInvestimento())
                .dataTerminoInvestimento(carteiraDTO.getDataTerminoInvestimento())
                .build();
        return carteiraRepository.save(carteira);
    }
    @Override
    public void deletar(Long id_carteira){
        carteiraRepository.deleteById(id_carteira);
    }

}
