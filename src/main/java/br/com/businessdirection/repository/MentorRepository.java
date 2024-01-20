package br.com.businessdirection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.businessdirection.model.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long> {

	@EntityGraph(attributePaths = { "mentoriasDisponiveis" })
	List<Mentor> findAll();
}
