package com.giovanni.loja.dto;

import com.giovanni.loja.model.Loja;
import lombok.Data;

@Data
public class ProdutoDto {

    private Long idloja;

    private String marca;

    private String modelo;

    private String descricao;
}
