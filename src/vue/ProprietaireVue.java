package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import controleur.controleurVue.ProprietaireControleurVue;
import controleur.patronJTable.ProprietairePatron;

public class ProprietaireVue extends JFrame{
	private JPanel panelwest = new JPanel();
	private static JButton ajouter, modifier, supprimer;
	private static JTable table;
	private static ProprietairePatron modele = new ProprietairePatron();

	
	public ProprietaireVue(){
		this.setTitle("Gestion des proprietaires");
		this.add(panelwest, BorderLayout.WEST);
		// Creation boite verticale pour inserer les composants du panel de gauche
		Box verticalBox = Box.createVerticalBox();
		panelwest.add(verticalBox);
		ajouter = new JButton("Ajouter");
		modifier = new JButton("Modifier");
		supprimer = new JButton("Supprimer");
		verticalBox.add(ajouter);
		verticalBox.add(modifier);
		verticalBox.add(supprimer);
		
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
		
		new ProprietaireControleurVue();

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

	public JPanel getPanelwest() {
		return panelwest;
	}

	public void setPanelwest(JPanel panelwest) {
		this.panelwest = panelwest;
	}

	public static JButton getAjouter() {
		return ajouter;
	}

	public static void setAjouter(JButton ajouter) {
		ProprietaireVue.ajouter = ajouter;
	}

	public static JButton getModifier() {
		return modifier;
	}

	public static void setModifier(JButton modifier) {
		ProprietaireVue.modifier = modifier;
	}

	public static JButton getSupprimer() {
		return supprimer;
	}

	public static void setSupprimer(JButton supprimer) {
		ProprietaireVue.supprimer = supprimer;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		ProprietaireVue.table = table;
	}

	public static ProprietairePatron getModele() {
		return modele;
	}

	public static void setModele(ProprietairePatron modele) {
		ProprietaireVue.modele = modele;
	}
	
	
}
