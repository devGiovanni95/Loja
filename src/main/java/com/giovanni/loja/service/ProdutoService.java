package com.giovanni.loja.service;

import com.giovanni.loja.dto.ProdutoDto;
import com.giovanni.loja.model.Loja;
import com.giovanni.loja.model.Produto;
import com.giovanni.loja.repository.LojaRepository;
import com.giovanni.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    public List<ProdutoDto> produtoPorLoja(Long idLoja){

        List<Produto> produtosPorLoja = produtoRepository.findByLojaId(idLoja);

        return  mapProdutoDto(produtosPorLoja);
    }

    public void adicionaProduto(ProdutoDto produto){
        Loja loja = lojaRepository.findById(produto.getIdloja()).get();
        produtoRepository.save(new Produto(loja,produto.getMarca(), produto.getModelo(), produto.getDescricao()));

    }

    private List<ProdutoDto> mapProdutoDto(List<Produto> produtos){

        List<ProdutoDto> produtoDto = new ArrayList<>();

        produtos.forEach(item-> {
            ProdutoDto produtoEntity = new ProdutoDto(item.getId(), item.getMarca(),item.getModelo(),item.getDescricao());
            produtoDto.add(produtoEntity);
        });

        return produtoDto;
    }
}
