package br.com.businessdirection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.businessdirection.enums.UF;
import br.com.businessdirection.model.Empreendedor;
import br.com.businessdirection.repository.EmpreendedorRepository;

@Controller
@RequestMapping("/empreendedores")
public class EmpreendedorController {

	@Autowired
	private EmpreendedorRepository empreendedorRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("crudEmpreendedor/index");
		modelAndView.addObject("Empreendedores", empreendedorRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudEmpreendedor/detalhes");
		modelAndView.addObject("empreendedor", empreendedorRepository.getReferenceById(id));

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("crudEmpreendedor/formulario");
		modelAndView.addObject("empreendedor", new Empreendedor());
		modelAndView.addObject("estados", UF.values());

		return modelAndView;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudEmpreendedor/formulario");
		modelAndView.addObject("empreendedor", empreendedorRepository.getReferenceById(id));
		modelAndView.addObject("estados", UF.values());

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/editar/{id}" })
	public String salvar(Empreendedor empreendedor) {
		empreendedorRepository.save(empreendedor);

		return "redirect:/empreendedores";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		empreendedorRepository.deleteById(id);

		return "redirect:/empreendedores";
	}

}
