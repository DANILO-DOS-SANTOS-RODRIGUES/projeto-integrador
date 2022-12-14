package com.example.projetointegrador.models;

import lombok.*;

import javax.persistence.*;

// o @ significa que é uma anotation
@Entity
@Data //traz todos os getter and setters por meio do lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id_pessoa")//alterar uma taxa de uma pessoa
@Table(name ="pessoa")
public class Pessoa {

    @Id //id da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Long id_pessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "genero")
    private String genero;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "rendimentoMensal")
    private Double rendimentoMensal;

    @Column(name = "estadoCivil")
    private String estadoCivil;

    @Column(name = "dependentes")
    private String dependentes;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "pessoa_carteira",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_carteira"))
    private Carteira carteira;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "documento_pessoa",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name="id_documento"))
    private Documento documento;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "pessoa_endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private Endereco endereco;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "pessoa_Taxa",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_taxa"))
    private Taxa taxa;

}