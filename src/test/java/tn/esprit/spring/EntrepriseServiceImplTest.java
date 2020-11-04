package tn.esprit.spring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)

@SpringBootTest
public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService ES;
	
	private static final Logger l = Logger.getLogger(EntrepriseServiceImplTest.class);

	@Test
	 public void testAjoutEntreprise() throws ParseException {
		Entreprise entreprise=new Entreprise("test2","raisonSocial2");
		ES.ajouterEntreprise2(entreprise);
		//assertEquals(entreprise.getId(),entrepriseAdded);
		}
		
	
		//ES.ajouterEntreprise(new Entreprise("test1","raisonSocial"));}
//
//	
//	 	@Test
//	 public void testgetallEntreprise() throws ParseException {
//			List<Entreprise> listentreprises=ES.getAll();
//		//	assertEquals(5,listentreprises.size());
//		
//		}
//
//	 	
//	
	@Test

	 public void getEntrepriseById() throws ParseException {
		try{
	    Entreprise entrepriseretrieved=ES.getEntrepriseById(14);
	    assertThat(14, is(entrepriseretrieved.getId()));
		}catch(Exception e){
			
			l.info("entreprise id 14 not found");
		}
		}
		//Entreprise entrepriseretrieved= ES.getEntrepriseById(14);
		
//	@Test
//	 public void testdeleteAll() throws ParseException {
//	//	ES.deleteAll();
//		List<Entreprise> listentreprises=ES.getAll();
//	//		assertEquals(0,listentreprises.size());
//		}
//	
//	 @Test
//
//	  public void deleteEntrepriseById() throws ParseException {
//		//ES.deleteEntrepriseById(5);
//				}


//	@Test
//	 public void testAffecterDepAentreprise() throws ParseException {
//	ES.affecterDepartementAEntreprise(6,22);
//	}
 
//	@Test
//	 public void testgetAllDepartementsNamesByEntreprise() throws ParseException {
//		List<String> listeName=ES.getAllDepartementsNamesByEntreprise(20);
//		//assertEquals(5,listeName.size());
//		}

	
	
		
	
	

}
