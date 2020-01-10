package controleur.controleurVue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    JTextField nom = new JTextField();
		    JTextField adresse = new JTextField();
		    JOptionPane.showOptionDialog(null, new Object[] {"Nom :", nom, "Adresse :", adresse},
		      "Proprietaire",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null); 
		    if(nom.getText().equals("") || adresse.getText().equals("")){
		    	JOptionPane d = new JOptionPane();
		    	d.showMessageDialog( null, "Nom ou Adresse manquant", "Erreur ajout proprietaire", JOptionPane.ERROR_MESSAGE);
		    }else{
		    	ProprietaireDAO.ajouterProprietaire(nom.getText(), adresse.getText());
		    	modele.setListeProprietaire(ProprietaireDAO.recupererTousLesProprietaires());
				modele.fireTableStructureChanged();
		    }
		}
	}
	
	class ModifierListener implements ActionListener
	{

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow() != -1)
			{
				Proprietaire proprio = modele.getListeProprietaire().get(table.getSelectedRow());
				JTextField nom = new JTextField(proprio.getNom());
			    JTextField adresse = new JTextField(proprio.getAdresse());
			    JOptionPane.showOptionDialog(null, new Object[] {"Nom :", nom, "Adresse :", adresse},
			      "Proprietaire",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null); 
			    if(nom.getText().equals("") || adresse.getText().equals("")){
			    	JOptionPane d = new JOptionPane();
			    	d.showMessageDialog( null, "Nom ou Adresse manquant", "Erreur ajout proprietaire", JOptionPane.ERROR_MESSAGE);
			    }else{
			    	proprio.setNom(nom.getText());
			    	proprio.setAdresse(adresse.getText());
			    	ProprietaireDAO.modifierProprietaire(proprio);
			    	modele.setListeProprietaire(ProprietaireDAO.recupererTousLesProprietaires());
					modele.fireTableStructureChanged();
			    }
			}
			}
			
		
	}
	
	class SupprimerListener implements ActionListener
	{

		@SuppressWarnings("static-access")
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
