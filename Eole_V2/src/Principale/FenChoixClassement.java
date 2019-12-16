package Principale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FenChoixClassement extends JFrame implements ActionListener{

//-------------------------- Attributs --------------------------//
	private static final String COLONNE1 = "Classe"; //permet de modifier le nom des colonnes du classement
	private static final String COLONNE2 = "Voilier";
	private static final String COLONNE3 = "Nom skipper";
	private static final String COLONNE4 = "Ratting";
	private static final String COLONNE5 = "Tps reel";
	private static final String COLONNE6 = "Tps composee";
	private static final String COLONNE7 = "Class. classe";
	private static final String COLONNE8 = "Class. General";
	
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
	private JButton btnClassement1 = new JButton("Obtenir palmar�s classe 1");
	private JButton btnClassement2 = new JButton("Obtenir palmar�s classe 2");
	private JButton btnClassementTotal = new JButton("Obtenir palmar�s g�n�ral");
	private JButton btnExport = new JButton("Exporter");
	final JFileChooser fc = new JFileChooser();

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
		// Image Icon de la frame
		setIconImage(Toolkit.getDefaultToolkit().getImage(FenChrono.class.getResource("/Other/Maquette/planche.png")));
		setResizable(false);
		this.r=r;
		this.classe1=r.classementClasse1;
		this.classe2=r.classementClasse2;
		this.classeGen=r.classementGene;
		this.setTitle("Choix classement");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(1100, 480);
		this.setLocationRelativeTo(null);
		btnClassement1.addActionListener(this);
		btnClassement1.setBackground(new Color(0,74,124));
		btnClassement1.setForeground(new Color(252,252,252));
		btnClassement2.addActionListener(this);
		btnClassement2.setBackground(new Color(0,74,124));
		btnClassement2.setForeground(new Color(252,252,252));
		btnClassementTotal.addActionListener(this);
		btnClassementTotal.setBackground(new Color(0,74,124));
		btnClassementTotal.setForeground(new Color(252,252,252));
		btnExport.addActionListener(this);
		btnExport.setBackground(new Color(0,74,124));
		btnExport.setForeground(new Color(252,252,252));
		btnExport.setEnabled(false);
		panelGeneral.setLayout(null);
		panelGeneral.setBackground(new Color(207,235,255));
		panelBoutons.setBounds(0, 0, 1084, 41);
		panelBoutons.setBackground(new Color(207,235,255));
		panelGeneral.add(panelBoutons);
		panelClassement.setBounds(0, 40, 1084, 402);
		panelClassement.setBackground(new Color(207,235,255));
		panelGeneral.add(panelBoutons);

		panelClassement.setBounds(0, 40, 1084, 402);

		panelClassement.setBackground(new Color(207,235,255));

		panelBoutons.setBounds(0, 0, 1084, 41);
		panelGeneral.setLayout(null);
		panelGeneral.add(panelBoutons);
		panelClassement.setBounds(0, 40, 1084, 402);
		panelClassement.setBackground(new Color(207,235,255));
		panelBoutons.setBounds(0, 0, 1084, 41);
		panelGeneral.setLayout(null);
		panelGeneral.add(panelBoutons);
		panelGeneral.add(panelBoutons);
		panelGeneral.add(panelBoutons);
		panelGeneral.add(panelClassement);
		this.getContentPane().add(panelGeneral,"Center");
		ajoutBoutons();
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				 int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter l'application", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				 if(reponse == JOptionPane.YES_OPTION) {
					 FenAccueil.btnNouvelleRgate.setEnabled(true);
					 FenAccueil.btnNouvelleRgate.setText("Nouvelle Regate");
					 dispose();
				 }
			}
		});
	}
	
	
	/**
	 * @author Augustin et Marine
	 * Permet de connaitre le nombre de voilier � afficher par classement
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
		panelBoutons.add(btnExport);
		panelBoutons.add(new JLabel());
		panelBoutons.add(new JLabel());
		panelBoutons.add(new JLabel());
		panelBoutons.add(new JLabel());
	}
	
	
	/**
	 * @author Augustin et Marine
	 * Permet de cr�er les entetes des colonnes du classement
	 */
	public void enteteClassement() {
		switch(choix) {
		case 1: case 2:
			lColonne7 = new JLabel(COLONNE7.toUpperCase());
			lColonne1 = new JLabel(COLONNE1.toUpperCase());
			lColonne2 = new JLabel(COLONNE2.toUpperCase());
			lColonne3 = new JLabel(COLONNE3.toUpperCase());
			lColonne4 = new JLabel(COLONNE4.toUpperCase());
			lColonne5 = new JLabel(COLONNE5.toUpperCase());
			lColonne6 = new JLabel(COLONNE6.toUpperCase());
			lColonne8 = new JLabel(COLONNE8.toUpperCase());
			
			break;
		case 3:
			lColonne7 = new JLabel(COLONNE7.toUpperCase());
			lColonne1 = new JLabel(COLONNE1.toUpperCase());
			lColonne2 = new JLabel(COLONNE2.toUpperCase());
			lColonne3 = new JLabel(COLONNE3.toUpperCase());
			lColonne4 = new JLabel(COLONNE4.toUpperCase());
			lColonne5 = new JLabel(COLONNE5.toUpperCase());
			lColonne6 = new JLabel(COLONNE6.toUpperCase());
			lColonne8 = new JLabel(COLONNE8.toUpperCase());
			break;
		}
		lColonne1.setForeground(new Color(0,118,197));
		lColonne2.setForeground(new Color(0,118,197));
		lColonne3.setForeground(new Color(0,118,197));
		lColonne4.setForeground(new Color(0,118,197));
		lColonne5.setForeground(new Color(0,118,197));
		lColonne6.setForeground(new Color(0,118,197));
		lColonne7.setForeground(new Color(0,118,197));
		lColonne8.setForeground(new Color(0,118,197));
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
	 * la place dans le classement g�neral
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
				//panelClassement.add(new JLabel(String.valueOf(v.getClasse())));
				panelClassement.add(new JLabel(String.valueOf(this.getPlace(v))));
				panelClassement.add(new JLabel(v.getNom()));
				panelClassement.add(new JLabel(v.skipper.getNom()));
				panelClassement.add(new JLabel(String.valueOf(v.getRating())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsHMS())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsCompense())));
				panelClassement.add(new JLabel(String.valueOf(r.getPlaceDansClassementGeneral(v))));
			}
			break;
		case 2: 
			for(Voilier v : classe2) {
				//panelClassement.add(new JLabel(String.valueOf(v.getClasse())));
				panelClassement.add(new JLabel(String.valueOf(this.getPlace(v))));
				panelClassement.add(new JLabel(v.getNom()));
				panelClassement.add(new JLabel(v.skipper.getNom()));
				panelClassement.add(new JLabel(String.valueOf(v.getRating())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsHMS())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsCompense())));
				panelClassement.add(new JLabel(String.valueOf(r.getPlaceDansClassementGeneral(v))));
			}
			break;
		case 3: 
			for(Voilier v : classeGen) {
				panelClassement.add(new JLabel(String.valueOf(r.getPlaceDansClassementGeneral(v))));
				panelClassement.add(new JLabel(String.valueOf(v.getClasse())));
				panelClassement.add(new JLabel(v.getNom()));
				panelClassement.add(new JLabel(v.skipper.getNom()));
				panelClassement.add(new JLabel(String.valueOf(v.getRating())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsHMS())));
				panelClassement.add(new JLabel(String.valueOf(v.getTempsCompense())));
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
			panelClassement.add(lColonne7);
			//panelClassement.add(lColonne1);
			panelClassement.add(lColonne2);
			panelClassement.add(lColonne3);
			panelClassement.add(lColonne4);
			panelClassement.add(lColonne5);
			panelClassement.add(lColonne6);
			panelClassement.add(lColonne8);
			break;
		case 3:
			panelClassement.add(lColonne8);
			panelClassement.add(lColonne1);
			panelClassement.add(lColonne2);
			panelClassement.add(lColonne3);
			panelClassement.add(lColonne4);
			panelClassement.add(lColonne5);
			panelClassement.add(lColonne6);
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
			panelClassement.setLayout(new GridLayout(nbCases,7));
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
			btnExport.setEnabled(true);
			panelClassement.removeAll();
			chargementClassement();
			SwingUtilities.updateComponentTreeUI(this);
		}else if (e.getSource()==btnClassement2) {
			choix=2;
			btnExport.setEnabled(true);
			panelClassement.removeAll();
			chargementClassement();
			SwingUtilities.updateComponentTreeUI(this);
		}else if(e.getSource()==btnClassementTotal){
			choix=3;
			btnExport.setEnabled(true);
			panelClassement.removeAll();
			chargementClassement();
			SwingUtilities.updateComponentTreeUI(this);
		} else if(e.getSource() == btnExport) {
			print();
		}
	}

	public void print() {
		switch(choix) {
		case 1:
			fc.setSelectedFile(new File("Regate_" + r.getNum() + "_Classe1.txt"));
			break;
		case 2:
			fc.setSelectedFile(new File("Regate_" + r.getNum() + "_Classe2.txt"));
			break;
		case 3:
			fc.setSelectedFile(new File("Regate_" + r.getNum() + "_ClasseGene.txt"));
			break;
		}
		
		int val_retour = fc.showSaveDialog(this);
		
		if (val_retour == JFileChooser.APPROVE_OPTION) {
			double distanceKm = r.getDistance() * 1.609;
            File fichier = fc.getSelectedFile();
            String chemin = fichier.getAbsolutePath();
            //afficher le chemin absolu du fichier
            System.out.println("Chemin absolu : "+chemin+"\n");
            try {
				fichier.createNewFile();
				switch(choix) {
    			case 1:
    				fc.setSelectedFile(new File("Regate_" + r.getNum() + "_Classe1.txt"));
    				PrintWriter fl = new PrintWriter(fichier);
					fl.println("Regate : " + r.getNum());
					fl.println("Nombre de participants : " + classe1.size());
					fl.println("Distance : " + r.getDistance() + " Milles | Environ : " + distanceKm + " en Killometre(s)");
					fl.println("___________________________________________________________________________________________");
					fl.println("\n");
					fl.println(COLONNE7.toUpperCase() + "\t | \t" + COLONNE2.toUpperCase() + "\t\t | \t" + COLONNE3.toUpperCase() + "\t | \t" + COLONNE4.toUpperCase() + "\t\t | \t" + COLONNE5.toUpperCase() + "\t | \t" + COLONNE6.toUpperCase() + "\t | \t" + COLONNE8.toUpperCase());
					for(Voilier v : classe1) {
						fl.println(this.getPlace(v) + "\t | \t" + v.getNom() + "\t | \t" + v.skipper.getNom() + "\t | \t" + v.getRating() + "\t | \t" + v.getTempsHMS() + "\t | \t" + v.getTempsCompense() + "\t | \t" + r.getPlaceDansClassementGeneral(v));
					}
					fl.close();
    				break;
    			case 2:
    				fc.setSelectedFile(new File("Regate_" + r.getNum() + "_Classe2.txt"));
    				PrintWriter f2 = new PrintWriter(fichier);
					f2.println("Regate : " + r.getNum());
					f2.println("Nombre de participants : " + classe1.size());
					f2.println("Distance : " + r.getDistance() + " Milles | Environ : " + distanceKm + " en Killometre(s)");
					f2.println("___________________________________________________________________________________________");
					f2.println("\n");
					f2.println(COLONNE7.toUpperCase() + "\t | \t" + COLONNE2.toUpperCase() + "\t\t | \t" + COLONNE3.toUpperCase() + "\t | \t" + COLONNE4.toUpperCase() + "\t\t | \t" + COLONNE5.toUpperCase() + "\t | \t" + COLONNE6.toUpperCase() + "\t | \t" + COLONNE8.toUpperCase());
					for(Voilier v : classe2) {
						f2.println(this.getPlace(v) + "\t | \t" + v.getNom() + "\t | \t" + v.skipper.getNom() + "\t | \t" + v.getRating() + "\t | \t" + v.getTempsHMS() + "\t | \t" + v.getTempsCompense() + "\t | \t" + r.getPlaceDansClassementGeneral(v));
					}
					f2.close();
    				break;
    			case 3:
    				fc.setSelectedFile(new File("Regate_" + r.getNum() + "_ClasseGene.txt"));
    				break;
    			}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new FenChoixClassement(new Regate("test", 10, 400));
	}
}
