package entities;

import java.util.UUID ; 

public class Versement extends Operation {
	
	//attribute 
	String source ; 
	
	//constructor
	public Versement(UUID UUID , double montant , LocalDateTime date , String source) {
		super(UUID , montant , date);
		this.source = source ;
		
	}
	
	//getters 
	
	public String getSource() {
		return this.source ; 
	}
    
	//setters
	public void setSource(String source)
	this.source = source ;
}
