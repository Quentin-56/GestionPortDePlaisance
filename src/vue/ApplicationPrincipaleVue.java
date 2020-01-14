package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import controleur.controleur.ApplicationPrincipaleControleur;
import controleur.patron.BateauPatron;
import modele.Quai;

public class ApplicationPrincipaleVue extends JFrame {
	
	private JPanel panelwest = new JPanel();
	private static JButton gestionProprietaires, gestionEmplacements, gestionQuais, ajouter, supprimer, modifier, voilier;
	private static JTable table;
	private static JComboBox comboboxQuais;
	private static BateauPatron modele = new BateauPatron();
	private JLabel gestionBateaux, quais, infos;
	private static JLabel emplacementLibre;
	private static JLabel bateauVoile;
	private static JLabel bateauMoteur;

	public ApplicationPrincipaleVue(){
		this.setTitle("Gestion du Port");
		this.add(panelwest, BorderLayout.WEST);
		// Creation boite verticale pour inserer les composants du panel de gauche
		Box verticalBox = Box.createVerticalBox();
		panelwest.add(verticalBox);
		quais = new JLabel("Quais");
		comboboxQuais = new JComboBox<Quai>();
		gestionQuais = new JButton("Gestion quais                  ", new ImageIcon("images"+File.separator+"quai.png"));
		gestionProprietaires = new JButton("Gestion propriétaires    ", new ImageIcon("images"+File.separator+"marin.png"));
		gestionEmplacements = new JButton("Gestion emplacements", new ImageIcon("images"+File.separator+"emplacement.png"));
		gestionBateaux = new JLabel("Gestion bateaux :");
		ajouter = new JButton("Ajouter      ", new ImageIcon("images"+File.separator+"ajouter.png"));
		supprimer = new JButton("Supprimer", new ImageIcon("images"+File.separator+"supprimer.png"));
		modifier = new JButton("Modifier    ", new ImageIcon("images"+File.separator+"modifier.png"));
		
		infos = new JLabel("Informations pratiques :");
		emplacementLibre = new JLabel();
		bateauVoile = new JLabel();
		bateauMoteur = new JLabel();
		
		voilier = new JButton("Recherche sur voilier", new ImageIcon("images"+File.separator+"voilier.png"));
		verticalBox.add(quais);
		verticalBox.add(comboboxQuais);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		verticalBox.add(gestionQuais);
		verticalBox.add(gestionProprietaires);
		verticalBox.add(gestionEmplacements);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		verticalBox.add(gestionBateaux);
		verticalBox.add(ajouter);
		verticalBox.add(supprimer);
		verticalBox.add(modifier);
		verticalBox.add(voilier);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		verticalBox.add(infos);
		verticalBox.add(emplacementLibre);
		verticalBox.add(bateauVoile);
		verticalBox.add(bateauMoteur);
		
		table = new JTable(modele);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JTableHeader headt = table.getTableHeader();
		headt.setBackground(new Color(204, 44, 111));
		headt.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(197, 230, 229));

		JScrollPane pane = new JScrollPane(table);
		this.add(pane);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		new ApplicationPrincipaleControleur();
	}
	
	//Definir les actions sur les boutons
	public static void comboboxListener(ActionListener changeListener) {
		comboboxQuais.addActionListener(changeListener);
	}
	public static void ajouterListener(ActionListener ajouterListener) {
		ajouter.addActionListener(ajouterListener);
		
	}
	public static void modifierListener(ActionListener modifierListener) {
		modifier.addActionListener(modifierListener);
		
	}
	public static void supprimerListener(ActionListener supprimerListener) {
		supprimer.addActionListener(supprimerListener);
		
	}
	public static void gestionEmplacementsListener(ActionListener actionListener) {
		gestionEmplacements.addActionListener(actionListener);
		
	}
	public static void gestionProprietairesListener(ActionListener actionListener) {
		gestionProprietaires.addActionListener(actionListener);
		
	}
	public static void gestionQuaisListener(ActionListener actionListener) {
		gestionQuais.addActionListener(actionListener);
		
	}
	public static void voilierListener(ActionListener actionListener) {
		voilier.addActionListener(actionListener);
		
	}
	//Rafraichissement du texte
	public static void rafraichissementTexteEmplacement(int occupee, int total){
		emplacementLibre.setText(occupee +" emplacement(s) occupé(s) sur "+ total +" dispo.");
	}
	public static void rafraichissementTexteBateauAVoile(int nbVoilier){
		bateauVoile.setText("Nombre de Voilier : "+nbVoilier);
	}
	public static void rafraichissementTexteBateauAMoteur(int nbBateauMoteur){
		bateauMoteur.setText("Nombre de Bateau à moteur : "+nbBateauMoteur);
	}
	//Getters et setters
	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		ApplicationPrincipaleVue.table = table;
	}

	public static JComboBox getComboboxQuais() {
		return comboboxQuais;
	}

	public static void setComboboxQuais(JComboBox comboboxQuais) {
		ApplicationPrincipaleVue.comboboxQuais = comboboxQuais;
	}

	public static BateauPatron getModele() {
		return modele;
	}

	public static void setModele(BateauPatron modele) {
		ApplicationPrincipaleVue.modele = modele;
	}
}
