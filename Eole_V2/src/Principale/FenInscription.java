package Principale;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Description : fenêtre inscription
 * @author : Marine CHRISTOPHE
 * @version 1.0
 */

public class FenInscription extends JFrame implements ActionListener {

	private ArrayList<Voilier> lesVoiliersInscrits = new ArrayList<Voilier>();
	
	/**
	 * Variables
	 */
	
	//Nombre d'inscrits
	int temp = 0;
	ArrayList<JLabel> lesLabels = new ArrayList<JLabel>();
	
	/**
	 * JFrame global elements
	 * @author Marine
	 */
	
	// ----- panel general ----//
	JPanel panelGen = new JPanel();
	JButton btnDemarrerRegate = new JButton("Demarrer la regate");
	
	// ---- panel de gauche ---- //
	JPanel panelGauche = new JPanel();
	
	// ---- panel parcours (sur la gauche en haut) -----//
	JPanel panelParcours = new JPanel();
	
	JLabel lTitreParcours = new JLabel("PARCOURS");
	JLabel lNomRegate = new JLabel("Nom : ");
	JLabel lDistance = new JLabel("Distance (en miles) : ");
	
	JTextField txtNomRegate = new JTextField("");
	JTextField txtDistance = new JTextField("");

	// ---- panel participant (sur la gauche en bas) ---//
	JPanel panelParticipants = new JPanel();
	
	JLabel lTitreParticipant = new JLabel("PARTICIPANTS");
	
	JLabel lNumeroVoilier = new JLabel("Numero du voilier : ");
	JLabel lNomVoilier = new JLabel("Nom du voilier : ");
	JLabel lClasse = new JLabel("Classe : ");
	JLabel lRating = new JLabel("Rating : ");
	JLabel lNomSkipper = new JLabel("Nom du skipper : ");
	
	JTextField txtNumeroVoilier = new JTextField("");
	JTextField txtNomVoilier = new JTextField("");
	JTextField txtClasse = new JTextField("");
	JTextField txtRating = new JTextField("");
	JTextField txtNomSkipper = new JTextField("");
	
	JButton btnAjouterListe = new JButton("Ajouter à la liste");

	// ---- panel liste participant sur la droite---//
	JPanel panelListeParticipants = new JPanel();
	JLabel lblListeDesParticipants = new JLabel("LISTE DES PARTICIPANTS");
	JButton btnSupprimer = new JButton("Supprimer");
	JList list= new JList();
	DefaultListModel modele = new DefaultListModel();
	
