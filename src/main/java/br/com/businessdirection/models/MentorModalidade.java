package br.com.businessdirection.models;

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
@Table(name = "MentorModalidade")
public class MentorModalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_Mentor_id", nullable = false)
	private Mentor mentor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_ModalidadeMentoria_id", nullable = false)
	private ModalidadeMentoria modalidadeMentoria;

	private String diaSemana;

	private String horario;

	@Column(name = "ativo", nullable = false)
	private boolean ativo = true; // ativo por padrao

	public MentorModalidade(Long id, Mentor mentor, ModalidadeMentoria modalidadeMentoria, String diaSemana,
			String horario, boolean ativo) {
		super();
		this.id = id;
		this.mentor = mentor;
		this.modalidadeMentoria = modalidadeMentoria;
		this.diaSemana = diaSemana;
		this.horario = horario;
		this.ativo = ativo;
	}

	public MentorModalidade(Mentor mentor, ModalidadeMentoria modalidadeMentoria, String diaSemana, String horario) {
		super();
		this.mentor = mentor;
		this.modalidadeMentoria = modalidadeMentoria;
		this.diaSemana = diaSemana;
		this.horario = horario;
	}

	public MentorModalidade() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public ModalidadeMentoria getModalidadeMentoria() {
		return modalidadeMentoria;
	}

	public void setModalidadeMentoria(ModalidadeMentoria modalidadeMentoria) {
		this.modalidadeMentoria = modalidadeMentoria;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "MentorModalidade [id=" + id + ", mentor=" + mentor + ", modalidadeMentoria=" + modalidadeMentoria
				+ ", diaSemana=" + diaSemana + ", horario=" + horario + "]";
	}

}