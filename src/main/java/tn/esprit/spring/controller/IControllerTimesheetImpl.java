package tn.esprit.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.services.ITimesheetService;

@Controller
public class IControllerTimesheetImpl {

	
	@Autowired
	ITimesheetService itimesheetservice;

	

	
	
	public void ajouterTimesheet(Date dateDebut, Date dateFin) {
		itimesheetservice.ajouterTimesheet(dateDebut, dateFin);

	}

	
	public void validerTimesheet(Date dateDebut, Date dateFin, int validateurId) {
		itimesheetservice.validerTimesheet( dateDebut, dateFin, validateurId);

	}
	
}
