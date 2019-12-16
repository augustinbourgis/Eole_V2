package Principale;
import java.util.*;

public class Regate {
	
	
	
//-------------------------- Attributs --------------------------//
	private double distance; //en Milles !


	private String num;
	private int nbParticipants; // MAX 20
	private int MAX_PARTICIPANT = 20;
	ArrayList<Voilier> classementClasse1 = new ArrayList<Voilier>();
	ArrayList<Voilier> classementClasse2 = new ArrayList<Voilier>();
	ArrayList<Voilier> classementGene = new ArrayList<Voilier>();
	ArrayList<Voilier> participants = new ArrayList<Voilier>();
//-------------------------- Fin Attributs --------------------------//
	
	
	
//-------------------------- Getters/Setters --------------------------//
	/**
	 * GETTER distance
	 * @return distance
	 * la distance
	 * @author Marine
	 */
	public double getDistance() {
		return distance;
	}
	
	
	/**
	 * SETTER distance
	 * @param distance
	 * la distance
	 * @author Marine
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	/**
	 * GETTER nbr de participants
	 * @return nbParticipants
	 * le nbr de participants
	 * @author Marine
	 */
	public int getNbParticipants() {
		return nbParticipants;
	}
	
	
	/**
	 * SETTER nbr de participants
	 * @param nbr de participants
	 * le nbr de participants
	 * @author Marine
	 */
	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}

	
//-------------------------- Fin Getters/Setters --------------------------//
	
	
	
	
	

//-------------------------- Constructeurs --------------------------//
	/**
	 * @param nom
	 * @param distance
	 * @param nbParticipants
	 * @author Augustin et Wizard
	 */
	public Regate(String nom, int nbParticipants, int distance) {
		this.distance = distance;
		this.nbParticipants = nbParticipants;
		this.num=nom;
	}
