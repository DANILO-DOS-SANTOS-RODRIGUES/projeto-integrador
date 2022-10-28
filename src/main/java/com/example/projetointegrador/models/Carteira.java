package com.example.projetointegrador.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity //para criar a tabela
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "carteira")//nome da tabela
public class Carteira {

    @Id //id da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carteira")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "saldoAtual")
    private Double saldoAtual;

    @Column(name = "dataInicioInvestimento")
    private LocalDate dataInicioInvestimento;

    @Column(name = "dataTerminoInvestimento")
    private LocalDate dataTerminoInvestimento;
}
