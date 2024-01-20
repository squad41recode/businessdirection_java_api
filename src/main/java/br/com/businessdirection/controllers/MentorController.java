package br.com.businessdirection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.businessdirection.models.Mentor;
import br.com.businessdirection.repositories.MentorRepository;

@Controller
@RequestMapping("/mentores")
public class MentorController {

	@Autowired
	private MentorRepository mentorRepository;
	
	

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("crudMentor/index");
		modelAndView.addObject("Mentores", mentorRepository.findAll());

		return modelAndView;
	}

	//TERMINAR TODOS OS RELACIOMENTOS DA CLASSE MENTOR
	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudMentor/detalhes");
		modelAndView.addObject("mentor", mentorRepository.getReferenceById(id));

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("crudMentor/formulario");
		modelAndView.addObject("mentor", new Mentor());

		return modelAndView;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("crudMentor/formulario");
		modelAndView.addObject("mentor", mentorRepository.getReferenceById(id));

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/editar/{id}" })
	public String salvar(Mentor mentor) {
		mentor.setMentoriasDisponiveis(null);
		mentorRepository.save(mentor);

		return "redirect:/mentores";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		mentorRepository.deleteById(id);

		return "redirect:/mentores";
	}

}
