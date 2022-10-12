package com.example.projetointegrador.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// o @ significa que é uma anotation
@Data //traz todos os getter and setters por meio do lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pessoa {
    private String nome;
    private Documento documento;
    private Endereco endereco;
    private String genero;
    private Integer idade;
    private Double rendimentoMensal;
    private String estadoCivil;
    private String dependentes;
    private Carteira carteira;

}
