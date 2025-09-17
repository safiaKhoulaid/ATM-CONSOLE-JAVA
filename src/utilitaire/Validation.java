package utilitaire;

public class Validation {
	
	public static boolean validateCode(String code) {
		 return code.matches("CPT-\\d{5}");
	}
	
	public static boolean validateMontant(double montant) {
		return montant > 0 ; 
	}

	

}
