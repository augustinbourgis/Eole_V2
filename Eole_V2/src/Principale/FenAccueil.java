package Principale;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Description : fenêtre accueil
 * @author : Alice CHEREL Laura SCHAEFER
 * @version 1.0
 */

public class FenAccueil extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Description : variables de la classe FenAccueil
	 */
	JPanel Fen = new JPanel();
	static JButton btnNouvelleRgate = new JButton("Nouvelle Régate");
	//JLabel qui sert de Logo
	JLabel lblLogo = new JLabel(""); 
	//JLabel qui sert d'image de fond
	JLabel lblFond = new JLabel("New label"); 
	
	/**
	 * Description : constructeur fenêtre
	 * @author : Alice CHEREL Laura SCHAEFER
	 */
	public FenAccueil() {
		// Image Icon de la frame
		setIconImage(Toolkit.getDefaultToolkit().getImage(FenChrono.class.getResource("/Other/Maquette/planche.png")));
		this.setTitle("Régate Eole");
		//position de la fenêtre
		this.setBounds(0,0, 900, 480); 
		//fenetre au centre
		this.setLocationRelativeTo(null); 
		//non redimensionable
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		//dimensions de la fenêtre
		Fen.setPreferredSize(new Dimension(100,20));
		
		getContentPane().add(btnNouvelleRgate);
		//design du bouton
		btnNouvelleRgate.setForeground(new Color(41,33,104));
		btnNouvelleRgate.setBackground(new Color(252,252,252));
		btnNouvelleRgate.setBounds(347, 334, 165, 60);
		//action du bouton
		btnNouvelleRgate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenInscription fI = new FenInscription();
				fI.setVisible(true);
				//bloquer le bouton
				btnNouvelleRgate.setEnabled(false);
				//change le texte du bouton
				btnNouvelleRgate.setText("Régate en cours...");
			}
		});
		//logo de la régate
		lblLogo.setIcon(new ImageIcon(FenAccueil.class.getResource("/Other/Maquette/petitlogo.PNG")));
		lblLogo.setBounds(10, 11, 231, 96);
		getContentPane().add(lblLogo);
	
		//fond d'écran
		lblFond.setIcon(new ImageIcon(FenAccueil.class.getResource("/Other/Maquette/regate-voiliers.jpg")));
		lblFond.setBounds(-117, 10, 1114, 480);
		getContentPane().add(lblFond);
	}
	
}