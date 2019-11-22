package Principale;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FenInscription extends JFrame implements ActionListener{
	//----- panel général ----//
	JPanel panelGen = new JPanel();
	JButton btnDemarrerRegate = new JButton("Démarrer la régate");
	
	//---- panel parcours sur la gauche  en haut-----//
	JPanel panelGauche = new JPanel();
	JPanel panelParcours = new JPanel();
	JLabel titreParcours = new JLabel("Parcours");
	JTextField txtNumero = new JTextField("");
	JTextField txtDistance = new JTextField("");
	JLabel lNumero = new JLabel("Numéro : ");
	JLabel lDistance = new JLabel("Distance (en miles) : ");
	
	// ---- panel participant sur la gauche en bas ---//
	
	JPanel panelParticipants = new JPanel();
	JLabel titreParticipant = new JLabel("Participants");
	JTextField txtNumeroVoilier = new JTextField("");
	JTextField txtNomVoilier = new JTextField("");
	JTextField txtClasse = new JTextField("");
	JTextField txtRating = new JTextField("");
	JTextField txtNomSkipper = new JTextField("");
	JLabel lNumeroVoilier = new JLabel("Numero du voilier : ");
	JLabel lNomVoilier = new JLabel("Nom du voilier : ");
	JLabel lClasse = new JLabel("Classe : ");
	JLabel lRating = new JLabel("Rating : ");
	JLabel lNomSkipper = new JLabel("Nom du skipper : ");
	JButton btnAjouterListe = new JButton ("Ajouter à la liste");
	
	
	//---- panel liste participant sur la droite---//
	
	JPanel panelListeParticipants = new JPanel();
	JLabel titreListe = new JLabel("Liste des participants");
	JLabel lInfoParticipant = new JLabel("Infos participant : ");
	JLabel lListeInfoParticipant = new JLabel();
	JButton btnSupprimer = new JButton("Supprimer");
	
	
	
	public FenInscription() {
		this.setTitle("Fenêtre Inscription");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 480);
		this.setLocationRelativeTo(null);
		
		
		//---- panel general----//
		panelGen.setLayout(new GridLayout(1,2));
		panelGen.add(panelGauche);
		panelGen.add(panelListeParticipants);
		
		
		
		
		//----panel parcours ---//
		
		panelGauche.setLayout(new GridLayout(13,2));
		
		panelGauche.add(titreParcours);
		JLabel l1 =new JLabel();
		panelGauche.add(l1);
		//panelGauche.add(panelParcours);
		panelGauche.add(lNumero);
		panelGauche.add(txtNumero);
		
		panelGauche.add(lDistance);
		panelGauche.add(txtDistance);
		panelGauche.add(new JLabel());
		panelGauche.add(new JLabel());
		panelGauche.add(titreParticipant);
		//panelGauche.add(panelParticipants);
		
		panelGauche.add(new JLabel());
		
		
		//--- panel participant ---//
		panelGauche.add(lNumeroVoilier);
		panelGauche.add(txtNumeroVoilier);
		panelGauche.add(lNomVoilier);
		panelGauche.add(txtNomVoilier);
		panelGauche.add(lClasse);
		panelGauche.add(txtClasse);
		panelGauche.add(lRating);
		panelGauche.add(txtRating);
		panelGauche.add(lNomSkipper);
		panelGauche.add(txtNomSkipper);
		
		panelGauche.add(btnAjouterListe);
		btnAjouterListe.addActionListener(this);
		panelGauche.add(new JLabel());
		panelGauche.add(new JLabel());
		panelGauche.add(new JLabel());
		panelGauche.add(btnDemarrerRegate);
		btnDemarrerRegate.addActionListener(this);
		
		
		
		
		
		
		
	
	
		
		
		// ----panel liste ----//
		panelListeParticipants.add(titreListe);
		panelListeParticipants.add(lInfoParticipant);
		panelListeParticipants.add(lListeInfoParticipant);
		panelListeParticipants.add(btnSupprimer);
		btnSupprimer.addActionListener(this);
		


		
	
		this.getContentPane().add(panelGen,"Center");

		
	}
	
	 
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main (String [] args) {
		FenInscription f = new FenInscription();
		f.setVisible(true);
	}
}
