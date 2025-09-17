package entities;

public class CompteCourant extends Compte{
	
	//attribute
	private double decouvert ;
	
	
   //constructor
	public CompteCourant(String code, double solde , double decouvert ) {
		super(code, solde);
	    this.decouvert = decouvert ;
	}

	//getters
	public double getDecouvert() {
		return this.decouvert ; 
	}
	
	//setters
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert ; 
	}
}
