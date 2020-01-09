package controleur.controleurVue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import modele.Proprietaire;
import controleur.dao.ProprietaireDAO;
import controleur.patronJTable.ProprietairePatron;
import vue.ProprietaireVue;

public class ProprietaireControleurVue {
	
	private JTable table = ProprietaireVue.getTable();
	private ProprietairePatron modele = ProprietaireVue.getModele();
	public ProprietaireControleurVue(){
		ProprietaireVue.ajouterListener(new AjouterListener());
		ProprietaireVue.modifierListener(new ModifierListener());
		ProprietaireVue.supprimerListener(new SupprimerListener());
	}
	
	class AjouterListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
	
	class ModifierListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow() != -1)
			{
				
			}
			
		}
		
	}
	
	class SupprimerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow() != -1)
			{
				Proprietaire proprio= modele.getListeProprietaire().get(table.getSelectedRow());
				ProprietaireDAO.supprimerProprietaire(proprio);
				modele.setListeProprietaire(ProprietaireDAO.recupererTousLesProprietaires());
				modele.fireTableStructureChanged();
			}
			
		}
		
	}

}
