package com.giovanni.loja.dto;

import com.giovanni.loja.model.Loja;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoDto {

    private Long idloja;

    private String marca;

    private String modelo;

    private String descricao;
}
