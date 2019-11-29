package Principale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.SystemColor;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FenInscription extends JFrame implements ActionListener{
	//----- panel g�n�ral ----//
	JPanel panelGen = new JPanel();
	JButton btnDemarrerRegate = new JButton("D�marrer la r�gate");
	
	//---- panel parcours sur la gauche  en haut-----//
	JPanel panelGauche = new JPanel();
	JPanel panelParcours = new JPanel();
	JLabel titreParcours = new JLabel("PARCOURS");
	JTextField txtNumero = new JTextField("");
	JTextField txtDistance = new JTextField("");
	JLabel lNumero = new JLabel("Num�ro : ");
	JLabel lDistance = new JLabel("Distance (en miles) : ");
	
	// ---- panel participant sur la gauche en bas ---//
	
	JPanel panelParticipants = new JPanel();
	JLabel titreParticipant = new JLabel("PARTICIPANTS");
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
	JButton btnAjouterListe = new JButton ("Ajouter � la liste");
	
	
	//---- panel liste participant sur la droite---//
	
	JPanel panelListeParticipants = new JPanel();
	JLabel titreListe = new JLabel("LISTE DES PARTICIPANTS");
	JLabel lInfoParticipant = new JLabel("Infos participant : ");
	JLabel lListeInfoParticipant = new JLabel("222222222222222222222222222222222222222222"
			+ "\n"+"22222222222222");
	JButton btnSupprimer = new JButton("Supprimer");
	
	
	
	public FenInscription() {
		this.setTitle("Fen�tre Inscription");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 480);
		this.setLocationRelativeTo(null);
		
		btnAjouterListe.setBackground(new Color(0,74,124));
		btnDemarrerRegate.setBackground(new Color(0,74,124));
		btnAjouterListe.setForeground(new Color(252,252,252));
		btnDemarrerRegate.setForeground(new Color(252,252,252));
		panelGauche.setBackground(new Color(207	,235,255));
		panelListeParticipants.setBackground(new Color(207,235,255));
		titreListe.setForeground(new Color(0,118,197));
		titreParcours.setForeground(new Color(0,118,197));
		titreParticipant.setForeground(new Color(0,118,197));
		
		//---- panel general----//
		panelGen.setLayout(new GridLayout(1,2));
		panelGen.add(panelGauche);
		panelGen.add(panelListeParticipants);
		
		
	
		
		//----panel parcours ---//
		
		panelGauche.setLayout(new GridLayout(13,2));

		panelGauche.add(titreParcours);
		panelGauche.add(new JLabel(""));
		panelGauche.add(lNumero);
		panelGauche.add(txtNumero);
		panelGauche.add(lDistance);
		panelGauche.add(txtDistance);
		panelGauche .add(new JLabel(""));
		panelGauche .add(new JLabel(""));
		panelGauche.add(titreParticipant);
		panelGauche .add(new JLabel(""));
		
		
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
		panelGauche .add(new JLabel(""));
		panelGauche .add(new JLabel(""));
		panelGauche .add(new JLabel(""));
		
		panelGauche.add(btnDemarrerRegate);
		btnDemarrerRegate.addActionListener(this);
		btnSupprimer.setBackground(new Color(0,85,142));
		btnSupprimer.setForeground(new Color(252,252,252));
		
		btnSupprimer.addActionListener(this);
		GroupLayout gl_panelListeParticipants = new GroupLayout(panelListeParticipants);
		gl_panelListeParticipants.setHorizontalGroup(
			gl_panelListeParticipants.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListeParticipants.createSequentialGroup()
					.addGroup(gl_panelListeParticipants.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelListeParticipants.createSequentialGroup()
							.addGap(164)
							.addComponent(titreListe)
							.addGap(108)
							.addComponent(btnSupprimer))
						.addGroup(gl_panelListeParticipants.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_panelListeParticipants.createParallelGroup(Alignment.LEADING)
								.addComponent(lListeInfoParticipant)
								.addComponent(lInfoParticipant))))
					.addGap(70))
		);
		gl_panelListeParticipants.setVerticalGroup(
			gl_panelListeParticipants.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListeParticipants.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panelListeParticipants.createParallelGroup(Alignment.BASELINE)
						.addComponent(titreListe)
						.addComponent(btnSupprimer))
					.addGap(41)
					.addComponent(lInfoParticipant)
					.addGap(43)
					.addComponent(lListeInfoParticipant)
					.addGap(286))
		);
		panelListeParticipants.setLayout(gl_panelListeParticipants);
		
	
	
		this.getContentPane().add(panelGen,"Center");

		
	}
	
	 
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main (String [] args) {
		FenInscription f = new FenInscription();
		f.setVisible(true);
	}
}
