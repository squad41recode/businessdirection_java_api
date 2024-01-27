package br.com.businessdirection.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.businessdirection.models.ModalidadeMentoria;

public interface ModalidadeMentoriaRepository extends JpaRepository<ModalidadeMentoria, Long> {

	@Query("SELECT mm FROM ModalidadeMentoria mm WHERE NOT EXISTS (SELECT co FROM ConteudoOnline co WHERE mm.id = co.modalidadeMentoria.id)")
	List<ModalidadeMentoria> listarModalidadesSemLigacaoComConteudos();
}
