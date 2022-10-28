package com.example.projetointegrador.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
public class CarteiraDTO {

    private Long id;

    private String nome;

    private Double saldoAtual;

    private LocalDate dataInicioInvestimento;

    private LocalDate dataTerminoInvestimento;
}
