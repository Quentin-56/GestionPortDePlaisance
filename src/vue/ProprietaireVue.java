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
}
