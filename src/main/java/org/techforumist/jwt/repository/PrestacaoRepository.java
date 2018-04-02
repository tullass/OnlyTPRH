package org.techforumist.jwt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.Prestacao;

@Repository
public interface PrestacaoRepository extends CrudRepository<Prestacao, Long> {

	public List<Prestacao> findAllByEstado(Boolean estado);

}
