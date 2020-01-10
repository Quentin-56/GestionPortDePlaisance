package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
	private static JButton gestionProprietaires, gestionEmplacements, gestionBateaux, gestionQuais;
	private static JTable table;
	private static JComboBox comboboxQuais;
	private static BateauPatron modele = new BateauPatron();

	public ApplicationPrincipaleVue(){
		this.setTitle("Gestion du Port");
		this.add(panelwest, BorderLayout.WEST);
		// Creation boite verticale pour inserer les composants du panel de gauche
		Box verticalBox = Box.createVerticalBox();
		panelwest.add(verticalBox);
		comboboxQuais = new JComboBox<Quai>();
		gestionQuais = new JButton("Gestion quais");
		gestionProprietaires = new JButton("Gestion propriétaires");
		gestionEmplacements = new JButton("Gestion emplacements");
		gestionBateaux = new JButton("Gestion bateaux");
		
		verticalBox.add(comboboxQuais);
		verticalBox.add(gestionQuais);
		verticalBox.add(gestionProprietaires);
		verticalBox.add(gestionEmplacements);
		verticalBox.add(gestionBateaux);
		
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
	
	public static void comboboxListener(ActionListener changeListener) {
		comboboxQuais.addActionListener(changeListener);
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
