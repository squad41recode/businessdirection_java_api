package br.com.businessdirection.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
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
	private Long id;

	private String nome;
	private String sobrenome;
	private String whatsapp;
	private String email;
	private String tipoExperiencia;
	private Date dataNascimento;
	
    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

	//@OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OneToMany(mappedBy = "mentor",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MentorModalidade> mentoriasDisponiveis;


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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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
