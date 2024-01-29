package br.com.businessdirection.models;

import java.util.Objects;

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
	@Column(unique = true)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_Mentor_id", nullable = false)
	private Mentor mentor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_ModalidadeMentoria_id", nullable = false)
	private ModalidadeMentoria modalidadeMentoria;

	private String diaSemana;

	private String horario;

	@Column(name = "disponivel", nullable = false)
	private boolean disponivel = true; 

	@Column(name = "ativo", nullable = false)
	private boolean ativo = true; // ativo por padrao

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

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public MentorModalidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MentorModalidade(Long id, Mentor mentor, ModalidadeMentoria modalidadeMentoria, String diaSemana,
			String horario, boolean disponivel, boolean ativo) {
		super();
		this.id = id;
		this.mentor = mentor;
		this.modalidadeMentoria = modalidadeMentoria;
		this.diaSemana = diaSemana;
		this.horario = horario;
		this.disponivel = disponivel;
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, diaSemana, disponivel, horario, id, mentor, modalidadeMentoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MentorModalidade other = (MentorModalidade) obj;
		return ativo == other.ativo && Objects.equals(diaSemana, other.diaSemana) && disponivel == other.disponivel
				&& Objects.equals(horario, other.horario) && Objects.equals(id, other.id)
				&& Objects.equals(mentor, other.mentor) && Objects.equals(modalidadeMentoria, other.modalidadeMentoria);
	}

}