package com.giovanni.loja.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /* Relacionamento um pra um*/
    @OneToOne
    @JoinColumn(name = "loja_id", referencedColumnName = "id")
    private Loja loja;

    private String marca;

    private String modelo;

    private String descricao;

    public Produto(Loja loja, String marca, String modelo, String descricao) {
        this.loja = loja;
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
    }
}
