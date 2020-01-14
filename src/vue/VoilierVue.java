package vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import controleur.patron.VoilierPatron;

public class VoilierVue extends JFrame {

	private JPanel panelwest = new JPanel();
	private JTable table;
	private VoilierPatron modele = new VoilierPatron();
	private JLabel nombreDeVoilier  = new JLabel();

	public VoilierVue(double saisie) {
		
		modele.refresh(saisie, nombreDeVoilier);
		this.setTitle("Affichage des voiliers");
		table = new JTable(modele);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		this.add(panelwest, BorderLayout.WEST);
		Box verticalBox = Box.createVerticalBox();
		panelwest.add(verticalBox);
		verticalBox.add(nombreDeVoilier);
		
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
	}
}
