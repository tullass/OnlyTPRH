package org.techforumist.jwt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.jwt.service.ContratoService;

@RestController
@RequestMapping("periodo")
public class PeriodoController {

	@Autowired
	private ContratoService personService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return personService.findAll();
	}

}
