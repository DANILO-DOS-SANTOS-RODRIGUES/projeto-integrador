package com.example.projetointegrador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "taxa")
public class Taxa {

    @Id //id da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_taxa")
    private Long id;

//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//    @JoinTable(name = "documento_taxa",
//            joinColumns = @JoinColumn(name = "id_documento"),
//            inverseJoinColumns = @JoinColumn(name="id_taxa"))
//    private Documento documento;

    @Column(name = "nome")
    private String nome;

    @Column(name = "porcentagem")
    private Double porcentagem;

}
