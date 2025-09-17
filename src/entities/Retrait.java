package entities;

public class Retrait extends Operation {

	//attributes
	String destination ;
	
	//constructor
	public Retrait(double montant , String destination ) {
		super(montant );
		this.destination = destination ; 
		
	}

	//getter
	public String getDestination() {
		return destination;
	}

	//setter
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
