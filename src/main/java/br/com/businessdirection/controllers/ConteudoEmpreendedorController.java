package br.com.businessdirection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.businessdirection.models.ConteudoEmpreendedor;
import br.com.businessdirection.models.ConteudoOnline;
import br.com.businessdirection.models.Empreendedor;
import br.com.businessdirection.repositories.ConteudoEmpreendedorRepository;
import br.com.businessdirection.repositories.ConteudoOnlineRepository;
import br.com.businessdirection.repositories.EmpreendedorRepository;

@Controller
@RequestMapping("/conteudo-estudado")
public class ConteudoEmpreendedorController {

	@Autowired
	private ConteudoOnlineRepository conteudoOnlineRepository;

	@Autowired
	private EmpreendedorRepository empreendedorRepository;

	@Autowired
	private ConteudoEmpreendedorRepository conteudoEmpreendedorRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("crudConteudoEmpreendedor/index");
		modelAndView.addObject("conteudosEmpreendedor", conteudoEmpreendedorRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudConteudoEmpreendedor/detalhes");
		modelAndView.addObject("conteudoEmpreendedor", conteudoEmpreendedorRepository.findById(id));

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("crudConteudoEmpreendedor/formulario");

		List<Empreendedor> empreendedores = empreendedorRepository.findAll();
		List<ConteudoOnline> conteudosOnline = conteudoOnlineRepository.findAll();

		modelAndView.addObject("conteudosOnline", conteudosOnline);
		modelAndView.addObject("empreendedores", empreendedores);
		modelAndView.addObject("conteudoEmpreendedor", new ConteudoEmpreendedor());

		return modelAndView;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudConteudoEmpreendedor/formulario");

		List<Empreendedor> empreendedores = empreendedorRepository.findAll();
		List<ConteudoOnline> conteudosOnline = conteudoOnlineRepository.findAll();

		modelAndView.addObject("conteudosOnline", conteudosOnline);
		modelAndView.addObject("empreendedores", empreendedores);
		modelAndView.addObject("conteudoEmpreendedor", conteudoEmpreendedorRepository.getReferenceById(id));

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/editar/{id}" })
	public String salvar(ConteudoEmpreendedor conteudoEmpreendedor) {
		conteudoEmpreendedor.setAtivo(true);
		conteudoEmpreendedorRepository.save(conteudoEmpreendedor);

		return "redirect:/conteudo-estudado";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		conteudoEmpreendedorRepository.deleteById(id);

		return "redirect:/conteudo-estudado";
	}
}
