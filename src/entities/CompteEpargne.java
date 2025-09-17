package entities;

public class CompteEpargne extends Compte{
	
	//attributes
	
	private double tauxInteret ; 
	
	//constructor 
	public CompteEpargne(String code , double solde , double tauxInteret ) {
		super(code , solde);
		this.tauxInteret = tauxInteret ;
	}
	
	//getters
	public double getTauxInteret() {
		return this.tauxInteret ; 
	}
	
	//setters
	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret ; 
	}

}
