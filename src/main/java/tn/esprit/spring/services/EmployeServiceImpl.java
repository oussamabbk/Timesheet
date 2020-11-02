package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	ContratRepository contratRepoistory;
	/*
	 * @Autowired DepartementRepository deptRepoistory;
	 * 
	 * @Autowired TimesheetRepository timesheetRepository;
	 */

	public int ajouterEmploye(Employe employe) {
		employeRepository.save(employe);
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		Employe e = new Employe("", "", "", true, null);
		Employe employe = employeRepository.findById(employeId).orElse(e);
		employe.setEmail(email);
		employeRepository.save(employe);

	}

	/*
	 * @Transactional public void affecterEmployeADepartement(int employeId, int
	 * depId) { Departement ddep = new Departement(""); Departement
	 * depManagedEntity = deptRepoistory.findById(depId).orElse(ddep); Employe e
	 * = new Employe("", "", "", true, null); Employe employeManagedEntity =
	 * employeRepository.findById(employeId).orElse(e);
	 * 
	 * if(depManagedEntity.getEmployes() == null){
	 * 
	 * List<Employe> employes = new ArrayList<>();
	 * employes.add(employeManagedEntity);
	 * depManagedEntity.setEmployes(employes); }else{
	 * 
	 * depManagedEntity.getEmployes().add(employeManagedEntity);
	 * 
	 * }
	 * 
	 * }
	 */
	/*
	 * @Transactional public void desaffecterEmployeDuDepartement(int employeId,
	 * int depId) { if(deptRepoistory.findById(depId).isPresent()) { Departement
	 * ddep = new Departement(""); Departement dep =
	 * deptRepoistory.findById(depId).orElse(ddep); int employeNb =
	 * dep.getEmployes().size(); for(int index = 0; index < employeNb; index++){
	 * if(dep.getEmployes().get(index).getId() == employeId){
	 * dep.getEmployes().remove(index); break;//a revoir } } }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

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

	public String getEmployePrenomById(int employeId) {
		Employe e = new Employe("", "", "", true, null);
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(e);
		return employeManagedEntity.getPrenom();
	}
	/*
	 * public void deleteEmployeById(int employeId) { Employe e = new
	 * Employe("", "", "", true, null); Employe employe =
	 * employeRepository.findById(employeId).orElse(e);
	 * 
	 * //Desaffecter l'employe de tous les departements //c'est le bout master
	 * qui permet de mettre a jour //la table d'association for(Departement dep
	 * : employe.getDepartements()){ dep.getEmployes().remove(employe); }
	 * 
	 * employeRepository.delete(employe); }
	 */

	public void deleteContratById(int contratId) {
		Contrat c = new Contrat(null, null, 0);
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(c);
		contratRepoistory.delete(contratManagedEntity);

	}

	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNames();

	}

	/*
	 * public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
	 * return employeRepository.getAllEmployeByEntreprisec(entreprise); }
	 */

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}

	public void deleteAllContratJPQL() {
		 employeRepository.deleteAllContratJPQL();
	}

	/*
	 * public float getSalaireByEmployeIdJPQL(int employeId) { return
	 * employeRepository.getSalaireByEmployeIdJPQL(employeId); }
	 */

	/*
	 * public Double getSalaireMoyenByDepartementId(int departementId) { return
	 * employeRepository.getSalaireMoyenByDepartementId(departementId); }
	 */

	/*
	 * public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe,
	 * Mission mission, Date dateDebut, Date dateFin) { return
	 * timesheetRepository.getTimesheetsByMissionAndDate(employe, mission,
	 * dateDebut, dateFin); }
	 */

	public List<Employe> getAllEmployes() {
		return (List<Employe>) employeRepository.findAll();
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {

	}

	@Override
	public void desaffecterEmployeDuDepartement(int employeId, int depId) {

	}

	@Override
	public void deleteEmployeById(int employeId) {

	}

	@Override
	public float getSalaireByEmployeIdJPQL(int employeId) {

		return 0;
	}

	@Override
	public Double getSalaireMoyenByDepartementId(int departementId) {

		return null;
	}

}
