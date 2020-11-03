package com.unip.pim.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;



@SuppressWarnings("deprecation")
@Entity
public class CadastroCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 10 , message = "Nome incorreto.")
	@Size(max = 75 , message =  "Nome excedeu o limíte de caracteres."
			+ "    Solução: Abreviar. ")
	@Pattern(regexp = "[a-zA-Záãâéêíîóôõú\s]+$" , message = "Nome Incorreto.")
	@NotBlank(message = "Nome Vaio ou em Branco.")
	private String nomeCliente;

	@NotBlank(message = "email obrigátorio")
	private String email;
	
	@NotBlank(message = "Confirmação do email obrigátorio")		
	private String emailConfirmacao;

	@NotBlank(message = "RG obrigátorio")
	private String rg;
	
	@CPF(message = "CPF inválido.")
	@NotBlank(message = "CPF obrigátorio")
	private String cpf;
	
	@NotBlank(message = "Celular obrigátorio")
	private String telefone;
	
	@Past(message = "A Data deve estar no passado.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@NotBlank(message = "CEP obrigátorio")
	private String cep;

	private StatusEstado estado;
	
	@NotBlank(message = "Cidade obrigátorio")
	@Pattern(regexp = "[a-zA-Záãâéêíîóôõú\s]+$" , message = "Cidade Incorreta.")
	private String cidade;
	
	@NotBlank(message = "Rua obrigátorio")
	private String rua;
	
	@NotBlank(message = "Numero da Casa obrigátorio")
	private String numeroCasa;
	
	@NotBlank(message = "Bairro obrigátorio")
	@Pattern(regexp = "[a-zA-Záãâéêíîóôõú\s]+$" , message = "Bairro Incorreto.")
	private String bairro;
	
	private String complemento;
	
	@NotBlank(message = "Senha obrigátorio")
	private String secret;
	
	@Size(max = 18 , min = 6 ,message = "A senha deve conter entre 6 e 18 caracteris")
	@NotBlank(message = "Confirmação de senha obrigátorio")
	private String secretConfirmacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailConfirmacao() {
		return emailConfirmacao;
	}

	public void setEmailConfirmacao(String emailConfirmacao) {
		this.emailConfirmacao = emailConfirmacao;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public StatusEstado getEstado() {
		return estado;
	}

	public void setEstado(StatusEstado estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getSecretConfirmacao() {
		return secretConfirmacao;
	}

	public void setSecretConfirmacao(String secretConfirmacao) {
		this.secretConfirmacao = secretConfirmacao;
	}


	
}
