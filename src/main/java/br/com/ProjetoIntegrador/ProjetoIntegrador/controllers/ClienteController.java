package br.com.ProjetoIntegrador.ProjetoIntegrador.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ProjetoIntegrador.ProjetoIntegrador.models.Cliente;
import br.com.ProjetoIntegrador.ProjetoIntegrador.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository er;
	
	// GET que chama o FORM que cadastra cliente
	@RequestMapping("/cadastrarCliente")
	public String form() {
		return "contato/form-contato";
	}
	
	// POST que cadastra o cliente
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {

			if (result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Verifique os campos...");
				return "redirect:/cadastrarCliente";
			} 

			er.save(cliente);
			attributes.addFlashAttribute("mensagem", "Cliente cadastrada com sucesso!");
			return "redirect:/cadastrarCliente";
		}
	
	// GET que chama a página Sobre
		@RequestMapping("/Sobre")
		public String sobre() {
			return "/sobre";
		}
		
	// GET que chama a página de Projetos
		@RequestMapping("/Projetos")
		public String projetos() {
			return "/projetos";
		}
		
}
