package tn.esprit.spring.services;


import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	
	public int ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	
	
	
	public void deleteDepartementById(int depId);
	public Entreprise getEntrepriseById(int entrepriseId);
}
