package org.techforumist.jwt.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.jwt.domain.Consultor;
import org.techforumist.jwt.enums.Pronvicia;
import org.techforumist.jwt.service.DepartamentoService;
import org.techforumist.jwt.service.ConsultorService;
import org.techforumist.jwt.service.ProgramaService;

@RestController
@RequestMapping("consull")
public class ListController3 {

	@Autowired
	private ConsultorService personService;
	@Autowired
	private DepartamentoService deService;
	@Autowired
	private ProgramaService proService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return personService.findAllByActivo(true);
	}
	@RequestMapping(value = "/listarf", method = RequestMethod.GET)
	@ResponseBody
	public Object indexf() {
		return personService.findAllByActivo(false);
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Consultor> createUser(@RequestBody Consultor appUser) {
		return new ResponseEntity<Consultor>(personService.save(appUser), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/depar", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listAlld() {
		return new ResponseEntity<>(deService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/programaas", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listAlldp() {
		return new ResponseEntity<>(proService.findAll(), HttpStatus.OK);
	}

	@RequestMapping("/userrr/pronviciaa")
	public List<String> getPronvicia() {
		List<String> profiles = new ArrayList<>();
		for (Pronvicia profile : Pronvicia.values()) {
			profiles.add(profile.name());
		}
		return profiles;
	}

}
