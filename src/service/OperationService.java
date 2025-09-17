package service;

import entities.Compte;
import entities.CompteCourant;
import entities.CompteEpargne;
import entities.Operation;
import entities.Retrait;
import entities.Versement;
import repository.CompteRepository;
import utilitaire.Validation;

public class OperationService {

	private CompteRepository compteRepository;

	public OperationService(CompteRepository compteRepository) {
		this.compteRepository = compteRepository;
	}

// ===================fonction pour effectuer un retrait=========================================
	public boolean retrait(String code, double montant) {
		Compte compte = compteRepository.findByCode(code);

		if (compte == null) {
			System.out.println("⚠️ Compte introuvable");
			return false;
		}

		if (montant <= 0) {
			return false;
		}

		if (compte instanceof CompteCourant) {
			CompteCourant cc = (CompteCourant) compte;
			if (cc.getSolde() - montant >= -cc.getDecouvert()) {
				cc.setSolde(cc.getSolde() - montant);
				cc.getListOperation().add(new Retrait(montant, "ATM"));
				System.out.println(" ✅ retrait effectuer par succés");
				return true;
			} else {
				System.out.println("⚠️ Dépassement du découvert autorisé");
				return false;
			}
		} else if (compte instanceof CompteEpargne) {
			CompteEpargne ce = (CompteEpargne) compte;
			if (ce.getSolde() >= montant) {
				ce.setSolde(ce.getSolde() - montant);
				ce.getListOperation().add(new Retrait(montant, "ATM"));
				System.out.println(" ✅ retrait effectuer par succés");
				return true;
			} else {
				System.out.println("⚠️ Solde insuffisant");
				return false;
			}

		}
		return false;
	}
// ===================================================================================================================

// =================================fonction de virsement======================================================
	public void virsement(String code, double montant, String source) {

		if (montant <= 0) {
			System.out.println("le montant doit etre plus de 0 ");
			return;
		}

		Compte compte = compteRepository.findByCode(code);
		if (compte == null) {
			System.out.println("le compte n'existent pas");
			return;
		}

		compte.setSolde(compte.getSolde() + montant);
		compte.getListOperation().add(new Versement(montant, source));

		System.out.println("✅ Versement de " + montant + " € effectué sur le compte " + code);

	}

//===============================================================================================================

//==========================fonction de virement================================
	public void virement(String codeSource, String codeCible, double montant) {
		if (!Validation.validateMontant(montant)) {
			System.out.println("le montant doit etre plus de 0 ");
			return;
		}

		Compte compteSource = compteRepository.findByCode(codeSource);
		Compte compteCible = compteRepository.findByCode(codeCible);

		if (compteSource == null) {
			System.out.println("❌ Compte source introuvable : " + codeSource);
			return;
		}

		if (compteCible == null) {
			System.out.println("❌ Compte cible introuvable : " + codeCible);
			return;
		}

		// Retrait sur le compte source
		boolean retrait = retrait(codeSource, montant);
		if (!retrait) {
			System.out.println("❌ Virement impossible : solde insuffisant ou découvert dépassé.");
			return;
		}

		// Versement sur le compte cible
		compteCible.setSolde(compteCible.getSolde() + montant);
		Versement versement = new Versement(montant, "Virement reçu de " + codeSource);
		compteCible.getListOperation().add(versement);

		System.out.println("✅ Virement de " + montant + " € effectué de " + codeSource + " vers " + codeCible);
	}

	public void afficherOperations(String code) {
		Compte compte = compteRepository.findByCode(code);

		if (compte == null) {
			System.out.println("⚠️ Compte introuvable !");
			return;
		}

		if (compte.getListOperation().isEmpty()) {
			System.out.println("📭 Aucune opération trouvée pour le compte " + code);
			return;
		}

		System.out.println("\n📒 Historique des opérations du compte " + code + " :");

		for (Operation op : compte.getListOperation()) {
			System.out.println("-------------------------------------------------");
			System.out.println("UUID : " + op.getUUID());
			System.out.println("Date   : " + op.getDate());
			System.out.println("Montant: " + op.getMontant());

			if (op instanceof Versement) {
				System.out.println("Type   : Versement");
				System.out.println("Source : " + ((Versement) op).getSource());
			} else if (op instanceof Retrait) {
				System.out.println("Type   : Retrait");
				System.out.println("Destination : " + ((Retrait) op).getDestination());
			}
		}
	}
	
	

}