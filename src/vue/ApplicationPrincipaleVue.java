package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import controleur.controleurVue.ApplicationPrincipaleControleurVue;
import controleur.patronJTable.BateauPatron;
import modele.Quai;

public class ApplicationPrincipaleVue extends JFrame {
	
	private JPanel panelwest = new JPanel();
	private static JButton gestionProprietaires, gestionEmplacements, gestionQuais, ajouter, supprimer, modifier;
	private static JTable table;
	private static JComboBox comboboxQuais;
	private static BateauPatron modele = new BateauPatron();
	private JLabel gestionBateaux, quais;

	public ApplicationPrincipaleVue(){
		this.setTitle("Gestion du Port");
		this.add(panelwest, BorderLayout.WEST);
		// Creation boite verticale pour inserer les composants du panel de gauche
		Box verticalBox = Box.createVerticalBox();
		panelwest.add(verticalBox);
		quais = new JLabel("Quais");
		comboboxQuais = new JComboBox<Quai>();
		gestionQuais = new JButton("Gestion quais");
		gestionProprietaires = new JButton("Gestion propriétaires");
		gestionEmplacements = new JButton("Gestion emplacements");
		gestionBateaux = new JLabel("Gestion bateaux");
		ajouter = new JButton("Ajouter");
		supprimer = new JButton("Supprimer");
		modifier = new JButton("Modifier");
		
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
		
		new ApplicationPrincipaleControleurVue();
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
