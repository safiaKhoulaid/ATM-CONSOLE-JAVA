package entities;

import java.time.LocalDateTime;
import java.util.UUID ; 

public abstract class Operation {

	//attributes 
	private UUID UUID;
	private LocalDateTime date ; 
	private double montant ;
	
	//constructor
	public Operation(UUID UUID , LocalDateTime date , double montant) {
		this.UUID = UUID ;
		this.date = date ;
		this.montant = montant ;
	}
	
	//getters
	public UUID getUUID() {
		return this.UUID;
	}
	
	public LocalDateTime getDate() {
		return this.date;
	}
	
	public double getMontant() {
		return this.montant;
	}
	
	//setters
	public void setUUID(UUID UUID) {
		this.UUID = UUID ;
	}

	public void setMontant(double montant) {
		this.montant = montant ;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date ;
	}
}
