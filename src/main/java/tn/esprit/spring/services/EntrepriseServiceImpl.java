package tn.esprit.spring.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;


@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	
	@Autowired
	DepartementRepository deptRepoistory;
	
	

	
	
	

	

	@Transactional
	public void deleteDepartementById(int depId) {
		Departement dep = new Departement("");
		deptRepoistory.delete(deptRepoistory.findById(depId).orElse(dep));	
	}









	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		
		return 0;
	}









	@Override
	public int ajouterDepartement(Departement dep) {
		
		return 0;
	}









	









	








	









	@Override
	public Entreprise getEntrepriseById(int entrepriseId) {

		return null;
	}


	

}
