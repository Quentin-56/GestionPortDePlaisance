package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import modele.Quai;
import controleur.controleurVue.EmplacementControleurVue;
import controleur.patronJTable.EmplacementPatron;
import controleur.patronJTable.ProprietairePatron;

public class EmplacementVue extends JFrame {
	private JPanel panelwest = new JPanel();
	private static JButton ajouter, modifier, supprimer;
	private static JTable table;
	private static EmplacementPatron modele;
	
	public EmplacementVue(Quai quai){
		modele = new EmplacementPatron(quai);
		
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
		
		new EmplacementControleurVue(quai);
	}
	//Definir les actions sur les boutons
	public static void ajouterListener(ActionListener ajouterListener) {
		ajouter.addActionListener(ajouterListener);
			
	}
	public static void modifierListener(ActionListener modifierListener) {
		modifier.addActionListener(modifierListener);
			
	}
	public static void supprimerListener(ActionListener supprimerListener) {
		supprimer.addActionListener(supprimerListener);
			
	}
	
		//Getters et setters
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
		EmplacementVue.ajouter = ajouter;
	}

	public static JButton getModifier() {
		return modifier;
	}

	public static void setModifier(JButton modifier) {
		EmplacementVue.modifier = modifier;
	}

	public static JButton getSupprimer() {
		return supprimer;
	}

	public static void setSupprimer(JButton supprimer) {
		EmplacementVue.supprimer = supprimer;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		EmplacementVue.table = table;
	}

	public static EmplacementPatron getModele() {
		return modele;
	}

	public static void setModele(EmplacementPatron modele) {
		EmplacementVue.modele = modele;
	}
	
	
}
