package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;

import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService {
	


	@Autowired
	TimesheetRepository timesheetRepository;
	
	
    

		
	

	public void ajouterTimesheet(Date dateDebut, Date dateFin) {
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
	
		
		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false); //par defaut non valide
		timesheetRepository.save(timesheet);
		
	}

	
	public void validerTimesheet(Date dateDebut, Date dateFin, int validateurId) {
		System.out.println("In valider Timesheet");
		
		//verifier s'il est un chef de departement (interet des enum)
		
			return;
		
		//verifier s'il est le chef de departement de la mission en question
	
		
		
		
//
		
		
		
		//Comment Lire une date de la base de données
		
	}

	
	

	
	

}
