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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description : Initialisation composant JFrame
	 * @author Laura SCHAEFERT & Alice CHEREL
	 */
	public FenAccueil() {
		this.setTitle("Régate Eole");
		getContentPane().setLayout(null);
		//dimensions de la fenetre
		this.setBounds(0,0, 900, 480);
		//fenetre au centre
		this.setLocationRelativeTo(null);
		//non redimensionable
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel Fen = new JPanel();
		Fen.setPreferredSize(new Dimension(100,20));
		
<<<<<<< HEAD
		//Bouton Nouvelle rï¿½gate
		JButton btnNouvelleRgate = new JButton("Nouvelle Régate");
=======
		//Bouton Nouvelle regate
		JButton btnNouvelleRgate = new JButton("Nouvelle Rï¿½gate");
>>>>>>> branch 'master' of https://github.com/augustinbourgis/Eole_V2.git
		btnNouvelleRgate.setBounds(347, 334, 165, 60);
		getContentPane().add(btnNouvelleRgate);
		btnNouvelleRgate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenInscription fI = new FenInscription();
				fI.setVisible(true);
				btnNouvelleRgate.setEnabled(false);
				btnNouvelleRgate.setText("Regate en cours...");
			}
		});
		
		//Logo
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FenAccueil.class.getResource("/Other/Maquette/petitlogo.PNG")));
		lblNewLabel_1.setBounds(10, 11, 231, 96);
		getContentPane().add(lblNewLabel_1);
		
		//Image de fond
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-117, 10, 1114, 480);
		lblNewLabel.setIcon(new ImageIcon(FenAccueil.class.getResource("/Other/Maquette/regate-voiliers.jpg")));
		getContentPane().add(lblNewLabel);
	}
	
	public static void main(String[] args) {
		FenAccueil fenetre = new FenAccueil();
		fenetre.setVisible(true);
	}
	
}