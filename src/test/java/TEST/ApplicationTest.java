package TEST;




import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.TimesheetSpringBootCoreDataJpaMvcRest1Application;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

import tn.esprit.spring.services.IEmployeService;






@SpringBootTest(classes = TimesheetSpringBootCoreDataJpaMvcRest1Application.class)
@RunWith(SpringRunner.class)
public class ApplicationTest {
	
	@Autowired
	IEmployeService es ; 
	Integer ide;
	
	@Test
	public void contextLoads() {
		Employe employe = new Employe("oussama", "boubaker", "oooo", true,Role.ADMINISTRATEUR);
		ide=es.ajouterEmploye(employe);
		assertNotNull(ide);
		//es.deleteAllContratJPQL();
		es.mettreAjourEmailByEmployeId("oussama", 1);
		//es.deleteEmployeById(1);
		es.getNombreEmployeJPQL();
		es.getAllEmployeNamesJPQL();
		es.getSalaireByEmployeIdJPQL(1);
		
		
	}


}
 