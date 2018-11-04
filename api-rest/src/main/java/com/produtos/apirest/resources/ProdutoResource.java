package com.produtos.apirest.resources;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repositories.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
  
  @Autowired
  ProdutoRepository produtoRepository;

  @GetMapping("/produtos")
  public List<Produto> listaProdutos(){
    return produtoRepository.findAll();
  }
  
  @GetMapping("/produto/{id}")
  public Produto listaProdutoPorId(@PathVariable(value="id") long id){
    return produtoRepository.findById(id).get();
  }
  
  @PostMapping("/produto")
  public Produto salvarProduto(@RequestBody Produto produto) {
    return produtoRepository.save(produto);
  }
  
 
  
}