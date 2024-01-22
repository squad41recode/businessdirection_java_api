package br.com.businessdirection.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

//import jakarta.persistence.Access;
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
@Table(name = "Empreendedor")
public class Empreendedor {

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

	@Column(nullable = false, length = 15)
	private String telefone;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	@Column(nullable = false, length = 80)
	private String nomeEmpresa;

	private String cidade;
	private String estado;
	private String bairro;
	private String CEP;

	public String getNomeCompleto() {
		return nome + " " + sobrenome;
	}

	// @JsonIgnore
	// @JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "empreendedor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @BatchSize(size = 10)
	private List<EmpreendedorMentoria> mentoriasAdquiridas;

	// @JsonIgnore
	// @JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "empreendedor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	private List<ConteudoEmpreendedor> conteudosEstudados;

	public List<ConteudoEmpreendedor> getConteudosEmpreendedor() {
		return conteudosEstudados;
	}

	public void setConteudosEmpreendedor(List<ConteudoEmpreendedor> conteudosEstudados) {
		this.conteudosEstudados = conteudosEstudados;
	}

	public Empreendedor() {
		super();
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String Cep) {
		CEP = Cep;
	}

	public List<EmpreendedorMentoria> getMentoriasAdquiridas() {
		return mentoriasAdquiridas;
	}

	public void setMentoriasAdquiridas(List<EmpreendedorMentoria> mentoriasAdquiridas) {
		this.mentoriasAdquiridas = mentoriasAdquiridas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CEP, bairro, cidade, conteudosEstudados, dataNascimento, email, estado, id,
				mentoriasAdquiridas, nome, nomeEmpresa, sobrenome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Empreendedor other = (Empreendedor) obj;
		return Objects.equals(CEP, other.CEP) && Objects.equals(bairro, other.bairro)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(conteudosEstudados, other.conteudosEstudados)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(mentoriasAdquiridas, other.mentoriasAdquiridas) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeEmpresa, other.nomeEmpresa) && Objects.equals(sobrenome, other.sobrenome)
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Empreendedor [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento + ", telefone=" + telefone + ", email=" + email + ", nomeEmpresa=" + nomeEmpresa
				+ ", cidade=" + cidade + ", estado=" + estado + ", bairro=" + bairro + ", CEP=" + CEP + "]";
	}
}
