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

public class ApplicationPrincipaleControleurVue {
	
	JComboBox comboboxQuai = ApplicationPrincipaleVue.getComboboxQuais();
	Port port = PortDAO.retournerPort();
	BateauPatron modele = ApplicationPrincipaleVue.getModele();
	JTable table = ApplicationPrincipaleVue.getTable();
	
	public ApplicationPrincipaleControleurVue()
	{
		ApplicationPrincipaleVue.comboboxListener(new ComboboxListener());
		
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
			bateaux.add(emplacement.getBateau());
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
}
