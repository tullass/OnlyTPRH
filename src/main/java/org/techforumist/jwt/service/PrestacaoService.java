package org.techforumist.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.Prestacao;
import org.techforumist.jwt.repository.PrestacaoRepository;

@Service
public class PrestacaoService {

	@Autowired
	private PrestacaoRepository personRepository;

	public List<Prestacao> findAll() {
		return (List<Prestacao>) personRepository.findAll();
	}

	public List<Prestacao> findAllByActivo(boolean b) {
		return personRepository.findAllByEstado(true);
	}

	public Prestacao findById(Long id) {
		return personRepository.findOne(id);
	}

	public Prestacao save(Prestacao person) {
		return personRepository.save(person);
	}

	public void delete(Long id) {
		personRepository.delete(id);
		return;
	}

}
