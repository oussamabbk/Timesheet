package tn.esprit.spring;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceImplTest {

	
	@Autowired
	ITimesheetService TS;
	
	
	@Test
	 public void testAjoutTimesheet() throws ParseException {
		Date d1 = new Date();
		TimesheetPK timesheetPK =new TimesheetPK(d1,d1);
		Timesheet timesheet  = new Timesheet(false, timesheetPK );
		
		
		TS.ajouterTimesheet2(timesheet);
		//assertEquals(entreprise.getId(),entrepriseAdded);
		}
}
