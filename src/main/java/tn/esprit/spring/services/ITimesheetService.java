package tn.esprit.spring.services;

import java.util.Date;



public interface ITimesheetService {
	
	
	
	public void ajouterTimesheet(Date dateDebut, Date dateFin);
	public void validerTimesheet(Date dateDebut, Date dateFin, int validateurId);

}
