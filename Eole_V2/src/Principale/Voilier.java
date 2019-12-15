package Principale;

public class Voilier {
	
	
//-------------------------- Attributs --------------------------//
	private String nom;
	private int classe;
	public int num;
	public Skipper skipper;
	private boolean abandon ;
	private int rating = 0; //
	private int tempsReel = 0; //temps en seconds
	private int tempsCompense = 0;
	private String tempsHMS = "";
//-------------------------- Fin Attributs --------------------------//
	
	
	
	
//-------------------------- Getters/Setters --------------------------//
	/**
	 * toString de voilier
	 * @return ex: Pierre classe 2
	 * @author Marine
	 */
	
	public String toString() {
		return nom + " CLASSE : " + classe;
	}
	/**
	 * Getter de NOM
	 * @return nom
	 * Le nom
	 * @author Marine
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * SETTER nbr nom
	 * @param nom
	 * le nom
	 * @author Marine
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Getter de classe
	 * @return classe
	 * Le classe
	 * @author Marine
	 */
	public int getClasse() {
		return classe;
	}
	/**
	 * SETTER classe
	 * @param classe
	 * la classe
	 * @author Marine
	 */
	public void setClasse(int classe) {
		this.classe = classe;
	}
	/**
	 * Getter de rating
	 * @return rating
	 * Le rating
	 * @author Marine
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * SETTER rating
	 * @param rating
	 * le rating
	 * @author Marine
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * Getter de temps reel
	 * @return tempsReel
	 * Le tempsReel
	 * @author Marine
	 */
	public int getTempsReel() {
		return tempsReel;
	}
	/**
	 * SETTER tempsReel
	 * @param tempsReel
	 * le tempsReel
	 * @author Marine
	 */
	public void setTempsReel(int tempsReel) {
		this.tempsReel = tempsReel;
	}
	/**
	 * Getter de tempsCompense
	 * @return tempsCompense
	 * Le tempsCompense
	 * @author Marine
	 */
	public int getTempsCompense() {
		return tempsCompense;
	}
	/**
	 * SETTER tempsCompense
	 * @param tempsCompense
	 * le tempsCompense
	 * @author Marine
	 */
	public void setTempsCompense(int tempsCompense) {
		this.tempsCompense = tempsCompense;
	}
	/**
	 * Getter de tempsHMS
	 * @return tempsHMS
	 * Le tempsHMS
	 * @author Marine
	 */
	public String getTempsHMS() {
		conversionHMS(tempsReel);
		return tempsHMS;
	}
	/**
	 * SETTER tempsHMS
	 * @param tempsHMS
	 * le tempsHMS
	 * @author Marine
	 */
	public void setTempsHMS(String tempsHMS) {
		this.tempsHMS = tempsHMS;
	}
	/**
	 * SETTER abandon
	 * @param etat
	 * true ou false
	 * @author Augustin
	 */
	public void setAbandon(boolean etat) {
		this.abandon=etat;
	}
	/**
	 * Getter de abandon
	 * @return true ou false
	 * @author Augustin
	 */
	public boolean getAbandon() {
		return abandon;
	}
	/**
	 * Getter de num
	 * @return num
	 * @author Marine
	 */
	public int getNum() {
		return this.num;
	}
	/** 
	 * SETTER num
	 * @param num
	 * Le num
	 * @author Marine
	 */

	public void setNum(int num) {
		this.num=num;
	}
//-------------------------- Fin Getters/Setters --------------------------//
	
	
	
	
	
//-------------------------- Constructeurs --------------------------//
	/**
	 * 
	 * @param nomVoilier
	 * @param classe
	 * @author Augustin et Wizard
	 */
	public Voilier(String nomVoilier, int classe, int rating, int num, String nomSkipper) {
		this.nom = nomVoilier;
		this.classe = classe;
		this.rating = rating;
		this.num=num;
		this.abandon=false;
		this.skipper=new Skipper(nomSkipper);
	}
//-------------------------- Fin Constructeurs --------------------------//
	
	
	
	

//-------------------------- Méthodes --------------------------//	
	/**
	 * 
	 * Convertit 256s --> 00:04:16
	 * @param dureeEnSec
	 * La durée à convertir
	 * @author Augustin et Wizard
	 */
	public void conversionHMS(int dureeEnSec) {
		int heures = (int) (dureeEnSec / 3600);
		int minutes = (int) (dureeEnSec - (heures * 60));
		int secondes = (int) (dureeEnSec - (minutes * 60 + heures * 60));
		String H = heures < 10 ? "0" + heures : "" + heures;
		String M = minutes < 10 ? "0" + minutes : "" + minutes;
		String S = secondes < 10 ? "0" + secondes : "" + secondes;
		tempsHMS = H + ":" + M + ":" + S;
	}
	
	
	
	
	/**
	 * 
	 * Calcul le temps de compensation
	 * @param distance
	 * La distance ??
	 * @author Augustin et Wizard
	 */
	public void calculeCompense(double distance) {
		int res = tempsReel == 0 ? 0 : tempsReel + handicap(distance);
		tempsCompense = res;
	}
	
	
	
	
	/**
	 * 
	 * Calcul l'handicap du voilier
	 * @param distance
	 * La distance ??
	 * @return int
	 * L'handicap
	 * @author Augustin et Wizard
	 */
	public int handicap(double distance) {
		return (int) ((5134 / (Math.sqrt(rating) + 3.5)) * distance);
	}


	/**
	 * Permet de faire abandonner un voilier
	 * @return true ou false
	 * @author Augustin
	 */
	public boolean abandon() {
		setAbandon(true);
		return true;
	}
//-------------------------- Fin Méthodes --------------------------//
}
