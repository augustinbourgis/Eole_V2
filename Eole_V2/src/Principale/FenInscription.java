package Principale;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

/**
 * Description : fen�tre inscription
 * @author : Marine CHRISTOPHE
 * @version 1.0
 */

public class FenInscription extends JFrame implements ActionListener {

	private ArrayList<Voilier> lesVoiliersInscrits = new ArrayList<Voilier>();
	
	/**
	 * Variables
	 */
	
	//Nombre d'inscrits
	int temp = 0;
	ArrayList<JLabel> lesLabels = new ArrayList<JLabel>();
	
	/**
	 * JFrame global elements
	 * @author Marine
	 */
	// ---- Enregistemrent ----//
	final JFileChooser fc = new JFileChooser();
	
	// ---- JMenu Bar ----//
	JMenuItem save = new JMenuItem("Enregister");
	JMenuItem open = new JMenuItem("Ouvrir");
	
	// ----- panel g�n�ral ----//
	JPanel panelGen = new JPanel();
	JButton btnDemarrerRegate = new JButton("D�marrer la r�gate");
	
	// ---- panel de gauche ---- //
	JPanel panelGauche = new JPanel();
	
	// ---- panel parcours (sur la gauche en haut) -----//
	JPanel panelParcours = new JPanel();
	
	JLabel lTitreParcours = new JLabel("PARCOURS");
	JLabel lNomRegate = new JLabel("Nom : ");
	JLabel lDistance = new JLabel("Distance (en milles) : ");
	
	JTextField txtNomRegate = new JTextField("");
	JTextField txtDistance = new JTextField("");

	// ---- panel participant (sur la gauche en bas) ---//
	JPanel panelParticipants = new JPanel();
	
	JLabel lTitreParticipant = new JLabel("PARTICIPANTS");
	
	JLabel lNumeroVoilier = new JLabel("Num�ro du voilier : ");
	JLabel lNomVoilier = new JLabel("Nom du voilier : ");
	JLabel lClasse = new JLabel("Classe : ");
	JLabel lRating = new JLabel("Rating : ");
	JLabel lNomSkipper = new JLabel("Nom du skipper : ");
	
	JTextField txtNumeroVoilier = new JTextField("");
	JTextField txtNomVoilier = new JTextField("");
	JTextField txtClasse = new JTextField("");
	JTextField txtRating = new JTextField("");
	JTextField txtNomSkipper = new JTextField("");
	
	JButton btnAjouterListe = new JButton("Ajouter � la liste");

	// ---- panel liste participant sur la droite---//
	JPanel panelListeParticipants = new JPanel();
	JLabel lblListeDesParticipants = new JLabel("LISTE DES PARTICIPANTS");
	JButton btnSupprimer = new JButton("Supprimer");
	JList list= new JList();
	DefaultListModel modele = new DefaultListModel();
	
