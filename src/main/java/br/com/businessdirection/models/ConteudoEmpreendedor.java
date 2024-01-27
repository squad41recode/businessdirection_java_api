package br.com.businessdirection.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ConteudoEmpreendedor")
public class ConteudoEmpreendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_ConteudoOnline_id", nullable = false)
	private ConteudoOnline conteudoOnline;

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_empreendedor_id", nullable = false)
	private Empreendedor empreendedor;

	private String status;
	private LocalDate dataInicio;
	private LocalDate dataFim;

	@Column(name = "ativo", nullable = false)
	private boolean ativo = true;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public ConteudoEmpreendedor() {
		super();
	}

	public ConteudoEmpreendedor(Long id, ConteudoOnline conteudoOnline, Empreendedor empreendedor, String status,
			LocalDate dataInicio, LocalDate dataFim, boolean ativo) {
		super();
		this.id = id;
		this.conteudoOnline = conteudoOnline;
		this.empreendedor = empreendedor;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConteudoOnline getConteudoOnline() {
		return conteudoOnline;
	}

	public void setConteudoOnline(ConteudoOnline conteudoOnline) {
		this.conteudoOnline = conteudoOnline;
	}

	public Empreendedor getEmpreendedor() {
		return empreendedor;
	}

	public void setEmpreendedor(Empreendedor empreendedor) {
		this.empreendedor = empreendedor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

}
