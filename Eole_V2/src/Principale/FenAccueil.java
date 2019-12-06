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
	
	JPanel Fen = new JPanel();
	JButton btnNouvelleRgate = new JButton("Nouvelle Regate");
	JLabel lblLogo = new JLabel(""); //JLabel qui sert de Logo
	JLabel lblFond = new JLabel("New label"); //JLabel qui sert d'image de fond
	
	public FenAccueil() {
		this.setTitle("Regate Eole");
		this.setBounds(0,0, 900, 480); //dimensions de la fenetre
		this.setLocationRelativeTo(null); //fenetre au centre
		this.setResizable(false);//non redimensionable
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		Fen.setPreferredSize(new Dimension(100,20));
		
		getContentPane().add(btnNouvelleRgate);
		btnNouvelleRgate.setForeground(new Color(41,33,104));
		btnNouvelleRgate.setBackground(new Color(252,252,252));
		btnNouvelleRgate.setBounds(347, 334, 165, 60);
		btnNouvelleRgate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenInscription fI = new FenInscription();
				fI.setVisible(true);
				btnNouvelleRgate.setEnabled(false);
				btnNouvelleRgate.setText("Regate en cours...");
			}
		});
		
		lblLogo.setIcon(new ImageIcon(FenAccueil.class.getResource("/Other/Maquette/petitlogo.PNG")));
		lblLogo.setBounds(10, 11, 231, 96);
		getContentPane().add(lblLogo);
	
		lblFond.setIcon(new ImageIcon(FenAccueil.class.getResource("/Other/Maquette/regate-voiliers.jpg")));
		lblFond.setBounds(-117, 10, 1114, 480);
		getContentPane().add(lblFond);
	}
	
	public static void main(String[] args) {
		FenAccueil fenetre = new FenAccueil();
		fenetre.setVisible(true);
	}
	
}