	/**
	 * Description : constructeur fen�tre
	 * @author Marine & Laura
	 */
	public FenInscription() {
		// Image Icon de la frame
		setIconImage(Toolkit.getDefaultToolkit().getImage(FenChrono.class.getResource("/Other/Maquette/planche.png")));
		this.setTitle("Fenetre Inscription");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(1100, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// ---- JMenu Bar ----//
		JMenuBar bar = new JMenuBar();
		JMenu fichier = new JMenu("Fichier");
		fichier.add(open);
		fichier.addSeparator();
		fichier.add(save);
		bar.add(fichier);
		setJMenuBar(bar);
		open.addActionListener(this);
		save.addActionListener(this);
		
		// ---- panel g�n�ral----//
		panelGen.setLayout(new GridLayout(1, 2));
		panelGen.add(panelGauche);
		panelGen.add(panelListeParticipants);
		
		
		// ----- panel gauche ---- //
		panelGauche.setLayout(null);
		panelGauche.setBackground(new Color(207, 235, 255));
		
			// ---- parcours ---- //
		panelGauche.add(lTitreParcours);
		
		panelGauche.add(lNomRegate);
		panelGauche.add(txtNomRegate);
		panelGauche.add(lDistance);
		panelGauche.add(txtDistance);
		
				// ---- style des �l�ments ---- //
		lTitreParcours.setHorizontalAlignment(SwingConstants.CENTER);
		lTitreParcours.setBounds(133, 23, 271, 34);
		lTitreParcours.setForeground(new Color(0, 118, 197));
		
		lNomRegate.setBounds(0, 57, 190, 34);
		lNomRegate.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNomRegate.setBounds(207, 64, 208, 20);
		
		lDistance.setBounds(0, 80, 190, 34);
		lDistance.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtDistance.setBounds(207, 87, 208, 20);
		
			// ---- Participants --- //
		panelGauche.add(lTitreParticipant);
		
		panelGauche.add(lNumeroVoilier);
		panelGauche.add(txtNumeroVoilier);
		panelGauche.add(lNomVoilier);
		panelGauche.add(txtNomVoilier);
		panelGauche.add(lNomSkipper);
		panelGauche.add(txtNomSkipper);
		panelGauche.add(lClasse);
		panelGauche.add(txtClasse);
		panelGauche.add(lRating);
		panelGauche.add(txtRating);

				// ---- style des �l�ments ---- //		
		lTitreParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		lTitreParticipant.setBounds(133, 149, 271, 34);
		lTitreParticipant.setForeground(new Color(0, 118, 197));
		
		lNumeroVoilier.setBounds(0, 187, 190, 34);
		lNumeroVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNumeroVoilier.setBounds(207, 194, 208, 20);
		
		lNomVoilier.setBounds(0, 210, 190, 34);
		lNomVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNomVoilier.setBounds(207, 217, 208, 20);
		
		lClasse.setBounds(0, 255, 190, 34);
		lClasse.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtClasse.setBounds(207, 262, 208, 20);
		
		lRating.setBounds(0, 277, 190, 34);
		lRating.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtRating.setBounds(207, 284, 208, 20);
		
		lNomSkipper.setBounds(0, 232, 190, 34);
		lNomSkipper.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNomSkipper.setBounds(207, 239, 208, 20);
		
			// ---- Boutons ---- //
		panelGauche.add(btnAjouterListe);
		panelGauche.add(btnDemarrerRegate);
		
		btnAjouterListe.addActionListener(this);
		btnDemarrerRegate.addActionListener(this);
		
		btnAjouterListe.setBounds(185, 351, 199, 23);
		btnAjouterListe.setBackground(new Color(0, 74, 124));
		btnAjouterListe.setForeground(new Color(252, 252, 252));
		
		btnDemarrerRegate.setBounds(185, 384, 199, 23);
		btnDemarrerRegate.setBackground(new Color(0, 74, 124));
		btnDemarrerRegate.setForeground(new Color(252, 252, 252));
		
		// ---- panel droit ---- //
		panelListeParticipants.setLayout(null);
		panelListeParticipants.setBackground(new Color(207, 235, 255));
		
		panelListeParticipants.add(lblListeDesParticipants);
		panelListeParticipants.add(btnSupprimer);
		panelListeParticipants.add(list);
		
		lblListeDesParticipants.setBounds(177, 22, 196, 13);
		lblListeDesParticipants.setForeground(new Color(0, 118, 197));
		
		btnSupprimer.setPreferredSize(new Dimension(250, 35));
		btnSupprimer.setBackground(new Color(0, 85, 142));
		btnSupprimer.setForeground(new Color (252, 252, 252));
		btnSupprimer.setBounds(395, 18, 105, 21);
		btnSupprimer.addActionListener(this);
		
		list.setBounds(108, 62, 392, 378);
		list.setBackground(new Color(207, 235, 255));
	
		this.getContentPane().add(panelGen, "Center");
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				 int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter l'application ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				 if(reponse == JOptionPane.YES_OPTION) {
					 int r2 = JOptionPane.showConfirmDialog(null, "Voulez-vous enregister les voiliers ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					 if(r2 == JOptionPane.YES_OPTION) {
						 save();
						 FenAccueil.btnNouvelleRgate.setEnabled(true);
						 FenAccueil.btnNouvelleRgate.setText("Nouvelle R�gate");
						 dispose();
					 } else {
						 FenAccueil.btnNouvelleRgate.setEnabled(true);
						 FenAccueil.btnNouvelleRgate.setText("Nouvelle R�gate");
						 dispose();
					 }
				 }
			}
		});
		
