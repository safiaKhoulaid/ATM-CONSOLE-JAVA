package entities;

import java.util.UUID ; 
import java.time.LocalDateTime ; 

public class Retrait extends Operation {

	String destination ;
	
	public Retrait(double montant , String destination ) {
		super(montant );
		this.destination = destination ; 
		
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
