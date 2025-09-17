package repository;

import java.util.HashMap;
import java.util.Map ; 
import entities.Compte;

public class CompteRepository {

   //attributes
	private Map<String , Compte> comptes = new HashMap<>();
	
  //constructor
	public CompteRepository() {
		this.comptes = new HashMap<>();
	}
	
	//Function pour ajouter un compte
	public void save(Compte compte) {
		comptes.put(compte.getCode(), compte);
	}
	
	//fonction de recherche par code
	public Compte findByCode(String code) {
		return comptes.get(code);
	}
	
	//fonction de supprimer
	public void delete(String code) {
		comptes.remove(code);
	}
	
	//afficher tout les comptes
	public Map<String , Compte> findAll(){
		return comptes ; 
		// new ArrayList<>(this.comptes.values())
	}
	
	//tester l exitence d'un compte
	public boolean exist(String code) {
		return comptes.containsKey(code);
	}
}
