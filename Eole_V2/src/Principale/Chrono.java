package Principale;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.Timer;


/**
 * Description : Timer of the race
 * @author Thomas Durst
 * @version 1.0
 */

public class Chrono extends JFrame implements ActionListener {
	/*
	 * Variable
	 */
	public Timer t = new Timer(10, new Check());
	public int min = 0;
	public int sec = 0;
	public int ms = 0;
	
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
	
	/**
	 * @see initComp()
	 */
	public Chrono() {
		initComp();
	}
	
	/**
	 * Inialisation de la fenetre
	 * Chargement de tout les élements
	 */
	public void initComp() {
		this.setTitle("Chronomètre");
		this.setPreferredSize(new Dimension(400,150));
		
		lblMin.setText("00");
		lblMin.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblSec.setText("00");
		lblSec.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblMs.setText("00");
		lblMs.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lbl1.setText(":");
		lbl1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lbl2.setText(":");
		lbl2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		JPanel pan1 = new JPanel(new GridLayout(2, 1));
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		
		pan2.add(lblMin);
		pan2.add(lbl1);
		pan2.add(lblSec);
		pan2.add(lbl2);
		pan2.add(lblMs);
		
		pan3.add(btnStart);
		pan3.add(btnStop);
		pan3.add(btnReset);
		
		pan1.add(pan2);
		pan1.add(pan3);
		
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		btnReset.addActionListener(this);
		
		this.setContentPane(pan1);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		getContentPane().setLayout(null);
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chrono frame = new Chrono();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
