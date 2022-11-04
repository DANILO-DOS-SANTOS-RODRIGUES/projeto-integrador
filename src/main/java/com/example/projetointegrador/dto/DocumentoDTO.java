package com.example.projetointegrador.dto;

import lombok.Data;

@Data
public class DocumentoDTO {

    private Long id_documento;

    private String cpf;

    private String cnpj;

    private String identidade;
}
