package service;

import entities.Compte;
import repository.CompteRepository;
import utilitaire.Validation;
import entities.CompteCourant;
import entities.CompteEpargne;
import entities.Retrait;
import entities.Versement;

public class CompteService {

	// attributes
	private CompteRepository compteRepository;

	// constructor
	public CompteService(CompteRepository compteRepository) {
		this.compteRepository = compteRepository;
	}

	// ==============fonction d'ajouter un nouveau compte============================================//
	
	public void addCompte(String type, String code, double montant, double decouverOrTaux) {
	    // Validation rapide
	    if (!Validation.validateCode(code) || !Validation.validateMontant(montant)) {
	        System.out.println("❌ Code de compte ou montant invalide.");
	        return;
	    }

	    // Vérifie si le compte existe déjà
	    if (compteRepository.exist(code)) {
	        System.out.println("⚠️ Un compte avec ce code existe déjà.");
	        return;
	    }

	    // Crée le compte selon le type
	    Compte compte;
	    if (type.equalsIgnoreCase("courant")) {
	        compte = new CompteCourant(code, montant, decouverOrTaux);
	    } else if (type.equalsIgnoreCase("epargne")) {
	        compte = new CompteEpargne(code, montant, decouverOrTaux);
	    } else {
	        System.out.println("⚠️ Type de compte inconnu.");
	        return;
	    }

	    // Sauvegarde du compte
	    compteRepository.save(compte);
	    System.out.println("✅ Compte créé avec succès !");
	}
	
	=============================================================================================

	
	//=================

}
