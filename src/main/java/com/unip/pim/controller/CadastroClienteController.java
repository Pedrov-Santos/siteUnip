package com.unip.pim.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
	
	@RequestMapping("/cadastro")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject(new CadastroCliente());
		return mv;
	}
		
	@RequestMapping(value =  "/cadastro" , method =  RequestMethod.POST )
	public String cadastro(@Validated CadastroCliente novoCliente, Errors errors , RedirectAttributes attributes) {	
			
		if (errors.hasErrors()) {
			return "CadastroCliente";
		}

		
		if (cadastroClienteService.idade(novoCliente.getDataNascimento()) < 18) {
			errors.rejectValue("dataNascimento", null, "Somente maiores de idade podem se cadastrar");
			return "CadastroCliente";
		}
		
		try {		
			cadastroClienteRepository.save(novoCliente);
			attributes.addFlashAttribute("mensagem", "Cliente salvo");
			return "redirect:/cadastro";
			
		} catch (Exception  e) {
			errors.rejectValue("dataNascimento", null, "Formato de DATA inválido.");
			
			return "CadastroCliente";
		}
	}
	
	@ModelAttribute("todosEstados")
	public List<StatusEstado> todosGeneros(){
		return Arrays.asList(StatusEstado.values());
	}
}
