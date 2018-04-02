package org.techforumist.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.Contrato;
import org.techforumist.jwt.repository.ContratoRepository;

@Service
public class ContratoService {

	@Autowired
	private ContratoRepository personRepository;

	public List<Contrato> findAll() {
		return (List<Contrato>) personRepository.findAll();
	}

	public List<Contrato> findAllByActivo(boolean b) {
		return personRepository.findAllByEstado(true);
	}

	public Contrato findById(Long id) {
		return personRepository.findOne(id);
	}

	public Contrato save(Contrato person) {
		return personRepository.save(person);
	}

	public void delete(Long id) {
		personRepository.delete(id);
		return;
	}
	
	

}
