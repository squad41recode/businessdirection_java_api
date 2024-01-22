package br.com.businessdirection.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.businessdirection.models.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long> {

	@Override
	@EntityGraph(attributePaths = { "mentoriasDisponiveis" })
	List<Mentor> findAll();
}
