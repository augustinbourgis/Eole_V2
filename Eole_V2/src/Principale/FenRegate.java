package Principale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FenRegate extends JFrame implements ActionListener{
	
	private Regate regate; // La regate
	private Chrono leChrono;
	private JPanel panGeneral = new JPanel();
	private JButton bAjoutParticipant = new JButton("Rentrer un participant");
	
	public FenRegate(String nom,int nbParticipants, int distance) {
		regate = new Regate(nom,nbParticipants,distance);
		this.setTitle("Regate : "+nom);
		this.setLocation(500, 125);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
	}

	
	public void actionPerformed(ActionEvent e) {
		
	}

}
