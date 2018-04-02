package org.techforumist.jwt.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.jwt.domain.Areaa;
import org.techforumist.jwt.service.AreaaService;

@RestController
@RequestMapping("areaa")
public class AreaaController {

	@Autowired
	private AreaaService areaaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return areaaService.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Areaa areaa) {
		areaaService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updd(@RequestBody Areaa departamento) {
		areaaService.save(departamento);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping(path = "/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		areaaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
