package Principale;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel;

/**
 * Description : accueil
 * @author : Alice CHEREL Laura SCHAEFER
 * @version 1.0
 */

public class FenAccueil extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public FenAccueil() {
		this.setTitle("Régate Eole");
		this.setBounds(0,0, 900, 480); //dimensions de la fenetre
		this.setLocationRelativeTo(null); //fenetre au centre
		this.setResizable(false);//non redimensionable
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		JPanel Fen = new JPanel();
		Fen.setPreferredSize(new Dimension(100,20));
		JButton btnNouvelleRgate = new JButton("Nouvelle Régate"); //Bouton Nouvelle regate
		getContentPane().add(btnNouvelleRgate);
		btnNouvelleRgate.setBounds(347, 334, 165, 60);
		btnNouvelleRgate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenInscription fI = new FenInscription();
				fI.setVisible(true);
				btnNouvelleRgate.setEnabled(false);
				btnNouvelleRgate.setText("Regate en cours...");
			}
		});
		JLabel lblNewLabel_1 = new JLabel(""); //JLabel qui sert de Logo
		lblNewLabel_1.setIcon(new ImageIcon(FenAccueil.class.getResource("/Other/Maquette/petitlogo.PNG")));
		lblNewLabel_1.setBounds(10, 11, 231, 96);
		getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel = new JLabel("New label"); //JLabel qui sert d'image de fond
		lblNewLabel.setBounds(-117, 10, 1114, 480);
		lblNewLabel.setIcon(new ImageIcon(FenAccueil.class.getResource("/Other/Maquette/regate-voiliers.jpg")));
		getContentPane().add(lblNewLabel);
	}
	
	public static void main(String[] args) {
		FenAccueil fenetre = new FenAccueil();
		fenetre.setVisible(true);
	}
	
}