package entities;

public class CompteEpargne extends Compte{
	
	//attributes
	
	private int tauxInteret ; 
	
	//constructor 
	public CompteEpargne(String code , double solde , int tauxInteret ) {
		super(code , solde);
		this.tauxInteret = tauxInteret ;
	}

}
