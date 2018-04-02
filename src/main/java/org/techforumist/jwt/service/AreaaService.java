package org.techforumist.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.Areaa;
import org.techforumist.jwt.repository.AreaaRepository;

@Service
public class AreaaService {

	@Autowired
	private AreaaRepository areaaRepository;

	public Object findAll() {
		return areaaRepository.findAll();
	}

	public Areaa findById(Long id) {
		return areaaRepository.findOne(id);
	}

	public Areaa save(Areaa areaa) {
		return areaaRepository.save(areaa);
	}

	public void delete(Long id) {
		areaaRepository.delete(id);
		return;
	}

}
