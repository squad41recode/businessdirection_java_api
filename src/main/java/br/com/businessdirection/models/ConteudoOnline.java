package br.com.businessdirection.models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	@Column(unique = true)
	private Long id;

    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_ModalidadeMentoria_id", nullable = false)
	private ModalidadeMentoria modalidadeMentoria;

	private String conteudo;
	
    @JsonIgnore
    //private List<ModalidadeMentoria> modalidades;
	@OneToMany(mappedBy = "conteudoOnline",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ConteudoEmpreendedor> conteudosEmpreendedor;
	

	public ConteudoOnline() {
		super();
	}


	public ConteudoOnline(Long id, ModalidadeMentoria modalidadeMentoria, String conteudo,
			List<ConteudoEmpreendedor> conteudosEmpreendedor) {
		super();
		this.id = id;
		this.modalidadeMentoria = modalidadeMentoria;
		this.conteudo = conteudo;
		this.conteudosEmpreendedor = conteudosEmpreendedor;
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


	public List<ConteudoEmpreendedor> getConteudosEmpreendedor() {
		return conteudosEmpreendedor;
	}


	public void setConteudosEmpreendedor(List<ConteudoEmpreendedor> conteudosEmpreendedor) {
		this.conteudosEmpreendedor = conteudosEmpreendedor;
	}


	@Override
	public int hashCode() {
		return Objects.hash(conteudo, conteudosEmpreendedor, id, modalidadeMentoria);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConteudoOnline other = (ConteudoOnline) obj;
		return Objects.equals(conteudo, other.conteudo)
				&& Objects.equals(conteudosEmpreendedor, other.conteudosEmpreendedor) && Objects.equals(id, other.id)
				&& Objects.equals(modalidadeMentoria, other.modalidadeMentoria);
	}


}
