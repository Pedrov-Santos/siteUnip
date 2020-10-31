package com.unip.pim.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unip.pim.model.CadastroCliente;
import com.unip.pim.model.StatusEstado;
import com.unip.pim.repository.CadastroClienteRepository;
import com.unip.pim.service.CadastroClienteService;

@Controller
public class CadastroClienteController {

	@Autowired
	private CadastroClienteService cadastroClienteService;
	
	@Autowired
	private CadastroClienteRepository cadastroClienteRepository;
		
	@RequestMapping(value = "/cadastro" ,method = { RequestMethod.GET, RequestMethod.POST })
	public String cadastro(@Validated CadastroCliente novoCliente, Errors errors , RedirectAttributes attributes) {	
		
		if (errors.hasErrors()) {
			return "CadastroCliente";
		}
		
		if (cadastroClienteService.idade(novoCliente.getDataNascimento()) < 18) {
			return "MenorDeIdade";
		}
		

		cadastroClienteRepository.save(novoCliente);
		attributes.addFlashAttribute("mensagem", "Cliente salvo");
	    
	 return "redirect:/cadastro";
	}
	
	@ModelAttribute("todosEstados")
	public List<StatusEstado> todosGeneros(){
		return Arrays.asList(StatusEstado.values());
	}
}
