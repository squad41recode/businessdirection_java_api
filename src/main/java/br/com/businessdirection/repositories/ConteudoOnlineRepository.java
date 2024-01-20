package br.com.businessdirection.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.businessdirection.models.ConteudoOnline;

public interface ConteudoOnlineRepository extends JpaRepository<ConteudoOnline, Long> {

	@EntityGraph(attributePaths = { "modalidadeMentoria" })
	List<ConteudoOnline> findAll();
}
