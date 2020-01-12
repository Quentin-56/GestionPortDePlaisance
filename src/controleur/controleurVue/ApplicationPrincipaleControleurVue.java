package controleur.controleurVue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import controleur.dao.BateauDAO;
import controleur.dao.EmplacementDAO;
import controleur.dao.PortDAO;
import controleur.patronJTable.BateauPatron;
import modele.Bateau;
import modele.Port;
import modele.Quai;
import vue.EditerBateauVue;
import vue.ApplicationPrincipaleVue;
import vue.EmplacementVue;
import vue.ProprietaireVue;
import vue.QuaiVue;

public class ApplicationPrincipaleControleurVue 
{
	
	private JComboBox comboboxQuai = ApplicationPrincipaleVue.getComboboxQuais();
	private Port port = PortDAO.retournerPort();
	private BateauPatron modele = ApplicationPrincipaleVue.getModele();
	private JTable table = ApplicationPrincipaleVue.getTable();
	private Quai quai;
	
	public ApplicationPrincipaleControleurVue()
	{
		ApplicationPrincipaleVue.comboboxListener(new ComboboxListener());
		ApplicationPrincipaleVue.gestionQuaisListener(new GestionQuaisListener());
		ApplicationPrincipaleVue.gestionProprietairesListener(new GestionProprietairesListener());
		ApplicationPrincipaleVue.gestionEmplacementsListener(new GestionEmplacementsListener());
		ApplicationPrincipaleVue.ajouterListener(new AjouterBateauListener());
		ApplicationPrincipaleVue.supprimerListener(new SupprimerBateauListener());
		ApplicationPrincipaleVue.modifierListener(new ModifierBateauListener());
		
		ApplicationPrincipaleVue.rafraichissementTexteEmplacement(0, 0);
		ApplicationPrincipaleVue.rafraichissementTexteBateauAVoile(0);
		ApplicationPrincipaleVue.rafraichissementTexteBateauAMoteur(0);
		
		//Parcourir tout les quais du port et ajouter au combobox
		for(Quai quai : port.getListeDeQuais())
		{
			comboboxQuai.addItem(quai);
		}
		
		
		if(comboboxQuai.getSelectedItem() != null)
		{
			quai = (Quai) comboboxQuai.getSelectedItem();
			modele.refresh();
		}
	}
	
	class ComboboxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			quai = (Quai) comboboxQuai.getSelectedItem();
			modele.refresh();
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
	
	class GestionEmplacementsListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new EmplacementVue(quai);
		}
	}
	
	class AjouterBateauListener implements ActionListener
	{		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(EmplacementDAO.recupererNombreEmplacementOccupeDansQuai(quai) == EmplacementDAO.recupererNombreEmplacementCreeDansQuai(quai) && EmplacementDAO.recupererNombreEmplacementCreeDansQuai(quai) != quai.getNombreEmplacements())
			{
				JOptionPane.showMessageDialog(null, "Allez d'abord creer un emplacement","Erreur emplacement",JOptionPane.ERROR_MESSAGE);
			}else if(EmplacementDAO.recupererNombreEmplacementOccupeDansQuai(quai) == quai.getNombreEmplacements())
				{
					JOptionPane.showMessageDialog(null, "Ce quai ne dispose plus d'emplacement","Erreur emplacement",JOptionPane.ERROR_MESSAGE);
				}else 
				{
					new EditerBateauVue(null, "Ajouter un bateau", null);
				}
		}
	}
	
	class SupprimerBateauListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int ligneSelectionnee = table.getSelectedRow();
			
			if(ligneSelectionnee != -1)
			{
				Bateau bateau = modele.retournerBateau(ligneSelectionnee);
				BateauDAO.supprimerBateau(bateau);
				bateau.getEmplacement().setBateau(null);
				modele.refresh();
			}
		}	
	}
	
	class ModifierBateauListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int ligneSelectionnee = table.getSelectedRow();
			
			if(ligneSelectionnee != -1)
			{
				Bateau bateau = modele.retournerBateau(ligneSelectionnee);
				
				new EditerBateauVue(null, "Modifier un bateau",bateau);

				modele.refresh();
			}
		}	
	}
}