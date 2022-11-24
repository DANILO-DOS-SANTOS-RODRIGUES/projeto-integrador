package com.example.projetointegrador.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CarteiraDTO {

    private Long id_carteira;

    private String nome;

    private Double saldoAtual;

    private LocalDate dataInicioInvestimento;

    private LocalDate dataTerminoInvestimento;

    private String carteiraNome;

    private Double saldo;

    private LocalDate inicioInvestimento;

    private LocalDate terminoInvestimento;
}
