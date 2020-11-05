package tn.esprit.spring.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class ContartServiceImpl implements IContratService {

	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	ContratRepository contratRepoistory;

	public int ajouterContrat(Contrat contrat) {
		try {
			l.info("Dans la  methode ajouterEntreprise()");
			l.debug("Je vais lancer l'ajout d'une nouvelle entreprise .");
			contratRepoistory.save(contrat);
		} catch (Exception e) {
			l.error("Erreur dans ajouterEntreprise() : " + e);
		}
		l.info("fin methode ajouterEntreprise() .");
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		l.info("commancer l'affectation d'un contrat à un employe ");
		Contrat c = new Contrat(null, null, 0);
		l.info("finding contrat ");
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(c);
		l.info("contrat trouvé ");
		l.info("finding employe ");
		Employe e = new Employe("", "", "", true, null);
		l.info("employe trouvé ");
		l.info("affectation contratemploye ");
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(e);

		contratManagedEntity.setEmploye(employeManagedEntity);
		contratRepoistory.save(contratManagedEntity);
		l.info("contrat affécté ");

	}

	public void deleteContratById(int contratId) {
		Contrat c = new Contrat(null, null, 0);
		l.info("in  retrieveUContrat id = " + contratId);
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(c);
		contratRepoistory.delete(contratManagedEntity);
		l.info("contrat deleted ");

	}

	public void deleteAllContratJPQL() {
		l.info("débuter la supression de tous les contarts ");
		employeRepository.deleteAllContratJPQL();
		l.info("suppression terminé de tous les contarts ");
	}
}
