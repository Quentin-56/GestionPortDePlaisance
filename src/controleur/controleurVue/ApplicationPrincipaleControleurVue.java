package controleur.controleurVue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;

import controleur.dao.PortDAO;
import controleur.patronJTable.BateauPatron;
import modele.Bateau;
import modele.Emplacement;
import modele.Port;
import modele.Quai;
import vue.ApplicationPrincipaleVue;
import vue.ProprietaireVue;
import vue.QuaiVue;

public class ApplicationPrincipaleControleurVue {
	
	private JComboBox comboboxQuai = ApplicationPrincipaleVue.getComboboxQuais();
	private Port port = PortDAO.retournerPort();
	private BateauPatron modele = ApplicationPrincipaleVue.getModele();
	private JTable table = ApplicationPrincipaleVue.getTable();
	
	public ApplicationPrincipaleControleurVue()
	{
		ApplicationPrincipaleVue.comboboxListener(new ComboboxListener());
		ApplicationPrincipaleVue.gestionQuaisListener(new GestionQuaisListener());
		ApplicationPrincipaleVue.gestionProprietairesListener(new GestionProprietairesListener());
		ApplicationPrincipaleVue.gestionBateauxListener(new GestionBateauListener());
		ApplicationPrincipaleVue.gestionEmplacementsListener(new GestionEmplacementsListener());
		
		//Parcourir tout les quais du port et ajouter au combobox
		for(Quai quai : port.getListeDeQuais())
		{
			comboboxQuai.addItem(quai);
		}
		
		Quai quai = (Quai) comboboxQuai.getSelectedItem();
		afficherBateauxDuQuai(quai);
	}
	
	public void afficherBateauxDuQuai(Quai quai)
	{
		List<Bateau> bateaux = new ArrayList<>();
		for(Emplacement emplacement : quai.getListeEmplacements())
		{
			//Si l'emplacement possede un bateau
			if(emplacement.getBateau() != null)
			{
				bateaux.add(emplacement.getBateau());
			}
		}
		
		modele.setListesBateaux(bateaux);
		modele.fireTableDataChanged();
	}
	
	class ComboboxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Quai quai = (Quai) comboboxQuai.getSelectedItem();
			afficherBateauxDuQuai(quai);
		}
	}
	
	class GestionQuaisListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			QuaiVue quaiVue = new QuaiVue(port);
		}
	}
	
	class GestionProprietairesListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new ProprietaireVue();
		}
	}
	
	class GestionBateauListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Rien encore
		}
	}
	
	class GestionEmplacementsListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Rien encore
		}
	}
	
}
