package Principale;


public class Skipper {

	
	
//-------------------------- Attributs --------------------------//
	private String nom;
	private String prenom;
//-------------------------- Fin attributs --------------------------//
	
	
	
	
	
//-------------------------- Getters/Setters --------------------------//
	/**
	 * 
	 * Getter de NOM
	 * @return String
	 * Le nom
	 * @author Augustin et Wizard 
	 */
	public String getNom() {
		return nom;
	}

	
	
	/**
	 * 
	 * Setter de nom
	 * @param nom
	 * Le nom
	 * @author Augustin et Wizard
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	/**
	 * 
	 * Getter de PRENOM
	 * @return String
	 * Le prenom
	 * @author Augustin et Wizard
	 */
	public String getPrenom() {
		return prenom;
	}

	
	
	/**
	 * 
	 * Setter de prenom
	 * @param prenom
	 * Le prenom
	 * @author Augustin et Wizard
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
//-------------------------- Fin Getters/Setters --------------------------//
	
	
	
	
//-------------------------- Constructeurs --------------------------//
	/**
	 * @param nom
	 * @param prenom
	 * @author Augustin et Wizard
	 */
	public Skipper(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
//-------------------------- Fin Constructeurs --------------------------//
}
