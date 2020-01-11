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

import controleur.controleurVue.QuaiControleurVue;
import controleur.patronJTable.QuaiPatron;
import modele.Port;

public class QuaiVue extends JFrame
{
	private JPanel panelwest = new JPanel();
	private static JButton ajouter, supprimer;
	private static JTable table;
	private static QuaiPatron modele = new QuaiPatron();

	
	public QuaiVue(Port port) {
		
		this.setTitle("Gestion des quais");
		this.add(panelwest, BorderLayout.WEST);
		// Creation boite verticale pour inserer les composants du panel de gauche
		Box verticalBox = Box.createVerticalBox();
		panelwest.add(verticalBox);
		ajouter = new JButton("Ajouter      ", new ImageIcon("images"+File.separator+"ajouter.png"));
		supprimer = new JButton("Supprimer", new ImageIcon("images"+File.separator+"supprimer.png"));
		verticalBox.add(ajouter);
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
		
		new QuaiControleurVue(port);
	}

	//Definir les actions sur les boutons
		public static void ajouterListener(ActionListener ajouterListener) {
			ajouter.addActionListener(ajouterListener);
			
		}
		public static void supprimerListener(ActionListener supprimerListener) {
			supprimer.addActionListener(supprimerListener);
			
		}
		
	//Getters et setters
	public static JTable getTable() {
		return table;
	}


	public static void setTable(JTable table) {
		QuaiVue.table = table;
	}


	public static QuaiPatron getModele() {
		return modele;
	}


	public static void setModele(QuaiPatron modele) {
		QuaiVue.modele = modele;
	}
	
}
