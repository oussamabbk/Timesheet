package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;

public interface TimesheetRepository extends CrudRepository<Timesheet, Integer> {

	
	
	
	


	  public Timesheet findBytimesheetPK(TimesheetPK timesheetPK);
}
