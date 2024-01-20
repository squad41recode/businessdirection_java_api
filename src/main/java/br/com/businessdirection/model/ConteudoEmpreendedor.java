package br.com.businessdirection.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ConteudoEmpreendedor")
public class ConteudoEmpreendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_ConteudoOnline_id", nullable = false)
	private ConteudoOnline conteudoOnline;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_empreendedor_id", nullable = false)
	private Empreendedor empreendedor;

	private String status;
	private Date dataInicio;
	private Date dataFim;

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
			Date dataInicio, Date dataFim, boolean ativo) {
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
