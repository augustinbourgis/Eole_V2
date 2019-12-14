package Principale;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class FenInscription extends JFrame implements ActionListener {

	private ArrayList<Voilier> lesVoiliersInscrits = new ArrayList<Voilier>();
	
	int temp = 0;
	ArrayList<JLabel> lesLabels = new ArrayList<JLabel>();
	
	// ----- panel g�n�ral ----//
	// ----- panel g�n�ral ----//
	JPanel panelGen = new JPanel();
	JButton btnDemarrerRegate = new JButton("D�marrer la r�gate");

	// ---- panel parcours sur la gauche en haut-----//
	JPanel panelGauche = new JPanel();
	JPanel panelParcours = new JPanel();
	JLabel titreParcours = new JLabel("PARCOURS");
	JTextField txtNumero = new JTextField("");
	JTextField txtDistance = new JTextField("");
	JLabel lNumero = new JLabel("Nom : ");
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
	JButton btnAjouterListe = new JButton("Ajouter � la liste");

	// ---- panel liste participant sur la droite---//

	JPanel panelListeParticipants = new JPanel();
	public JLabel lblListeDesParticipants = new JLabel("LISTE DES PARTICIPANTS");


	public FenInscription() {

		this.setTitle("Fen�tre Inscription");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		btnAjouterListe.setBounds(185, 351, 199, 23);
		btnAjouterListe.setBackground(new Color(0, 74, 124));
		btnDemarrerRegate.setBounds(185, 384, 199, 23);
		btnDemarrerRegate.setBackground(new Color(0, 74, 124));
		btnAjouterListe.setForeground(new Color(252, 252, 252));
		btnDemarrerRegate.setForeground(new Color(252, 252, 252));
		
		panelGauche.setBackground(new Color(207, 235, 255));
		panelListeParticipants.setBackground(new Color(207, 235, 255));
		titreParcours.setHorizontalAlignment(SwingConstants.CENTER);
		titreParcours.setBounds(133, 23, 271, 34);
		titreParcours.setForeground(new Color(0, 118, 197));
		titreParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		titreParticipant.setBounds(133, 149, 271, 34);
		titreParticipant.setForeground(new Color(0, 118, 197));

		// ---- panel general----//
		panelGen.setLayout(new GridLayout(1, 2));
		panelGen.add(panelGauche);
		panelGen.add(panelListeParticipants);
		
		panelGauche.setLayout(null);
		panelGauche.add(titreParcours);

		JLabel label = new JLabel("");
		
		label.setBounds(271, 0, 271, 34);
		panelGauche.add(label);
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
		panelGauche.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(271, 102, 271, 34);
		panelGauche.add(label_2);
		panelGauche.add(titreParticipant);
		lNumeroVoilier.setBounds(0, 187, 190, 34);
		lNumeroVoilier.setHorizontalAlignment(SwingConstants.RIGHT);

		// --- panel participant ---//
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
		panelGauche.add(label_4);
		
		panelGauche.add(btnDemarrerRegate);
		btnDemarrerRegate.addActionListener(this);
		panelListeParticipants.setLayout(null);
		lblListeDesParticipants.setBounds(177, 22, 196, 13);
		lblListeDesParticipants.setForeground(new Color(0, 118, 197));
		
		panelListeParticipants.add(lblListeDesParticipants);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(new Color(0, 85, 142));
		btnSupprimer.setForeground(new Color (252, 252, 252));
		btnSupprimer.setBounds(395, 18, 105, 21);
		panelListeParticipants.add(btnSupprimer);
		
		JLabel lblInfosParticipant = new JLabel("Infos participant :");
		lblInfosParticipant.setBounds(33, 78, 122, 13);
		panelListeParticipants.add(lblInfosParticipant);
	


		this.getContentPane().add(panelGen, "Center");
		addLabelAjoutListe();
	}
	
	private void addLabelAjoutListe() {
		int x=0,y=0,d=0;
		for(int i=1;i<=20;i++){
			JLabel l = new JLabel();
			lesLabels.add(l);
			if(i<=10) {
				x=0;
				y=20;
			}else {
				d=-200;
				x=220;
			}
			l.setBounds(150+x,100+y*i+d,200,20);		
			panelListeParticipants.add(l);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAjouterListe) {
			if(temp==20) {
				JOptionPane.showMessageDialog(this, "Vous ne pouvez pas ajouter plus de 20 participants");
			}else {
				try {
					lesVoiliersInscrits.add(new Voilier(txtNomVoilier.getText(), Integer.valueOf(txtClasse.getText()), Integer.valueOf(txtNumeroVoilier.getText()), txtNomSkipper.getText()));
					JLabel l = lesLabels.get(temp);
					l.setText(txtNomVoilier.getText()+" / "+txtNomSkipper.getText());
					SwingUtilities.updateComponentTreeUI(this);
					temp++;
				}catch(NumberFormatException err) {
					JOptionPane.showMessageDialog(this, "Toutes les informations du participants n'ont pas �t� remplies");
				}
			}
		}else if(e.getSource()==btnDemarrerRegate) {
			try {
				new FenChrono(txtNumero.getText(),Integer.valueOf(txtDistance.getText()),lesVoiliersInscrits);
				this.dispose();
			}catch(Exception err) {
				err.printStackTrace();
				JOptionPane.showMessageDialog(this,"Toutes les informations de la regate n'ont pas �t� remplies");
			}
		}
	}

	public static void main(String[] args) {
		FenInscription fi = new FenInscription();
		fi.setVisible(true);
	}
}
