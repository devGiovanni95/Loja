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
import java.util.NoSuchElementException;

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

    public void adicionarProduto(ProdutoDto produto){
        Loja loja = lojaRepository.findById(produto.getIdloja()).get();
        produtoRepository.save(new Produto(loja,produto.getMarca(), produto.getModelo(), produto.getDescricao(),produto.getPreco()));

    }

    public void editarProduto(ProdutoDto produtoDto, long id){

       produtoRepository.findById(id).ifPresentOrElse(item->{
            item.setDescricao(produtoDto.getDescricao());
            item.setPreco(produtoDto.getPreco());
        },()->{
            throw new NoSuchElementException();
       });
    }

    public  void deletarProduto(long id){
        Produto produto = produtoRepository.findById(id).get();//usa o get pois o findById retorna um Optional
        produtoRepository.delete(produto);
    }

    private List<ProdutoDto> mapProdutoDto(List<Produto> produtos){

        List<ProdutoDto> produtoDto = new ArrayList<>();

        produtos.forEach(item-> {
            ProdutoDto produtoEntity = new ProdutoDto(item.getId(), item.getMarca(),item.getModelo(),item.getDescricao(),item.getPreco());
            produtoDto.add(produtoEntity);
        });

        return produtoDto;
    }
}
