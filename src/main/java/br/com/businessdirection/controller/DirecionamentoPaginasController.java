package br.com.businessdirection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DirecionamentoPaginasController {

	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index.html");

		return modelAndView;
	}
	

	@GetMapping("/ferramentas")
	public ModelAndView ferramentas() {
		ModelAndView modelAndView = new ModelAndView("/pages/ferramentas.html");

		return modelAndView;
	}
	

	@GetMapping("/admin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("crudEmpreendedor/index");

		return modelAndView;
	}
	
	@GetMapping("/sobre")
	public ModelAndView sobre() {
		ModelAndView modelAndView = new ModelAndView("/pages/sobre.html");

		return modelAndView;
	}
	
	@GetMapping("/contato")
	public ModelAndView contato() {
		ModelAndView modelAndView = new ModelAndView("/pages/contato.html");

		return modelAndView;
	}
	
	@GetMapping("/entrar")
	public ModelAndView entrar() {
		ModelAndView modelAndView = new ModelAndView("/pages/entrar.html");

		return modelAndView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("/pages/cadastrar.html");

		return modelAndView;
	}
}
		
		
		
		
		
		
		
	

