package br.com.businessdirection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.businessdirection.models.MentorModalidade;
import br.com.businessdirection.repositories.MentorModalidadeRepository;
import br.com.businessdirection.repositories.MentorRepository;
import br.com.businessdirection.repositories.ModalidadeMentoriaRepository;

@Controller
@RequestMapping("/mentorias-disponiveis")
public class MentorModalidadeController {

	@Autowired
	private MentorModalidadeRepository mentorModalidadeRepository;

	@Autowired
	private MentorRepository mentorRepository;

	@Autowired
	private ModalidadeMentoriaRepository modalidadeMentoriaRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("crudMentorModalidade/index");
		modelAndView.addObject("MentorModalidades", mentorModalidadeRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudMentorModalidade/detalhes");
		modelAndView.addObject("mentorModalidade", mentorModalidadeRepository.findById(id));

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("crudMentorModalidade/formulario");
		modelAndView.addObject("mentorModalidade", new MentorModalidade());
		modelAndView.addObject("mentores", mentorRepository.findAll());
		modelAndView.addObject("modalidades", modalidadeMentoriaRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudMentorModalidade/formulario");
		modelAndView.addObject("mentorModalidade", mentorModalidadeRepository.getReferenceById(id));
		modelAndView.addObject("mentores", mentorRepository.findAll());
		modelAndView.addObject("modalidades", modalidadeMentoriaRepository.findAll());

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/editar/{id}" })
	public String salvar(MentorModalidade mentorModalidade) {
		mentorModalidade.setAtivo(true);
		mentorModalidadeRepository.save(mentorModalidade);

		return "redirect:/mentorias-disponiveis";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		mentorModalidadeRepository.deleteById(id);
		/*
		 * Optional<MentorModalidade> mentorModalidadeOptional =
		 * mentorModalidadeRepository.findById(id);
		 * mentorModalidadeOptional.ifPresent(mentorModalidade -> {
		 * mentorModalidade.setAtivo(false);
		 * mentorModalidadeRepository.save(mentorModalidade); });
		 */

		return "redirect:/mentorias-disponiveis";
	}
}