	/**
	 * Description : constructeur fenêtre
	 * @author Marine & Laura
	 */
	public FenInscription() {

		this.setTitle("Fenetre Inscription");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// ---- panel general----//
		panelGen.setLayout(new GridLayout(1, 2));
		panelGen.add(panelGauche);
		panelGen.add(panelListeParticipants);
		
		
		// ----- panel gauche ---- //
		panelGauche.setLayout(null);
		panelGauche.setBackground(new Color(207, 235, 255));
		
			// ---- parcours ---- //
		panelGauche.add(lTitreParcours);
		
		panelGauche.add(lNomRegate);
		panelGauche.add(txtNomRegate);
		panelGauche.add(lDistance);
		panelGauche.add(txtDistance);
		
				// ---- style des éléments ---- //
		lTitreParcours.setHorizontalAlignment(SwingConstants.CENTER);
		lTitreParcours.setBounds(133, 23, 271, 34);
		lTitreParcours.setForeground(new Color(0, 118, 197));
		
		lNomRegate.setBounds(0, 57, 190, 34);
		lNomRegate.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNomRegate.setBounds(207, 64, 208, 20);
		
		lDistance.setBounds(0, 80, 190, 34);
		lDistance.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtDistance.setBounds(207, 87, 208, 20);
		
			// ---- Participants --- //
		panelGauche.add(lTitreParticipant);
		
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
		
				// ---- style des éléments ---- //		
		lTitreParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		lTitreParticipant.setBounds(133, 149, 271, 34);
		lTitreParticipant.setForeground(new Color(0, 118, 197));
		
		lNumeroVoilier.setBounds(0, 187, 190, 34);
		lNumeroVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNumeroVoilier.setBounds(207, 194, 208, 20);
		
		lNomVoilier.setBounds(0, 210, 190, 34);
		lNomVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNomVoilier.setBounds(207, 217, 208, 20);
		
		lClasse.setBounds(0, 232, 190, 34);
		lClasse.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtClasse.setBounds(207, 239, 208, 20);
		
		lRating.setBounds(0, 255, 190, 34);
		lRating.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtRating.setBounds(207, 262, 208, 20);
		
		lNomSkipper.setBounds(0, 277, 190, 34);
		lNomSkipper.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNomSkipper.setBounds(207, 284, 208, 20);
		
			// ---- Boutons ---- //
		panelGauche.add(btnAjouterListe);
		panelGauche.add(btnDemarrerRegate);
		
		btnAjouterListe.addActionListener(this);
		btnDemarrerRegate.addActionListener(this);
		
		btnAjouterListe.setBounds(185, 351, 199, 23);
		btnAjouterListe.setBackground(new Color(0, 74, 124));
		btnAjouterListe.setForeground(new Color(252, 252, 252));
		
		btnDemarrerRegate.setBounds(185, 384, 199, 23);
		btnDemarrerRegate.setBackground(new Color(0, 74, 124));
		btnDemarrerRegate.setForeground(new Color(252, 252, 252));
		
		// ---- panel droit ---- //
		panelListeParticipants.setLayout(null);
		panelListeParticipants.setBackground(new Color(207, 235, 255));
		
		panelListeParticipants.add(lblListeDesParticipants);
		panelListeParticipants.add(btnSupprimer);
		panelListeParticipants.add(list);
		
		lblListeDesParticipants.setBounds(177, 22, 196, 13);
		lblListeDesParticipants.setForeground(new Color(0, 118, 197));
		
		btnSupprimer.setPreferredSize(new Dimension(250, 35));
		btnSupprimer.setBackground(new Color(0, 85, 142));
		btnSupprimer.setForeground(new Color (252, 252, 252));
		btnSupprimer.setBounds(395, 18, 105, 21);
		btnSupprimer.addActionListener(this);
		
		list.setBounds(108, 62, 333, 378);
		list.setBackground(new Color(207, 235, 255));
	
		this.getContentPane().add(panelGen, "Center");
//		addLabelAjoutListe();
	}
	
//	private void addLabelAjoutListe() {
//		int x=0,y=0,d=0;
//		for(int i=1;i<=20;i++){
//			JLabel l = new JLabel();
//			lesLabels.add(l);
//			if(i<=10) {
//				x=0;
//				y=20;
//			}else {
//				d=-200;
//				x=220;
//			}
//			l.setBounds(150+x,100+y*i+d,200,20);		
//			panelListeParticipants.add(l);
//		}
//	}
	/**
	 * Description : Actions des boutons
	 * @author Laura & Marine & Augustin ?????????????????????????????????
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAjouterListe) {
			if(temp==20) {
				JOptionPane.showMessageDialog(this, "Vous ne pouvez pas ajouter plus de 20 participants");
			}else if(!txtClasse.getText().equals("1") && !txtClasse.getText().equals("2")) {
				JOptionPane.showMessageDialog(this, "La classe doit être égale à 1 ou 2");
			}else {
				try {
					lesVoiliersInscrits.add(new Voilier(txtNomVoilier.getText(), Integer.valueOf(txtClasse.getText()), Integer.valueOf(txtNumeroVoilier.getText()), txtNomSkipper.getText()));
					
					modele.addElement(txtNomVoilier.getText()+" / "+txtNomSkipper.getText());
					list.setModel(modele);
					
					SwingUtilities.updateComponentTreeUI(this);
					temp++;
				}catch(NumberFormatException err) {
					JOptionPane.showMessageDialog(this, "Toutes les informations du participants n'ont pas ete remplies");
				}
			}
		}else if(e.getSource()==btnDemarrerRegate) {
			try {
				new FenChrono(txtNomRegate.getText(),Integer.valueOf(txtDistance.getText()),lesVoiliersInscrits);
				this.dispose();
			}catch(Exception err) {
				err.printStackTrace();
				JOptionPane.showMessageDialog(this,"Toutes les informations de la regate n'ont pas ete remplies");
			}
		}
		else if(e.getSource()==btnSupprimer) {
			int index = list.getSelectedIndex();
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "Vous devez selectionner un participant pour le supprimer", "Information", JOptionPane.INFORMATION_MESSAGE);
			} else {
				modele.remove(index);
				list.revalidate();
				temp--;
			}
		}
	}

	public static void main(String[] args) {
		FenInscription fi = new FenInscription();
		fi.setVisible(true);
	}
}
