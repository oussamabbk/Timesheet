package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class ContartServiceImpl implements IContratService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	ContratRepository contratRepoistory;

	public int ajouterContrat(Contrat contrat) {
		contratRepoistory.save(contrat);
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat c = new Contrat(null, null, 0);
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(c);
		Employe e = new Employe("", "", "", true, null);
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(e);

		contratManagedEntity.setEmploye(employeManagedEntity);
		contratRepoistory.save(contratManagedEntity);

	}

	public void deleteContratById(int contratId) {
		Contrat c = new Contrat(null, null, 0);
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(c);
		contratRepoistory.delete(contratManagedEntity);

	}

	public void deleteAllContratJPQL() {
		employeRepository.deleteAllContratJPQL();
	}
}
