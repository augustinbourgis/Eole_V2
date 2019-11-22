package Principale;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fen extends JFrame implements ActionListener{
	
	private int nbParticipant = 0;
	private int distance = 20;
	private String nom = "aucun nom";
	
	JPanel panCentral = new JPanel();
	JPanel panNORTH = new JPanel();
	JPanel panCENTER = new JPanel();
	JPanel panSOUTH = new JPanel();
	JButton bChangerNom = new JButton("Changer le nom");
	JButton bChangerDistance = new JButton("Changer la distance");
	JButton bCreerRegate = new JButton("Creer la regate : "+nom);
	JButton bChangerNbParticipant = new JButton("Changer nombre participant(s)");
	JLabel lDistance = new JLabel("Distance regate : " + distance + " mile(s)");
	JLabel lNom = new JLabel("Nom regate : " + nom);
	JLabel lParticipant = new JLabel("Nombre de participant : " + nbParticipant + " participant(s)");
	
	
	
	
//-------------------------- Constructeurs --------------------------//
	/**
	 * @author Augustin et Wizard
	 */
	public Fen() {
		this.setTitle("Configuration Regate");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 200);
		this.setLocation(0, 250);
		this.getContentPane().add(panCentral);
		panCentral.setLayout(new BorderLayout());
		configPanCentral();
		configComposants();
	}
	
	
//----------------------- Fin constructeurs -------------------------//
	
	
	
	
	
	
	
//-------------------------- M�thodes --------------------------//
	/**
	 * Configure le panCentral
	 */
	public void configPanCentral() {
		panCentral.add(panNORTH,BorderLayout.NORTH);
		panNORTH.setLayout(new BorderLayout());
		panCentral.add(panCENTER,BorderLayout.CENTER);
		panCENTER.setLayout(new GridLayout(3,1));
		panCentral.add(panSOUTH,BorderLayout.SOUTH);
		panSOUTH.setLayout(new BorderLayout());
	}
	
	
	
	/**
	 * Configure et ajoute les composants de la fenetre
	 */
	public void configComposants() {
		panNORTH.add(bChangerNom,BorderLayout.WEST);
		panNORTH.add(bChangerDistance,BorderLayout.CENTER);
		panNORTH.add(bChangerNbParticipant,BorderLayout.EAST);
		panSOUTH.add(bCreerRegate);
		bChangerNom.addActionListener(this);
		bChangerDistance.addActionListener(this);
		bChangerNbParticipant.addActionListener(this);
		panCENTER.add(lNom);
		panCENTER.add(lDistance);
		panCENTER.add(lParticipant);
		bCreerRegate.addActionListener(this);
	}

//------------------------- Fin m�thodes -----------------------//

	
	
	
	
	
//-------------------------- Main --------------------------//
	/**
	 * @param args
	 * @author Augustin et Wizard 
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fen f1 = new Fen();
				f1.setVisible(true);
			}
		});
	}
//---------------------- Fin Main ---------------------------//

	

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==bChangerDistance) {
		try {
			distance = Integer.valueOf(JOptionPane.showInputDialog(null, "Entrez la distance de la Regate : "));
			lDistance.setText("Distance regate : " + distance + " mile(s)");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Veuillez entrer un NOMBRE");
		}
	}else if(e.getSource()==bChangerNom) {
		nom = JOptionPane.showInputDialog(null, "Entrez le nom voulu : ");
		bCreerRegate.setText("Creer la regate : "+nom);
		lNom.setText("Nom regate : " + nom);
	}else if(e.getSource()==bChangerNbParticipant) {
		try {
			nbParticipant = Integer.valueOf(JOptionPane.showInputDialog(null, "Entrez le nombre de participants : "));
			lParticipant.setText("Nombre de participant : " + nbParticipant + " participant(s)");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Veuillez entrer un NOMBRE");
		}
	}else if(e.getSource()==bCreerRegate) {
		if(nom.contentEquals("aucun nom")) {
			JOptionPane.showMessageDialog(null, "Veuillez entrer un nom pour la regate SVP");
		}else {
			FenRegate f = new FenRegate(nom,nbParticipant,distance);
			f.setVisible(true);
		}
	}
}
}


