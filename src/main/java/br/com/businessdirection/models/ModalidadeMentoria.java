package br.com.businessdirection.models;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	@Column(unique = true)
	private Long id;

	@Column(nullable = false, length = 80, unique = true)
	private String nomeModalidade;

	@OneToOne(mappedBy = "modalidadeMentoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ConteudoOnline conteudoOnline;

//	talvez criar um metodo que calcula a qtd e passa o valor pra ca
	/*
	 * private int qtdMentores; private int qtdEmpreendedores;
	 */

	public ModalidadeMentoria() {
		super();
	}
	
	public ModalidadeMentoria(Long id, String nomeModalidade, ConteudoOnline conteudoOnline) {
		super();
		this.id = id;
		this.nomeModalidade = nomeModalidade;
		this.conteudoOnline = conteudoOnline;
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

	public ConteudoOnline getConteudoOnline() {
		return conteudoOnline;
	}

	public void setConteudoOnline(ConteudoOnline conteudoOnline) {
		this.conteudoOnline = conteudoOnline;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudoOnline, id, nomeModalidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModalidadeMentoria other = (ModalidadeMentoria) obj;
		return Objects.equals(conteudoOnline, other.conteudoOnline) && Objects.equals(id, other.id)
				&& Objects.equals(nomeModalidade, other.nomeModalidade);
	}



}
