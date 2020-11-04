
	import static org.junit.Assert.assertEquals;

	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;



	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class DepartementTEST {
	@Autowired
	IDepartementService depser;

	@Test
	public void testAddDepartment() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Departement dep = new Departement("Dep Informatique");
		Departement depAdded = depser.addDepartement(dep);
		assertEquals(dep.getName(), depAdded.getName());
	}
	/*@Test
	public void testModifyDepartement() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Departement dep = new Departement("Dep1 Informatique");
		Departement depModified = depser.UpdateDepartement(dep);
		assertEquals(dep.getName(), depModified.getName());
	}*/

	/*@Test
	public void testRetrieveDepartement() {
		Departement DepartementRetrieved = depser.retreiveDepartement("1");
		assertEquals(1L, DepartementRetrieved.getId());
	}*/
	/*@Test
	public void testRetrieveAllDepartements() {
		List<Departement> listDepartments = depser.getAllDepartements(); 
		// if there are 5 users in DB : 
		assertEquals(19,listDepartments.size());
		
	}*/
	}

