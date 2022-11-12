package com.example.projetointegrador.repositories;

import com.example.projetointegrador.models.Pessoa;
import com.example.projetointegrador.models.Taxa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByTaxaPorcentagemAndCarteira_SaldoAtual(Double porcentagem, Double saldoAtual);
}
