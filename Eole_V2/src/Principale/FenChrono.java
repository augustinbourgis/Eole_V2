package Principale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Description : Windows of the race
 * @author : Thomas DURST
 * @version : 3.0
 * @see Class Regate
 */

public class FenChrono extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Variable of the class regate
	 */
	String nom;
	int distance;
	ArrayList<Voilier> lesParticipants;
	Regate laRegate;
	
	/**
	 * Variable of the timer
	 * @see Check()
	 */
	public Timer t = new Timer(10, new Check());
	private int h = 0;
	public int min = 0;
	public int sec = 0;
	public int arrive;
	
	/**
	 * Variable of the icon to the JButton Undo
	 */
	URL urlImage = getClass().getResource("/Other/Maquette/undo.png");
	Icon icone = new ImageIcon(new ImageIcon(urlImage).getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT));
	
	
	/**
	 * JFrame global element
	 */
	JPanel panReg = new JPanel();
	JPanel pan3Chrono = new JPanel();
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
	 * Arraylist des voiliers qui ont abandonné
	 */
	ArrayList<Voilier> ArrAbandon = new ArrayList<Voilier>();
	
	/**
	 * Description : Fen Chrono Initialisation composant
	 * @author Thomas DURST
	 * @see recupTemps()
	 * @see btnBoucle()
	 */
	public FenChrono(String nom, int distance, ArrayList<Voilier> participants) {
		this.nom = nom;
		this.distance = distance;
		this.lesParticipants = participants;
		laRegate = new Regate(nom, lesParticipants.size() , distance);
		arrive = lesParticipants.size();
		setTitle("Course");
		setPreferredSize(new Dimension(1100, 730));
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int)dimension.getWidth(), (int)dimension.getHeight()));
		setResizable(false);
		JPanel panGen = new JPanel(new BorderLayout());
		btnClassement.setPreferredSize(new Dimension(200, 35));
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
		btnBoucle();
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		btnReset.addActionListener(this);
		btnClassement.addActionListener(this);
		panGen.add(panReg);
		getContentPane().add(panGen);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		this.setVisible(true);
	}
	
	/**
	 * Description : Action of the button Start, Stop and Reset
	 * @author Thomas DURST
	 * @see btnBoucle()
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Action du btnStart
		if(e.getSource() == btnStart) {
			t.start();
		}
		// Action du btnStop
		if(e.getSource() == btnStop) {
			t.stop();
		}
		// Action du btnReset
		if(e.getSource() == btnReset) {
			// Demande confirmation du redémarage
			int validation = JOptionPane.showConfirmDialog(this, "Voulez - vous red�marer le Chrono ?", "Reset ?", JOptionPane.YES_NO_OPTION);
			// Si la confirmation est oui alors validation != 1
			if(validation != 1) {
				// Arret du chrono et remise à 0 du chrono visuel
				t.stop();
				min = 0;
		        sec = 0;
		        h = 0;
		        lblMin.setText("00");
		        lblh.setText("00");
		        lblSec.setText("00");
		        // Reset toute les Voiliers --> Suppresion puis rajout des panels
		        pan3Chrono.removeAll();
		        pan3Chrono.add(btnStart);
		        pan3Chrono.add(btnStop);
		        pan3Chrono.add(btnReset);
		        arrive = lesParticipants.size();
		        btnBoucle();
		        // Actualisation de la frame
		        this.revalidate();
			}
		}
		// Action du btnClassement
		if(e.getSource() == btnClassement) {
			// Ajoute les voiliers qui ont abandonné à la fin du classement 
			for(Voilier v : ArrAbandon) {
				laRegate.classementGene.add(v);
				if(v.getClasse() == 1) {
					laRegate.classementClasse1.add(v);
				} else {
					laRegate.classementClasse2.add(v);
				}
			}
			// Ouvre la fenetre FenChoixClassement et ferme la fenChrono
			FenChoixClassement Fcc = new FenChoixClassement(laRegate);
			Fcc.setVisible(true);
			this.setVisible(false);
			this.dispose();
		}
	}
	
	/**
	 * Description : Class for the time to add a sec on the windows label
	 * @author Thomas DURST
	 * @see btnClassAffichage()
	 */
	class Check implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// Permet d'ajouter les secondes au chrono quand il démarre et quand il reste enclancher
			sec += 1;
            if (sec == 60) {
                min += 1;
                sec = 0;
            }
            if (min == 60) {
                h += 1;
                min = 0;
            }
            // Intègre au label de la JFrame la valeur du timer
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
            // Si les voiliers sont arrivés alors stop le chrono et affiche le btnClassement
            if(arrive == 0) {
            	btnClassAffichage();
    			t.stop();
    			btnClassement.setEnabled(true);
    		}
		}
	}
	
	/**
	 * Description : return the time of the race for show on the label in the window
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
	/**
	 * Description : Permet d'inisialiser les voiliers dans le chrono
	 * @author Thomas DURST
	 */
	public void btnBoucle() {
		panReg.removeAll();
		int indiceVoilier = 1;
		for(Voilier p : lesParticipants) {
			JPanel b = new JPanel();
			JButton btnundo = new JButton(icone);
			b.setBackground(new Color(207, 235, 255));
			JLabel lblNom = new JLabel(indiceVoilier + " | " + p.getNom());
			lblNom.setPreferredSize(new Dimension(250, 35));
			lblNom.setFont(new Font("Lucida Gande", Font.PLAIN, 20));
			JButton btnArrivee = new JButton("Arriv�e");
			JButton btnAbandon = new JButton("Abandon");
			JLabel espaceG = new JLabel();
			JLabel espaceD = new JLabel();
			JLabel tempsJLabel = new JLabel();
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
					if(t.isRunning()) {
						String tempsHMS = "";
						int tempsSec = 0;
						btnundo.setPreferredSize(new Dimension(20, 20));
						tempsJLabel.setPreferredSize(new Dimension(170, 20));
						tempsJLabel.setFont(new Font("Lucida Gande", Font.BOLD, 20));
						tempsJLabel.setForeground(new Color(0, 128, 0));
						b.remove(btnAbandon);
						b.remove(btnArrivee);
						b.remove(espaceD);
						b.add(btnundo);
						b.add(tempsJLabel);
						b.add(espaceD);
						tempsHMS = recupTemps();
						tempsJLabel.setText(tempsHMS);
						b.revalidate();
						arrive--;
						tempsSec = getTempsReelSec(tempsHMS.substring(0,2), tempsHMS.substring(5,7), tempsHMS.substring(10));
						p.setTempsReel(tempsSec);
						laRegate.classementGene.add(p);
						if(p.getClasse() == 1) {
							laRegate.classementClasse1.add(p);
						} else {
							laRegate.classementClasse2.add(p);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Action impossible le chrono n'est pas démarré", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
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
					String tempsHMS = "00 : 00 : 00";
					int tempsSec = 0;
					btnundo.setPreferredSize(new Dimension(20, 20));
					tempsJLabel.setPreferredSize(new Dimension(170, 20));
					tempsJLabel.setFont(new Font("Lucida Gande", Font.BOLD, 20));
					tempsJLabel.setForeground(Color.RED);
					b.remove(btnAbandon);
					b.remove(btnArrivee);
					b.remove(espaceD);
					b.add(btnundo);
					b.add(tempsJLabel);
					b.add(espaceD);
					tempsJLabel.setText(tempsHMS);
					b.revalidate();
					arrive--;
					tempsSec = getTempsReelSec(tempsHMS.substring(0,2), tempsHMS.substring(5,7), tempsHMS.substring(10));
					p.setTempsReel(tempsSec);
					p.abandon();
					ArrAbandon.add(p);
				}
			});
			btnundo.addActionListener(new ActionListener() {
				/**
				 * Description : Action perform of JButton for the member of the race
				 * @author Thomas DURST
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					b.remove(btnundo);
					b.remove(tempsJLabel);
					b.remove(espaceD);
					b.add(btnArrivee);
					b.add(btnAbandon);
					b.add(espaceD);
					b.revalidate();
					arrive++;
				}
			});
			
			b.add(espaceG);
			b.add(lblNom);
			b.add(btnArrivee);
			b.add(btnAbandon);
			b.add(espaceD);
			panReg.add(b);
			indiceVoilier++;
		}
	}
	
	/**
	 * Description : Return the time of the Voilier in Sec
	 * @author Thomas DURST
	 * @param Heure
	 * @param Min
	 * @param Sec
	 * @return tempsReelSec
	 */
	public int getTempsReelSec(String Heure, String Min, String Sec) {
		int tempsReelSec = 0;
		tempsReelSec += Integer.parseInt(Heure) * 3600; 
		tempsReelSec += Integer.parseInt(Min) * 60;
		tempsReelSec += Integer.parseInt(Sec);
		return tempsReelSec;
	}
	
	
	/**
	 * Desciption : Affiche le boutton dans en dessous du chrono
	 * @author Thomas DURST
	 */
	public void btnClassAffichage() {
		pan3Chrono.removeAll();
		pan3Chrono.add(btnClassement);
		pan3Chrono.add(btnReset);
		this.revalidate();
	}
<<<<<<< HEAD
=======
	
	public static void main(String[] args) {
		//FenChrono f77 = new FenChrono("etst", 14, 2500);
		//f77.setVisible(true);
		ArrayList<Voilier> v = new ArrayList<Voilier>();
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Laura", 1, 1, "gol"));
		v.add(new Voilier("Marine", 1, 1, "bol"));
		v.add(new Voilier("Alice", 1, 1, "gorge"));
		v.add(new Voilier("Augustin", 1, 1, "laura"));
		v.add(new Voilier("Thomas", 1, 1, "gerard"));
		FenChrono f77 = new FenChrono("etst", 2500, v);
		f77.setVisible(true);
	}
>>>>>>> branch 'master' of https://github.com/augustinbourgis/Eole_V2.git
}