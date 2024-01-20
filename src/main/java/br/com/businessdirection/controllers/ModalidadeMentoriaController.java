package br.com.businessdirection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.businessdirection.models.ModalidadeMentoria;
import br.com.businessdirection.repositories.ModalidadeMentoriaRepository;

@Controller
@RequestMapping("/modalidades-mentorias")
public class ModalidadeMentoriaController {

	@Autowired
	private ModalidadeMentoriaRepository modalidadeMentoriaRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("crudModalidadeMentoria/index");
		modelAndView.addObject("modalidadesMentorias", modalidadeMentoriaRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudModalidadeMentoria/detalhes");
		modelAndView.addObject("modalidadeMentoria", modalidadeMentoriaRepository.getReferenceById(id));

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("crudModalidadeMentoria/formulario");
		modelAndView.addObject("modalidadeMentoria", new ModalidadeMentoria());

		return modelAndView;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudModalidadeMentoria/formulario");
		modelAndView.addObject("modalidadeMentoria", modalidadeMentoriaRepository.getReferenceById(id));

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/editar/{id}" })
	public String salvar(ModalidadeMentoria modalidadeMentoria) {
		modalidadeMentoriaRepository.save(modalidadeMentoria);

		return "redirect:/modalidades-mentorias";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		modalidadeMentoriaRepository.deleteById(id);

		return "redirect:/modalidades-mentorias";
	}
}
