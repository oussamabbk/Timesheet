package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.entities.Entreprise;
//import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);
	

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	//@Autowired
	//DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		
		try {
			entrepriseRepoistory.save(entreprise);
			l.info("entreprise ajoutée:  "+ entreprise);

			l.debug("Je vais lancer la divsion.");

			}
			catch (Exception e) { l.error("Erreur dans ajouterEntreprise() : " + e); 
			}
		
		return entreprise.getId();
	}
	
	
	
	public Entreprise ajouterEntreprise2(Entreprise entreprise) {
		
		try {
		l.info("Dans la  methode ajouterEntreprise()");
		l.debug("Je vais lancer l'ajout d'une nouvelle entreprise .");
		entrepriseRepoistory.save(entreprise);
		l.debug("Je viens de finir l'ajout .");
		l.info("Out ajouterEntreprise() without errors avec.");
		}
		catch (Exception e) 
		{ 
		l.error("Erreur dans ajouterEntreprise() : " + e); }
		l.info("fin methode ajouterEntreprise() .");
		return entreprise;
		}

	
//	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
//		//Le bout Master de cette relation N:1 est departement  
//				//donc il faut rajouter l'entreprise a departement 
//				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
//				//Rappel : la classe qui contient mappedBy represente le bout Slave
//				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
//				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
//				Departement depManagedEntity = deptRepoistory.findById(depId).get();
//				
//				depManagedEntity.setEntreprise(entrepriseManagedEntity);
//				deptRepoistory.save(depManagedEntity);
//		
//	}
	
//	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
//		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
//		List<String> depNames = new ArrayList<>();
//		for(Departement dep : entrepriseManagedEntity.getDepartements()){
//			depNames.add(dep.getName());
//		}
//		
//		return depNames;
//	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		try {
			l.info("Dans la  methode deleteEntrepriseById()");
			l.debug("Je vais lancer la suppression d'une entreprise .");
			Entreprise ent = new Entreprise(null, null);
			entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).orElse(ent));
			l.debug("Je viens de finir la supp .");
			l.info("Out deleteEntrepriseById() without errors avec.");
			}
			catch (Exception e) 
			{ 
			l.error("Erreur dans deleteEntrepriseById() : " + e); }
			l.info("fin methode deleteEntrepriseById() .");
			
	}
	
	@Transactional
	public void deleteAll() {
		try {
			l.info("Dans la  methode deleteAll()");
			l.debug("Je vais lancer la suppression de toutes les entreprises .");
			entrepriseRepoistory.deleteAll();
			l.debug("Je viens de finir la supp .");
			l.info("Out deleteAll() without errors avec.");
			}
			catch (Exception e) 
			{ 
			l.error("Erreur dans deleteAll() : " + e); }
			l.info("fin methode deleteAll() .");
			
	}




	public Entreprise getEntrepriseById(int entrepriseId) {
		Entreprise ent = new Entreprise(null, null);
		return entrepriseRepoistory.findById(entrepriseId).orElse(ent);	
	}
	
	public List<Entreprise> getAll() {
		return (List<Entreprise>) entrepriseRepoistory.findAll();	
	}

}
