package Principale;


public class Skipper {

	
	
//-------------------------- Attributs --------------------------//
	private String nom;
//-------------------------- Fin attributs --------------------------//
	
	
	
	
	
//-------------------------- Getters/Setters --------------------------//
	/**
	 * 
	 * Getter de NOM
	 * @return String
	 * Le nom
	 * @author Augustin et Thomas 
	 */
	public String getNom() {
		return nom;
	}

	
	
	/**
	 * 
	 * Setter de nom
	 * @param nom
	 * Le nom
	 * @author Augustin et Thomas
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	

//-------------------------- Fin Getters/Setters --------------------------//
	
	
	
	
//-------------------------- Constructeurs --------------------------//
	/**
	 * @param nom
	 * @param prenom
	 * @author Augustin et Thomas
	 */
	public Skipper(String nom) {
		this.nom = nom;
	}
//-------------------------- Fin Constructeurs --------------------------//
}
