package tn.esprit.spring.services;

import java.util.Date;

import tn.esprit.spring.entities.Timesheet;



public interface ITimesheetService {
	
	
	
	public void ajouterTimesheet(Date dateDebut, Date dateFin);
	public void validerTimesheet(Date dateDebut, Date dateFin, int validateurId);
	public void ajouterTimesheet2(Timesheet timesheet);

}
