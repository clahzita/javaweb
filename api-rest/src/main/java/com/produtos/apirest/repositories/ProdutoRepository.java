package com.produtos.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.produtos.apirest.models.Produto;

/**
 * Facilita a persistencia de dados no banco.
 * @author clah
 *
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
