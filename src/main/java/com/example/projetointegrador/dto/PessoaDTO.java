package com.example.projetointegrador.dto;

import com.example.projetointegrador.models.Carteira;
import com.example.projetointegrador.models.Documento;
import com.example.projetointegrador.models.Endereco;
import com.example.projetointegrador.models.Taxa;
import lombok.Data;

@Data
public class PessoaDTO {

    private Long id_pessoa;

    private String nome;

    private String genero;

    private Integer idade;

    private String estadoCivil;

    private String dependentes;

    private Double rendimentoMensal;

    private Documento documento;

    private Carteira carteira;

    private Endereco endereco;

    private Taxa taxa;

}
