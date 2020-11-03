package com.unip.pim.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unip.pim.model.CadastroCliente;
import com.unip.pim.repository.CadastroClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private CadastroClienteRepository cadastroClienteRepository;

	@SuppressWarnings("deprecation")
	public int idade(Date date) {
		Date hoje = new Date();

	    int idade = hoje.getYear() - date.getYear();

	    if((hoje.getMonth() < date.getMonth())
	            || (hoje.getMonth() == date.getMonth() && hoje.getDate() < date.getDate()))
	        idade--;

	    
		return idade;
		
	}

	public Object validarIgual(CadastroCliente novoCliente) {
		if(novoCliente.getSecret() == novoCliente.getSecretConfirmacao()) {
			
			String igual = "igual";
			return igual;
		}else {
			
			String diferente = "diferente";
			return diferente;
		}
		
	}

}