//-------------------------- Fin Constructeurs --------------------------//
	
	
	
	
//-------------------------- Méthodes --------------------------//
	/**
	 * 
	 * Permet d'ajouter un participant à un voilier
	 * QUE SI le nombre de participant est inférieur à 20
	 * @param v le Voilier du participant
	 * @return True si l'ajout est fait
	 * @author Augustin et Wizard
	 */
	public boolean ajoutParticipant(Voilier v) {
		if(nbParticipants < MAX_PARTICIPANT) {
			participants.add(v);
			nbParticipants++;
			return true;
		}
		return false;
	}

	/**
	 * Permet de mettre a jour les classsments
	 * @author Augustin
	 */
	public void faireClassement() {
		for(Voilier v : classementGene) {
			if(v.getClasse()==1) {
				classementClasse1.add(v);
			}else {
				classementClasse2.add(v);
			}
		}
	}
	
	
	
	
	/**
	 * 
	 * USAGE : System.out.println(FONCTION);
	 * Pour obtenir le classement général des participants
	 * @return String 
	 * Le classement des participants
	 * @author Augustin et Wizard
	 */
	public String classementGeneral() {
		String liste = "\tClassement Général : \n";
		int i = 1;
		try {
			for(Voilier v : classementGene) {
				liste += i + " | " + v.toString() + " : " + v.getTempsHMS() + "\n";
				i++;
			}
		} catch (Exception e) {
			System.out.println("Problème avec l'ArrayList 'classementGene'");
			return "K.O";
		}
		return liste;
	}
	
	
	
	
	/**
	 *
	 * USAGE : System.out.println(FONCTION);
	 * Pour obtenir la liste des participants
	 * @return String 
	 * La liste des participants
	 *  @author Augustin et Wizard
	 */
	public String listeParticipants() {
		String liste = "\tParticipants : \n";
		try {
			for(Voilier v : participants) {
				liste += v.toString() + "\n";
			}
		} catch (Exception e) {
			System.out.println("Probleme avec l'ArrayList 'participant'");
			return "K.O";
		}
		liste += "Nombre de participants : " + nbParticipants;
		return liste;
	}
	
	
	
	
	
	/**
	 * 
	 * USAGE : System.out.println(FONCTION);
	 * Pour obtenir le classement des participants de classe 1
	 * @return String 
	 * Classement des participants classe 1
	 * @author Augustin et Wizard
	 */
	public String classementClasse1() {
		String liste = "\t Classement Classe 1 : \n";
		int i = 1;
		try {
			for(Voilier v : classementClasse1) {
				liste += i + " | " + v.getNom() + " : " + v.getTempsHMS() + "\n";
				i++;
			}
		} catch (Exception e) {
			System.out.println("Problème avec l'ArrayList 'classementClasse1'");
			return "K.O";
		}
		return liste;
	}
	
	
	
	
	
	/**
	 * 
	 * USAGE : System.out.println(FONCTION);
	 * Pour obtenir le classement des participants de classe 2
	 * @return String 
	 * Classement des participants classe 2
	 * @author Augustin et Wizard
	 */
	public String classementClasse2() {
		String liste = "\t Classement Classe 2 : \n";
		int i = 1;
		try {
			for(Voilier v : classementClasse2) {
				liste += i + " | " + v.getNom() + " : " + v.getTempsHMS() + "\n";
				i++;
			}
		} catch (Exception e) {
			System.out.println("Problème avec l'ArrayList 'classementClasse2'");
			return "K.O";
		}
		return liste;
	}
	
	
	
	/**
	 * 
	 * USAGE : System.out.println(FONCTION);
	 * Pour obtenir les médaillés de classe 1
	 * @return String 
	 * Médaillés de classe 1
	 * @author Augustin et Wizard
	 */
	public String medaillerClasse1() {
		String liste = "\tMÃ©dailler Classe 1 : \n";
		int i = 0;
		try {
			for(Voilier v : classementClasse1) {
				switch(i) {
				case 1 :
					liste += "Or : " + v.getNom() + "\n";
					break;
				case 2 :
					liste += "Argent : " + v.getNom() + "\n";
				case 3 :
					liste += "Bronze : " + v.getNom() + "\n";
				}
				i++;
			}
		} catch (Exception e) {
			System.out.println("Problème avec l'ArrayList 'classementClasse1'");
			return "K.O";
		}
		return liste;
	}
	
	
	
	/**
	 * 
	 * USAGE : System.out.println(FONCTION);
	 * Pour obtenir les médaillés de classe 2
	 * @return String 
	 * Médaillés de classe 2
	 * @author Augustin et Wizard
	 */
	public String medaillerClasse2() {
		String liste = "\tMÃ©dailler Classe 2 : \n";
		int i = 0;
		try {
			for(Voilier v : classementClasse2) {
				switch(i) {
				case 1 :
					liste += "Or : " + v.getNom() + "\n";
					break;
				case 2 :
					liste += "Argent : " + v.getNom() + "\n";
				case 3 :
					liste += "Bronze : " + v.getNom() + "\n";
				}
				i++;
			}
		} catch (Exception e) {
			System.out.println("Problème avec l'ArrayList 'classementClasse2'");
		}
		return liste;
	}
	
	
	/**
	 * @author Augustin
	 * Permet d'obtenir la place du voilier dans le classement général
	 * @param v
	 * le voilier
	 * @return
	 * la place du voilier
	 */
	public int getPlaceDansClassementGeneral(Voilier v) {
		int place = 1;
		for(Voilier voilier : classementGene) {
			if(voilier==v) {
				return place;
			}
			place++;
		}
		return 0;
	}
	
	
	
	/**
	 * 
	 * BOOLEAN
	 * Met fin à la course pour le participant
	 * @param v
	 * Le participant
	 * @param temps
	 * Le temps où le participant passe la ligne d'arrivée
	 * @return
	 * TRUE : ajout réussi
	 * FALSE : probleme avec l'ArrayList 'classementGene'
	 * @author Augustin et Wizard 
	 *
	 */
	public boolean ajoutArrivee(Voilier v, int temps) {
		try {
			boolean b = classementGene.add(v);
			v.setTempsReel(temps);
			return b;
		} catch (Exception e) {
			System.out.println("ArrayList 'classementGene' n'existe pas");
			return false;
		}
	}
}
