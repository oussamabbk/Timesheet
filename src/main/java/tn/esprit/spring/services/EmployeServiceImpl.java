package tn.esprit.spring.services;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;


@Service
public class EmployeServiceImpl implements IEmployeService {
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;

	public int ajouterEmploye(Employe employe) {
		
		employeRepository.save(employe);
		l.info("Employe ajouter avec sucess");
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		l.info("modifier employe email");
		Employe e = new Employe("", "", "", true, null);
		Employe employe = employeRepository.findById(employeId).orElse(e);
		
		
		employe.setEmail(email);
		employeRepository.save(employe);
		l.info("mettre a jour email avec sccees");

	}

	@Transactional	
	public void affecterEmployeADepartement(int employeId, int depId) {
		l.info("affecter employe a department start");
		Departement ddep =  new Departement("");
		Departement depManagedEntity = deptRepoistory.findById(depId).orElse(ddep);
		Employe e = new Employe("", "", "", true, null);
	
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(e);
		

		if(depManagedEntity.getEmployes() == null){
			l.info("department not find");
			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity);
			depManagedEntity.setEmployes(employes);
		}else{
			depManagedEntity.getEmployes().add(employeManagedEntity);
			l.info("employe affecter avec succes");


		}

	}
	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId)
	{	l.info("affecter employe a department start");

		if(deptRepoistory.findById(depId).isPresent()) {
			Departement ddep =  new Departement("");
			Departement dep = deptRepoistory.findById(depId).orElse(ddep);
			
			int employeNb = dep.getEmployes().size();
			for(int index = 0; index < employeNb; index++){
				if(dep.getEmployes().get(index).getId() == employeId){
					dep.getEmployes().remove(index);
					l.info("employe deja a le department");
					break;//a revoir
				}
			}
			
		}
		l.info("employe affecter avec succest");
		
		

		
	}

	

	public void affecterContratAEmploye(int contratId, int employeId) {
		l.info("affecter contrat a employe start");
		Contrat c = new Contrat(null, null, 0);
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(c);
		Employe e = new Employe("", "", "", true, null);
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(e);
		
		
		contratManagedEntity.setEmploye(employeManagedEntity);
		contratRepoistory.save(contratManagedEntity);
		l.info("employe affecter avec succes");
		
	}

	public String getEmployePrenomById(int employeId) {
		l.info("get employe  start");
		Employe e = new Employe("", "", "", true, null);
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(e);
		l.info("name of the employe");
		return employeManagedEntity.getPrenom();
	}
	public void deleteEmployeById(int employeId)
	{
		l.info("delete employe with id start");
		Employe e = new Employe("", "", "", true, null);
		Employe employe = employeRepository.findById(employeId).orElse(e);
		

		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);
		}
	
		employeRepository.delete(employe);
		l.info("employe delted avec succes");
	}

	

	public int getNombreEmployeJPQL() {
		l.info("conte number of emplyees start");
		
		return employeRepository.countemp();
	}
	
	public List<String> getAllEmployeNamesJPQL() {
		l.info("get all emplyees names star");
		l.info(employeRepository.employeNames());
		l.info("get all emplyees names end avec succes");
		return employeRepository.employeNames();

	}
	
	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		l.info(employeRepository.getAllEmployeByEntreprisec(entreprise));
		l.info("get all emplyees par rntrepriss end avec succes");
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}
	
	
	public float getSalaireByEmployeIdJPQL(int employeId) {
		try {
			l.info(employeRepository.getSalaireByEmployeIdJPQL(employeId));
			return employeRepository.getSalaireByEmployeIdJPQL(employeId);
			}
			catch(Exception e) {
				l.info("exception erreur");
				return 0;
				
			}
		
		
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		return employeRepository.getSalaireMoyenByDepartementId(departementId);
	}
	
	

	public List<Employe> getAllEmployes() {
				return (List<Employe>) employeRepository.findAll();
	}

	

}
