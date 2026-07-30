package com.generation.farmacia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo tipo é obrigatório!")
	@Size(min = 2, max = 25, message = "O atributo tipo deve ter no mínimo 2 e no máximo 25 caracteres obrigatórios")
	@Column(length = 25)
	private String tipo;
	
	@NotBlank(message= "O atributo descricao é obrigatório!")
	@Size(min = 2, max = 500, message = "O atributo descrição deve ter no mínimo 2 e no máximo 500 caracter obrigatório")
	@Column(length = 500)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "categoria", allowSetters = true)
	private List<Produto> produto;*/
	
	

}
