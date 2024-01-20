package br.com.businessdirection.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ModalidadeMentoria")
public class ModalidadeMentoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomeModalidade;

	@OneToOne(mappedBy = "modalidadeMentoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // , orphanRemoval =
																									// true
	private ConteudoOnline conteudoOnline;

//	talvez criar um metodo que calcula a qtd e passa o valor pra ca
	/*
	 * private int qtdMentores; private int qtdEmpreendedores;
	 */

	public ModalidadeMentoria() {
		super();
	}

	public ModalidadeMentoria(Long id, String nomeModalidade) {
		super();
		this.id = id;
		this.nomeModalidade = nomeModalidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}

}
