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
	
	/**
	 * Description : Initialisation composant JFrame
	 * @author Marine
	 */
	
	//----- panel général ----//
	JPanel panelGen = new JPanel();
	JButton btnDemarrerRegate = new JButton("Démarrer la régate");
	
	//---- panel parcours sur la gauche  en haut-----//
	JPanel panelGauche = new JPanel();
	JPanel panelParcours = new JPanel();
	JLabel titreParcours = new JLabel("PARCOURS");
	JTextField txtNumero = new JTextField("");
	JTextField txtDistance = new JTextField("");
	JLabel lNumero = new JLabel("Numero : ");
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
	JButton btnAjouterListe = new JButton ("Ajouter à la liste");
	
	
	//---- panel liste participant sur la droite---//
	
	JPanel panelListeParticipants = new JPanel();
	JLabel titreListe = new JLabel("LISTE DES PARTICIPANTS");
	JLabel lInfoParticipant = new JLabel("Infos participants : ");
	JLabel lListeInfoParticipant = new JLabel("222222222222222222222222222222222222222222"
			+ "\n"+"22222222222222");
	JButton btnSupprimer = new JButton("Supprimer");
	
	
	
	public FenInscription() {
		this.setTitle("Fenetre Inscription");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 480);
		this.setLocationRelativeTo(null);
		
		btnAjouterListe.setBounds(185, 351, 199, 23);
		btnAjouterListe.setBackground(new Color(0,74,124));
		btnDemarrerRegate.setBounds(185, 384, 199, 23);
		btnDemarrerRegate.setBackground(new Color(0,74,124));
		btnAjouterListe.setForeground(new Color(252,252,252));
		btnDemarrerRegate.setForeground(new Color(252,252,252));
		panelGauche.setBackground(new Color(207	,235,255));
		panelListeParticipants.setBackground(new Color(207,235,255));
		titreListe.setForeground(new Color(0,118,197));
		titreParcours.setHorizontalAlignment(SwingConstants.CENTER);
		titreParcours.setBounds(133, 23, 271, 34);
		titreParcours.setForeground(new Color(0,118,197));
		titreParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		titreParticipant.setBounds(133, 149, 271, 34);
		titreParticipant.setForeground(new Color(0,118,197));
		
		//---- panel general----//
		panelGen.setLayout(new GridLayout(1,2));
		panelGen.add(panelGauche);
		panelGen.add(panelListeParticipants);
		panelGauche.setLayout(null);

		panelGauche.add(titreParcours);
		JLabel label = new JLabel("");
		label.setBounds(271, 0, 271, 34);
		panelGauche .add(label);
		lNumero.setBounds(0, 57, 190, 34);
		lNumero.setHorizontalAlignment(SwingConstants.RIGHT);

		panelGauche.add(new JLabel(""));

		panelGauche.add(lNumero);
		txtNumero.setBounds(207, 64, 208, 20);
		panelGauche.add(txtNumero);
		lDistance.setBounds(0, 80, 190, 34);
		lDistance.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGauche.add(lDistance);
		txtDistance.setBounds(207, 87, 208, 20);
		panelGauche.add(txtDistance);
		JLabel label_1 = new JLabel("");
		label_1.setBounds(56, 102, 271, 34);
		panelGauche .add(label_1);
		JLabel label_2 = new JLabel("");
		label_2.setBounds(271, 102, 271, 34);
		panelGauche .add(label_2);
		panelGauche.add(titreParticipant);
		lNumeroVoilier.setBounds(0, 187, 190, 34);
		lNumeroVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		//--- panel participant ---//
		panelGauche.add(lNumeroVoilier);
		txtNumeroVoilier.setBounds(207, 194, 208, 20);
		panelGauche.add(txtNumeroVoilier);
		lNomVoilier.setBounds(0, 210, 190, 34);
		lNomVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGauche.add(lNomVoilier);
		txtNomVoilier.setBounds(207, 217, 208, 20);
		panelGauche.add(txtNomVoilier);
		lClasse.setBounds(0, 232, 190, 34);
		lClasse.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGauche.add(lClasse);
		txtClasse.setBounds(207, 239, 208, 20);
		panelGauche.add(txtClasse);
		lRating.setBounds(0, 255, 190, 34);
		lRating.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGauche.add(lRating);
		txtRating.setBounds(207, 262, 208, 20);
		panelGauche.add(txtRating);
		lNomSkipper.setBounds(0, 277, 190, 34);
		lNomSkipper.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGauche.add(lNomSkipper);
		txtNomSkipper.setBounds(207, 284, 208, 20);
		panelGauche.add(txtNomSkipper);
		
		
		
		
		panelGauche.add(btnAjouterListe);
		btnAjouterListe.addActionListener(this);
		JLabel label_4 = new JLabel("");
		label_4.setBounds(271, 340, 271, 34);
		panelGauche .add(label_4);
		
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
