package Principale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Description : Windows of the race
 * @author : Thomas DURST
 * @version : 2.0
 * @see Class Regate
 */

public class FenChrono extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Variable of the timer
	 * @see Check()
	 */
	public Timer t = new Timer(10, new Check());
	private int h = 0;
	public int min = 0;
	public int sec = 0;
	public int arrive = 20;
	
	/**
	 * JFrame global element
	 */
	JButton btnStart = new JButton("Start");
	JButton btnStop = new JButton("Stop");
	JButton btnReset = new JButton("Reset");
	JButton btnClassement = new JButton("Classement");
	JLabel lblMin = new JLabel();
	JLabel lblSec = new JLabel();
	JLabel lblh = new JLabel();
	JLabel lbl1 = new JLabel();
	JLabel lbl2 = new JLabel();
	
	
	/**
	 * Description : Fen Chrono Initialisation composant
	 * @author Thomas DURST
	 * @see recupTemps()
	 */
	public FenChrono() {
		setTitle("Course");
		setPreferredSize(new Dimension(1100, 730));
		JPanel panGen = new JPanel(new BorderLayout());
		JPanel panReg = new JPanel();
		btnClassement.setPreferredSize(new Dimension(200, 50));
		btnClassement.setVisible(false);
		btnClassement.setEnabled(false);
		panReg.setBackground(new Color(207, 235, 255));
		lblh.setText("00");
		lblh.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblMin.setText("00");
		lblMin.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblSec.setText("00");
		lblSec.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lbl1.setText(":");
		lbl1.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lbl2.setText(":");
		lbl2.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		JPanel pan1Chrono = new JPanel(new GridLayout(2, 1));
		JPanel pan2Chrono = new JPanel();
		pan2Chrono.setBackground(new Color(207, 235, 255));
		JPanel pan3Chrono = new JPanel();
		pan3Chrono.setBackground(new Color(207, 235, 255));
		JPanel Chrono = new JPanel();
		Chrono.setBackground(new Color(207, 235, 255));
		btnStart.setPreferredSize(new Dimension(100, 35));
		btnStop.setPreferredSize(new Dimension(100, 35));
		btnReset.setPreferredSize(new Dimension(100, 35));
		pan2Chrono.add(lblh);
		pan2Chrono.add(lbl2);
		pan2Chrono.add(lblMin);
		pan2Chrono.add(lbl1);
		pan2Chrono.add(lblSec);

		pan3Chrono.add(btnStart);
		pan3Chrono.add(btnStop);
		pan3Chrono.add(btnReset);
		
		pan1Chrono.add(pan2Chrono);
		pan1Chrono.add(pan3Chrono);
		
		Chrono.add(pan1Chrono);
		panGen.add(Chrono, BorderLayout.NORTH);
		
		for(int i = 1; i <= 20; i++) {
			JPanel b = new JPanel();
			b.setBackground(new Color(207, 235, 255));
			JLabel lblNom = new JLabel("Voilier DE FRED");
			lblNom.setPreferredSize(new Dimension(250, 35));
			lblNom.setFont(new Font("Lucida Gande", Font.PLAIN, 20));
			JButton btnArrivee = new JButton("Arrivée");
			JButton btnAbandon = new JButton("Abandon");
			JLabel espaceG = new JLabel();
			JLabel espaceD = new JLabel();
			espaceD.setPreferredSize(new Dimension(35, 20));
			espaceG.setPreferredSize(new Dimension(35, 20));
			btnArrivee.addActionListener(new ActionListener() {
				/**
				 * Description : Action perform of JButton for the member of the race
				 * @author Thomas DURST
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JLabel tempsJLabel = new JLabel();
					tempsJLabel.setPreferredSize(new Dimension(177, 20));
					tempsJLabel.setFont(new Font("Lucida Gande", Font.BOLD, 20));
					tempsJLabel.setForeground(new Color(0, 128, 0));
					btnAbandon.setEnabled(false);
					btnArrivee.setEnabled(false);
					b.remove(btnAbandon);
					b.remove(btnArrivee);
					b.add(tempsJLabel);
					tempsJLabel.setText(recupTemps());
					b.revalidate();
					arrive--;
				}
			});
			btnAbandon.addActionListener(new ActionListener() {
				/**
				 * Description : Action perform of JButton for the member of the race
				 * @author Thomas DURST
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JLabel tempsJLabel = new JLabel();
					tempsJLabel.setPreferredSize(new Dimension(177, 20));
					tempsJLabel.setFont(new Font("Lucida Gande", Font.BOLD, 20));
					tempsJLabel.setForeground(Color.RED);
					btnAbandon.setEnabled(false);
					btnArrivee.setEnabled(false);
					b.remove(btnAbandon);
					b.remove(btnArrivee);
					b.add(tempsJLabel);
					tempsJLabel.setText("00 : 00 : 00");
					b.revalidate();
					btnAbandon.setEnabled(false);
					btnArrivee.setEnabled(false);
					arrive--;
				}
			});
			
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
		panReg.add(btnClassement);
		panGen.add(panReg);
		getContentPane().add(panGen);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	
	/**
	 * Description : Action of the button Start, Stop and Reset
	 * @author Thomas DURST
	 */
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
		        h = 0;
		        lblMin.setText("00");
		        lblh.setText("00");
		        lblSec.setText("00");
			}
		}
	}
	
	/**
	 * Description : Class for the time to add a sec on the windows label
	 * @author Thomas DURST
	 */
	class Check implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			sec += 1;
            if (sec == 60) {
                min += 1;
                sec = 0;
            }
            if (min == 60) {
                h += 1;
                min = 0;
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
            if (h < 10) {
                lblh.setText("0" + h);
            } else {
                lblh.setText(String.valueOf(h));
            }
            if(arrive == 0) {
    			t.stop();
    			btnClassement.setVisible(true);
    			btnClassement.setEnabled(true);
    		}
		}
	}
	
	/**
	 * Description : return the time of the time for show on the label in the window
	 * @author Thomas DURST
	 * @return String
	 */
	public String recupTemps() {
		String minS = "";
		String secS = "";
		String hS = "";
        if (sec < 10) {
            secS = "0" + sec;
        } else {
            secS = Integer.toString(sec);
        }
        if (min < 10) {
            minS = "0" + min;
        } else {
            minS = Integer.toString(min);
        }
        if (h < 10) {
            hS = "0" + h;
        } else {
            hS = Integer.toString(h);
        }
		return hS + " : " + minS + " : " + secS;
	}
	
	public static void main(String[] args) {
		FenChrono f77 = new FenChrono();
		f77.setVisible(true);
	}
}