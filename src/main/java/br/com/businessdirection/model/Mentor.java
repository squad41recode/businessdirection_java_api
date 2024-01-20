package br.com.businessdirection.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mentor")
public class Mentor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long id;

	@Column(nullable = false, length = 50)
	private String nome;

	@Column(nullable = false, length = 100)
	private String sobrenome;

	@Column(nullable = false, length = 80, unique = true)
	private String email;

	@Column(name = "tipo_experiencia", nullable = false)
	private String tipoExperiencia;

	@Column(nullable = false, length = 15)
	private String whatsapp;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MentorModalidade> mentoriasDisponiveis;

	public String getNomeCompleto() {
		return nome + " " + sobrenome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoExperiencia() {
		return tipoExperiencia;
	}

	public void setTipoExperiencia(String tipoExperiencia) {
		this.tipoExperiencia = tipoExperiencia;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<MentorModalidade> getMentoriasDisponiveis() {
		return mentoriasDisponiveis;
	}

	public void setMentoriasDisponiveis(List<MentorModalidade> mentoriasDisponiveis) {
		this.mentoriasDisponiveis = mentoriasDisponiveis;
	}

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", whatsapp=" + whatsapp
				+ ", email=" + email + ", tipoExperiencia=" + tipoExperiencia + ", dataNascimento=" + dataNascimento
				+ "]";
	}

}
