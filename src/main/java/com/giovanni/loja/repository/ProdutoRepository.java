package com.giovanni.loja.repository;

import com.giovanni.loja.model.Loja;
import com.giovanni.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

    List<Produto> findByLojaId(long idLoja);
}