//		addLabelAjoutListe();
	}
	
//	private void addLabelAjoutListe() {
//		int x=0,y=0,d=0;
//		for(int i=1;i<=20;i++){
//			JLabel l = new JLabel();
//			lesLabels.add(l);
//			if(i<=10) {
//				x=0;
//				y=20;
//			}else {
//				d=-200;
//				x=220;
//			}
//			l.setBounds(150+x,100+y*i+d,200,20);		
//			panelListeParticipants.add(l);
//		}
//	}
	/**
	 * Description : Actions des boutons
	 * @author Laura & Augustin
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAjouterListe) {
			if(temp==20) {
				JOptionPane.showMessageDialog(this, "Vous ne pouvez pas ajouter plus de 20 participants");
			} else if(txtClasse.getText().equals("") || txtNomSkipper.getText().equals("") || txtNomVoilier.getText().equals("") || txtNumeroVoilier.getText().equals("") || txtRating.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Toutes les informations du participants n'ont pas ete remplies");
			} else if(!txtClasse.getText().equals("1") && !txtClasse.getText().equals("2")) {
				JOptionPane.showMessageDialog(this, "La classe doit �tre �gale � 1 ou 2");
			}else if(txtClasse.getText() != "" || txtNomSkipper.getText() != "" || txtNomVoilier.getText() != "" || txtNumeroVoilier.getText() != "" || txtRating.getText() != ""){
				try {	
					lesVoiliersInscrits.add(new Voilier(txtNomVoilier.getText(), Integer.valueOf(txtClasse.getText()), Integer.valueOf(txtRating.getText()), Integer.valueOf(txtNumeroVoilier.getText()), txtNomSkipper.getText()));
					modele.addElement("Nom voilier : " + txtNomVoilier.getText()+" | Skipper : "+txtNomSkipper.getText() +" | Classe : "+ txtClasse.getText()+ " | Rating : "+ txtRating.getText());
					list.setModel(modele);
					SwingUtilities.updateComponentTreeUI(this);
					temp++;
					txtClasse.setText("");
					txtNomSkipper.setText("");
					txtNomVoilier.setText("");
					txtRating.setText("");
					txtNumeroVoilier.setText("");
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Certaines valeurs entr�es ne sont pas en ad�quation avec le type de valeur demand�");
				}
			}
		}else if(e.getSource()==btnDemarrerRegate) {
			if(txtNomRegate.getText().equals("") || txtDistance.getText().equals("") || lesVoiliersInscrits.isEmpty()) {
				JOptionPane.showMessageDialog(this,"Toutes les informations de la r�gate n'ont pas �t� remplies");
			} else {
				FenChrono f = new FenChrono(txtNomRegate.getText(),Integer.valueOf(txtDistance.getText()),lesVoiliersInscrits);
				f.setVisible(true);
				this.dispose();
			}
		}
		else if(e.getSource()==btnSupprimer) {
			int index = list.getSelectedIndex();
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "Vous devez s�lectionner un participant pour le supprimer", "Information", JOptionPane.INFORMATION_MESSAGE);
			} else {
				modele.remove(index);
				lesVoiliersInscrits.remove(index);
				list.revalidate();
				temp--;
			}
		} else if(e.getSource() == save) {
			save();
		} else if(e.getSource() == open) {
			open();
		}
	}

	public void save() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
	        Document doc = docBuilder.newDocument();
	        
	        Element racine = doc.createElement("Course");
	        doc.appendChild(racine);
	        
	        for(Voilier v : lesVoiliersInscrits) {
	        	Element voilier = doc.createElement("Voilier");
		        racine.appendChild(voilier);
		        
	        	Attr att = doc.createAttribute("id");
	        	att.setValue(String.valueOf(v.getNum()));
	        	voilier.setAttributeNode(att);
	        	
	        	Element nomVoilier = doc.createElement("Nom_Voilier");
	        	nomVoilier.appendChild(doc.createTextNode(v.getNom()));
	            voilier.appendChild(nomVoilier);
	            
	            Element nomSkipper = doc.createElement("Nom_Skipper");
	            nomSkipper.appendChild(doc.createTextNode(v.skipper.getNom()));
	            voilier.appendChild(nomSkipper);
	            
	            Element classVoilier = doc.createElement("Classe_Voilier");
	            classVoilier.appendChild(doc.createTextNode(String.valueOf(v.getClasse())));
	            voilier.appendChild(classVoilier);
	            
	            Element ratingVoiler = doc.createElement("Rating_Voilier");
	            ratingVoiler.appendChild(doc.createTextNode(String.valueOf(v.getRating())));
	            voilier.appendChild(ratingVoiler);
	        }
	        
	        Element nomCourse = doc.createElement("Nom_Course");
	        nomCourse.appendChild(doc.createTextNode(txtNomRegate.getText()));
	        racine.appendChild(nomCourse);
	        
	        Element distance = doc.createElement("Distance");
	        distance.appendChild(doc.createTextNode(txtDistance.getText()));
	        racine.appendChild(distance);
	        
	        // write the content into xml file
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        fc.setSelectedFile(new File(txtNomRegate.getText() + ".xml"));
	        fc.showSaveDialog(this);
	        File fichier = fc.getSelectedFile();
	        StreamResult resultat = new StreamResult(fichier);
	        transformer.transform(source, resultat);
	        
	        JOptionPane.showMessageDialog(null, "Sauvegarde des donn�es effectu�", "Information", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Sauvegarde des donn�es impossible", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void open() {
		String nomVoilier;
		String nomSkipper;
		int classeVoiler, ratingVoilier, numVoilier;
		try {
			fc.setFileFilter(new Accept());
			fc.setMultiSelectionEnabled(false);
			fc.getSelectedFile();
			fc.showOpenDialog(this);
			File fichier = fc.getSelectedFile();
			System.out.println(fichier.getAbsolutePath());
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(fichier);
		    		
			doc.getDocumentElement().normalize();
			
			NodeList nodes = doc.getElementsByTagName("Voilier");
			
			for(int i = 0; i < nodes.getLength(); i++) {
				Node nNode = nodes.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					numVoilier = Integer.parseInt(eElement.getAttribute("id"));
					nomVoilier = eElement.getElementsByTagName("Nom_Voilier").item(0).getTextContent();
					nomSkipper = eElement.getElementsByTagName("Nom_Skipper").item(0).getTextContent();
					classeVoiler = Integer.parseInt(eElement.getElementsByTagName("Classe_Voilier").item(0).getTextContent());
					ratingVoilier = Integer.parseInt(eElement.getElementsByTagName("Rating_Voilier").item(0).getTextContent());
					lesVoiliersInscrits.add(new Voilier(nomVoilier, classeVoiler, ratingVoilier, numVoilier, nomSkipper));
					modele.addElement("Nom voilier : " + nomVoilier+" | Skipper : "+nomSkipper +" | Classe : "+ classeVoiler+ " | Rating : "+ ratingVoilier);
					list.setModel(modele);
					SwingUtilities.updateComponentTreeUI(this);
				}
			}
			
			NodeList nodes1 = doc.getElementsByTagName("Nom_Course");
		    Node node1 = nodes1.item(0);
		    txtNomRegate.setText(node1.getTextContent());
		    
		    NodeList nodes2 = doc.getElementsByTagName("Distance");
		    Node node2 = nodes2.item(0);
		    txtDistance.setText(node2.getTextContent());
		    
		    JOptionPane.showMessageDialog(null, "Importation des donn�es r�ussi", "Information", JOptionPane.INFORMATION_MESSAGE);
		    
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	/**
	 * Description : Class pour le filtre de recherche de fichier XML
	 * @author Thomas DURST
	 */
	class Accept extends FileFilter {

		@Override
		public boolean accept(File f) {
			// TODO Auto-generated method stub
			if(f.getName().endsWith(".xml")) {
				return true;
			}
			return false;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "Fichier xml";
		}
		
	}
	
	public static void main(String[] args) {
		FenInscription fi = new FenInscription();
		fi.setVisible(true);
	}
}
