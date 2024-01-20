package br.com.businessdirection.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ConteudoOnline")
public class ConteudoOnline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_ModalidadeMentoria_id", nullable = false)
	private ModalidadeMentoria modalidadeMentoria;

	private String conteudo;
	
	@OneToMany(mappedBy = "conteudoOnline",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ConteudoEmpreendedor> conteudosEmpreendedor;
	

	public ConteudoOnline() {
		super();
	}

	public ConteudoOnline(Long id, ModalidadeMentoria modalidadeMentoria, String conteudo) {
		super();
		this.id = id;
		this.modalidadeMentoria = modalidadeMentoria;
		this.conteudo = conteudo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ModalidadeMentoria getModalidadeMentoria() {
		return modalidadeMentoria;
	}

	public void setModalidadeMentoria(ModalidadeMentoria modalidadeMentoria) {
		this.modalidadeMentoria = modalidadeMentoria;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	

}
