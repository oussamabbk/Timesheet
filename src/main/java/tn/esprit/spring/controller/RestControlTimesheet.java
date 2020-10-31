package tn.esprit.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.ITimesheetService;

@RestController
public class RestControlTimesheet {

	
	@Autowired
	ITimesheetService itimesheetservice;
	
	

	// http://localhost:8081/SpringMVC/servlet/ajouterTimesheet
    //{"missionId":1,"employeId":2,"dateDebut":"2020-03-01","dateFin":"2021-03-01"}
	
	@PostMapping("/ajouterTimesheet/dated/datef")
	@ResponseBody
	public void ajouterTimesheet(@PathVariable("dated") Date dateDebut,@PathVariable("datef") Date dateFin) {
		itimesheetservice.ajouterTimesheet(dateDebut, dateFin);

	}

	// http://localhost:8081/SpringMVC/servlet/affecterMissionADepartement/4/4
	@PutMapping(value = "/validerTimesheet/{idmission}/{iddept}") 
	public void validerTimesheet(Date dateDebut, Date dateFin, int validateurId) {
		itimesheetservice.validerTimesheet(dateDebut, dateFin, validateurId);

	}
	
	
}
