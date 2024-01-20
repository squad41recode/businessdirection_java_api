package br.com.businessdirection.models;

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
@Table(name = "Empreendedor")
public class Empreendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private String telefone;
	private String email;
	private String nomeEmpresa;
	private String cidade;
	private String estado;
	private String bairro;
	private String CEP;

	public String getNomeCompleto() {
		return nome + " " + sobrenome;
	}

	@OneToMany(mappedBy = "empreendedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // (fetch =
																								// FetchType.EAGER)
	private List<EmpreendedorMentoria> mentoriasAdquiridas;

	@OneToMany(mappedBy = "empreendedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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
	public String toString() {
		return "Empreendedor [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento + ", telefone=" + telefone + ", email=" + email + ", nomeEmpresa=" + nomeEmpresa
				+ ", cidade=" + cidade + ", estado=" + estado + ", bairro=" + bairro + ", CEP=" + CEP + "]";
	}
}
