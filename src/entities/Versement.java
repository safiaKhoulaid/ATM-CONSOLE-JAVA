package entities;

import java.time.LocalDateTime;
import java.util.UUID ; 

public class Versement extends Operation {
	
	//attribute 
	String source ; 
	
	//constructor
	public Versement( double montant ,  String source) {
		super(montant);
		this.source = source ;
		
	}
	
	//getters 
	
	public String getSource() {
		return this.source ; 
	}
    
	//setters
	public void setSource(String source) {
	this.source = source ;}
}
