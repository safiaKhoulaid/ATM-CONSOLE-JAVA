package entities;

import java.util.List ; 
import java.util.ArrayList;

public abstract class Compte {

	//attributes
	private String code ;
	private double solde;
	private List<Operation> listOperations;
	
	//constructor
	public Compte(String code , double solde ) {
		this.code = code ;
		this.solde = solde ;
		this.listOperations = new ArrayList<>();
	}
	
	//getters
	public String getCode() {
		return this.code;
	}
	
	public double getSolde() {
		return this.solde;
	}
	
	public List<Operation> getListOperation(){
		return this.listOperations;
	}
	
	//setters
	public void setCode(String code) {
		this.code = code ;
	}
	
	public void setSolde(double solde) {
		this.solde = solde ;
	}
	
}
