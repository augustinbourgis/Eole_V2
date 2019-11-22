package Principale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenChrono extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Variable
	 */
	public Timer t = new Timer(10, new Check());
	public int min = 0;
	public int sec = 0;
	public int ms = 0;
	public Regate regate;
	
	/*
	 * JFrame global element
	 */
	JButton btnStart = new JButton("Start");
	JButton btnStop = new JButton("Stop");
	JButton btnReset = new JButton("Reset");
	JLabel lblMin = new JLabel();
	JLabel lblSec = new JLabel();
	JLabel lblMs = new JLabel();
	JLabel lbl1 = new JLabel();
	JLabel lbl2 = new JLabel();
	
	public FenChrono() {
		setTitle("Course");
		setPreferredSize(new Dimension(1100, 730));
		JPanel panGen = new JPanel(new BorderLayout());
		JPanel panReg = new JPanel();
		lblMin.setText("00");
		lblMin.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblSec.setText("00");
		lblSec.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblMs.setText("00");
		lblMs.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lbl1.setText(":");
		lbl1.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lbl2.setText(":");
		lbl2.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		JPanel pan1Chrono = new JPanel(new GridLayout(2, 1));
		JPanel pan2Chrono = new JPanel();
		JPanel pan3Chrono = new JPanel();
		JPanel Chrono = new JPanel();
		btnStart.setPreferredSize(new Dimension(100, 35));
		btnStop.setPreferredSize(new Dimension(100, 35));
		btnReset.setPreferredSize(new Dimension(100, 35));
		pan2Chrono.add(lblMin);
		pan2Chrono.add(lbl1);
		pan2Chrono.add(lblSec);
		pan2Chrono.add(lbl2);
		pan2Chrono.add(lblMs);
		
		pan3Chrono.add(btnStart);
		pan3Chrono.add(btnStop);
		pan3Chrono.add(btnReset);
		
		pan1Chrono.add(pan2Chrono);
		pan1Chrono.add(pan3Chrono);
		
		pan1Chrono.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		Chrono.add(pan1Chrono);
		panGen.add(Chrono, BorderLayout.NORTH);
		
		for(int i = 1; i <= 20; i++) {
			JPanel b = new JPanel();
			JLabel lblNom = new JLabel("Voilier DE FRED");
			lblNom.setPreferredSize(new Dimension(250, 35));
			lblNom.setFont(new Font("Lucida Gande", Font.PLAIN, 20));
			JButton btnArrivee = new JButton("Arrivée");
			JButton btnAbandon = new JButton("Abandon");
			JLabel espaceG = new JLabel();
			JLabel espaceD = new JLabel();
			espaceD.setPreferredSize(new Dimension(35, 20));
			espaceG.setPreferredSize(new Dimension(35, 20));
			btnArrivee.addActionListener(this);
			btnAbandon.addActionListener(this);
			
			b.add(espaceG);
			b.add(lblNom);
			b.add(btnArrivee);
			b.add(btnAbandon);
			b.add(espaceD);
			panReg.add(b);
		}
		
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		btnReset.addActionListener(this);
		panGen.add(panReg);
		getContentPane().add(panGen);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnStart) {
			t.start();
		}
		if(e.getSource() == btnStop) {
			t.stop();
		}
		if(e.getSource() == btnReset) {
			int n = JOptionPane.showConfirmDialog(this, "Voulez - vous redémarer le Chrono ?", "Reset ?", JOptionPane.YES_NO_OPTION);
			if(n != 1) {
				t.stop();
				min = 0;
		        sec = 0;
		        ms = 0;
		        lblMin.setText("00");
		        lblMs.setText("00");
		        lblSec.setText("00");
			}
		}
	}
	
	class Check implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ms += 1;
            if (ms == 100) {
                sec += 1;
                ms = 0;
            }
            if (sec == 60) {
                min += 1;
                sec = 0;
            }
            if (ms < 10) {
                lblMs.setText("0" + ms);
            } else {
                lblMs.setText(String.valueOf(ms));
            }
            if (sec < 10) {
                lblSec.setText("0" + sec);
            } else {
                lblSec.setText(String.valueOf(sec));
            }
            if (min < 10) {
                lblMin.setText("0" + min);
            } else {
                lblMin.setText(String.valueOf(min));
            }
		}
	}
	
	public static void main(String[] args) {
		FenChrono f77 = new FenChrono();
		f77.setVisible(true);
	}

}
