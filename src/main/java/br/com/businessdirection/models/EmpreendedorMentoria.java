package br.com.businessdirection.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmpreendedorMentoria")
public class EmpreendedorMentoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	// cascade = CascadeType.ALL,
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_MentorModalidade_id", nullable = false)
	private MentorModalidade mentorModalidade;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_Empreendedor_id", nullable = false)
	private Empreendedor empreendedor;

	private String status;
	private int encontrosFeitos;
	private int faltas;

	@Column(name = "ativo", nullable = false)
	private boolean ativo = true; // ativo por padrao

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MentorModalidade getMentorModalidade() {
		return mentorModalidade;
	}

	public void setMentorModalidade(MentorModalidade mentorModalidade) {
		this.mentorModalidade = mentorModalidade;
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

	public int getEncontrosFeitos() {
		return encontrosFeitos;
	}

	public void setEncontrosFeitos(int encontrosFeitos) {
		this.encontrosFeitos = encontrosFeitos;

	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	@Override
	public int hashCode() {

		return Objects.hash(encontrosFeitos, faltas, empreendedor, id, mentorModalidade, status);

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpreendedorMentoria other = (EmpreendedorMentoria) obj;

		return encontrosFeitos == other.encontrosFeitos && faltas == other.faltas
				&& Objects.equals(empreendedor, other.empreendedor) && Objects.equals(id, other.id)
				&& Objects.equals(mentorModalidade, other.mentorModalidade) && Objects.equals(status, other.status);

	}

	@Override
	public String toString() {

		return "EmpreendedorMentoria [id=" + id + ", mentorModalidade=" + mentorModalidade + ", empreendedor="
				+ empreendedor + ", status=" + status + ", encontrosFeitos=" + encontrosFeitos + ", faltas=" + faltas
				+ "]";
	}

	public EmpreendedorMentoria(Long id, MentorModalidade mentorModalidade, Empreendedor empreendedor, String status,
			int encontrosFeitos, int faltas) {
		super();
		this.id = id;
		this.mentorModalidade = mentorModalidade;
		this.empreendedor = empreendedor;
		this.status = status;
		this.encontrosFeitos = encontrosFeitos;
		this.faltas = faltas;
	}

	public EmpreendedorMentoria() {
	}

}
