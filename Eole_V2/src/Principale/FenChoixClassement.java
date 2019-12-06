package Principale;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FenChoixClassement extends JFrame implements ActionListener{

//-------------------------- Attributs --------------------------//
	private static final String COLONNE1 = "Classe"; //permet de modifier le nom des colonnes du classement
	private static final String COLONNE2 = "Voilier";
	private static final String COLONNE3 = "Nom skipper";
	private static final String COLONNE4 = "Ratting";
	private static final String COLONNE5 = "Tps réel";
	private static final String COLONNE6 = "Tps composé";
	private static final String COLONNE7 = "Clas. classe";
	private static final String COLONNE8 = "Clas. Général";
	
	private ArrayList<Voilier> classe1 = new ArrayList<Voilier>(); //ArrayList de la classe 1
	private ArrayList<Voilier> classe2 = new ArrayList<Voilier>();	//ArrayList de la classe 2
	private ArrayList<Voilier> classeGen = new ArrayList<Voilier>();	//ArrayList avec toutes les classes
	private int nbCases;
	private int choix;
	private Regate r;
	
//-------------------------- Composants Fenetre --------------------------//
	private JLabel lColonne1;
	private JLabel lColonne2;
	private JLabel lColonne3;
	private JLabel lColonne4;
	private JLabel lColonne5;
	private JLabel lColonne6;
	private JLabel lColonne7;
	private JLabel lColonne8;
	private JPanel panelGeneral = new JPanel();
	private JPanel panelBoutons = new JPanel();
	private JPanel panelClassement = new JPanel();
	private JButton btnClassement1 = new JButton("Obtenir palmarès classe 1");
	private JButton btnClassement2 = new JButton("Obtenir palmarès classe 2");
	private JButton btnClassementTotal = new JButton("Obtenir palmarès général");
	

//-------------------------- Constructeurs --------------------------//
	/**
	 * @author Augustin et Marine
	 * Le constructeur de la fenetre
	 * @param classe1
	 * L'ArrayList de la classe 1
	 * @param classe2
	 * L'ArrayList de la classe 2
	 * @param classeGen
	 * L'ArrayList avec toutes les classes
	 */
	public FenChoixClassement(Regate r) {
		this.r=r;
		this.classe1=r.classementClasse1;
		this.classe2=r.classementClasse2;
		this.classeGen=r.classementGene;
		this.setTitle("Choix classement");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 480);
		this.setLocationRelativeTo(null);
		btnClassement1.addActionListener(this);
		btnClassement2.addActionListener(this);
		btnClassementTotal.addActionListener(this);
		panelGeneral.setLayout(null);
		panelBoutons.setBounds(0, 0, 1084, 41);
		panelGeneral.add(panelBoutons);
		panelClassement.setBounds(0, 40, 1084, 402);
		panelGeneral.add(panelClassement);
		this.getContentPane().add(panelGeneral,"Center");
		ajoutBoutons();
		this.setVisible(true);
	}
	
	
	/**
	 * @author Augustin et Marine
	 * Permet de connaitre le nombre de voilier à afficher par classement
	 */
	public void updateNbCases() {
		switch(choix) {
		case 1:
			nbCases=classe1.size()+1;
			break;
		case 2:
			nbCases=classe2.size()+1;

			break;
		case 3:
			nbCases=classeGen.size()+1;
			break;
		}
	}
	
	
	/**
	 * @author Augustin et Marine
	 * Permet d'ajouter les boutons de haut de fenetre
	 */
	public void ajoutBoutons() {
		panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBoutons.add(btnClassement1);
		panelBoutons.add(btnClassement2);
		panelBoutons.add(btnClassementTotal);
		panelBoutons.add(new JLabel());
		panelBoutons.add(new JLabel());
		panelBoutons.add(new JLabel());
		panelBoutons.add(new JLabel());
	}
	
	
	/**
	 * @author Augustin et Marine
	 * Permet de créer les entetes des colonnes du classement
	 */
	public void enteteClassement() {
		switch(choix) {
		case 1: case 2:
			lColonne1 = new JLabel(COLONNE1);
			lColonne2 = new JLabel(COLONNE2);
			lColonne3 = new JLabel(COLONNE3);
			lColonne4 = new JLabel(COLONNE4);
			lColonne5 = new JLabel(COLONNE5);
			lColonne6 = new JLabel(COLONNE6);
			lColonne7 = new JLabel(COLONNE7);
			lColonne8 = new JLabel(COLONNE8);
			
			break;
		case 3:
			lColonne1 = new JLabel(COLONNE1);
			lColonne2 = new JLabel(COLONNE2);
			lColonne3 = new JLabel(COLONNE3);
			lColonne4 = new JLabel(COLONNE4);
			lColonne5 = new JLabel(COLONNE5);
			lColonne6 = new JLabel(COLONNE6);
			lColonne8 = new JLabel(COLONNE8);
			break;
		}
	}
	
	
	/**
	 * @author Augustin et Marine
	 * @param v
	 * le voilier
	 * @return
	 * la place du voilier
	 */
	public int getPlace(Voilier v) {
		int place = 0;
		switch(v.getClasse()) {
		case 1: 
			for(Voilier voil : classe1) {
				place++;
				if(voil==v) {
					return place;
				}
			}
			return 0;
		case 2:
			for(Voilier voilier : classe2) {
				place++;
				if(voilier==v) {
					return place;
				}
			}
			return 0;
		}
		return 0;
	}
	
	
	/**
	 * @author Augustin et Marine
	 * @param v
	 * le voilier
	 * @return
	 * la place dans le classement géneral
	 */
	public int getPlaceGeneral(Voilier v) {
		int place=0;
		for(Voilier voil : classeGen) {
			place++;
			if(voil==v) {
				return place;
			}
		}
		return 0;
	}
	
	
	/**
	 * @author Marine, Augustin
	 * Permet de remplir les cases avec les informations
	 */
	public void remplirVide() {
		switch(choix) {
		case 1: 
			for(Voilier v : classe1) {
				panelClassement.add(new JLabel(String.valueOf(v.getClasse())));
				panelClassement.add(new JLabel(v.getNom()));
				panelClassement.add(new JLabel(v.skipper.getNom()));
				panelClassement.add(new JLabel(String.valueOf(v.getRating())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsReel())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsCompense())));
				panelClassement.add(new JLabel(String.valueOf(this.getPlace(v))));
				panelClassement.add(new JLabel("gen"));
			}
			break;
		case 2: 
			for(Voilier v : classe2) {
				panelClassement.add(new JLabel(String.valueOf(v.getClasse())));
				panelClassement.add(new JLabel(v.getNom()));
				panelClassement.add(new JLabel(v.skipper.getNom()));
				panelClassement.add(new JLabel(String.valueOf(v.getRating())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsReel())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsCompense())));
				panelClassement.add(new JLabel("j"));
				panelClassement.add(new JLabel("gen"));
			}
			break;
		case 3: 
			for(Voilier v : classeGen) {
				panelClassement.add(new JLabel(String.valueOf(v.getClasse())));
				panelClassement.add(new JLabel(v.getNom()));
				panelClassement.add(new JLabel(v.skipper.getNom()));
				panelClassement.add(new JLabel(String.valueOf(v.getRating())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsReel())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsCompense())));
				panelClassement.add(new JLabel("gen"));
			}
			break;
		}
	
	}
	
	/**
	 * @author Augustin et Marine
	 * Permet de mettre les entetes au classement
	 */
	public void addEntete() {
		switch(choix) {
		case 1: case 2:
			panelClassement.add(lColonne1);
			panelClassement.add(lColonne2);
			panelClassement.add(lColonne3);
			panelClassement.add(lColonne4);
			panelClassement.add(lColonne5);
			panelClassement.add(lColonne6);
			panelClassement.add(lColonne7);
			panelClassement.add(lColonne8);
			break;
		case 3:
			panelClassement.add(lColonne1);
			panelClassement.add(lColonne2);
			panelClassement.add(lColonne3);
			panelClassement.add(lColonne4);
			panelClassement.add(lColonne5);
			panelClassement.add(lColonne6);
			panelClassement.add(lColonne8);
		}
	}
	
	
	/** 
	 * @author Augustin et Marine
	 * Permet de charger le classement cliquer
	 */
	public void chargementClassement() {
		updateNbCases();
		switch (choix) {
		case 1: case 2:
			panelClassement.setLayout(new GridLayout(nbCases,8));
			break;
		default:
			panelClassement.setLayout(new GridLayout(nbCases,7));
			break;
		}
		enteteClassement();
		addEntete();
		remplirVide();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnClassement1) {
			choix=1;
			panelClassement.removeAll();
			chargementClassement();
			SwingUtilities.updateComponentTreeUI(this);
		}else if (e.getSource()==btnClassement2) {
			choix=2;
			panelClassement.removeAll();
			chargementClassement();
			SwingUtilities.updateComponentTreeUI(this);
		}else if(e.getSource()==btnClassementTotal){
			choix=3;
			panelClassement.removeAll();
			chargementClassement();
			SwingUtilities.updateComponentTreeUI(this);
		}
		
	}

	
	public static void main(String[] args) {
		new FenChoixClassement(new Regate("test", 10, 400));
	}
}
