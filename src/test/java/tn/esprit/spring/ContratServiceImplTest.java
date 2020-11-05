package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {

	@Autowired
	IEmployeService iemployeservice;

	@Autowired
	IContratService contratservice;

	@Test
	public void testAjoutContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-11-05");

		Contrat c = new Contrat(d, "CDI", 1500);
		contratservice.ajouterContrat(c);
	}
	
//	@Test
//	 public void testdeleteAllContrat() throws ParseException {
//		contratservice.deleteAllContratJPQL();
//		List<Contrat> listentreprises=contratservice.getAll();
//			assertEquals(0,listentreprises.size());
//		}
	
//	@Test
//	
//	  public void deleteContratById() throws ParseException {
//		contratservice.deleteContratById(1);
//					}
}
