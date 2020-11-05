package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.ITimesheetService;

@RestController
public class RestControllerContrat {

//	@Autowired
//	IEmployeService iemployeservice;
//	
//	@Autowired
//	ITimesheetService itimesheetservice;
//	@Autowired
//	IContratService contratservice;

	// http://localhost:8081/SpringMVC/servlet/ajouterContrat
	// {"reference":6,"dateDebut":"2020-03-01","salaire":2000,"typeContrat":"CDD"}
//	@PostMapping("/ajouterContrat")
//	@ResponseBody
//	public int ajouterContrat(@RequestBody Contrat contrat) {
//		contratservice.ajouterContrat(contrat);
//		return contrat.getReference();
//	}

	// http://localhost:8081/SpringMVC/servlet/affecterContratAEmploye/6/1
//	@PutMapping(value = "/affecterContratAEmploye/{idcontrat}/{idemp}")
//	public void affecterContratAEmploye(@PathVariable("idcontrat") int contratId,
//			@PathVariable("idemp") int employeId) {
//		contratservice.affecterContratAEmploye(contratId, employeId);
//	}

//	// URL : http://localhost:8081/SpringMVC/servlet/deleteContratById/2
//	@DeleteMapping("/deleteContratById/{idcontrat}")
//	@ResponseBody
//	public void deleteContratById(@PathVariable("idcontrat") int contratId) {
//		contratservice.deleteContratById(contratId);
//	}

	// URL : http://localhost:8081/SpringMVC/servlet/deleteAllContratJPQL
//	@DeleteMapping("/deleteAllContratJPQL")
//	@ResponseBody
//	public void deleteAllContratJPQL() {
//		contratservice.deleteAllContratJPQL();
//
//	}
}
