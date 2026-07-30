package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.farmacia.model.Produto;


public interface ProdutoRepository extends JpaRepository <Produto, Long>{
	public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	//Implementação extra: Buscar produtos baratos (abaixo de um valor) e ordenados por preço
	public List<Produto> findAllByPrecoLessThanEqualOrderByPrecoAsc(int preco);
}
