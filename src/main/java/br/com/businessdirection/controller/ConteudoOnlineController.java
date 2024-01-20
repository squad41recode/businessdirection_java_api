package br.com.businessdirection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.businessdirection.model.ConteudoOnline;
import br.com.businessdirection.repository.ConteudoOnlineRepository;
import br.com.businessdirection.repository.ModalidadeMentoriaRepository;

@Controller
@RequestMapping("/conteudos-online")
public class ConteudoOnlineController {

	@Autowired
	private ConteudoOnlineRepository conteudoOnlineRepository;

	@Autowired
	private ModalidadeMentoriaRepository modalidadeMonitoriaRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("crudConteudoOnline/index");
		modelAndView.addObject("ConteudosOnline", conteudoOnlineRepository.findAll());

		return modelAndView;
	}

	// TERMINAR TODOS OS RELACIOMENTOS DA CLASSE EMPREENDEDOR
	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudConteudoOnline/detalhes");
		modelAndView.addObject("ConteudoOnline", conteudoOnlineRepository.getReferenceById(id));

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("crudConteudoOnline/formulario");
		modelAndView.addObject("conteudoOnline", new ConteudoOnline());
		modelAndView.addObject("modalidades", modalidadeMonitoriaRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudConteudoOnline/formulario");
		modelAndView.addObject("conteudoOnline", conteudoOnlineRepository.getReferenceById(id));

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/editar/{id}" })
	public String salvar(ConteudoOnline conteudoOnline) {
		conteudoOnlineRepository.save(conteudoOnline);

		return "redirect:/conteudos-online";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		conteudoOnlineRepository.deleteById(id);

		return "redirect:/conteudos-online";
	}
}
