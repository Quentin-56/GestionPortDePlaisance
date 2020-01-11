package controleur.controleurVue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modele.Emplacement;
import modele.Proprietaire;
import modele.Quai;
import vue.EmplacementVue;
import vue.ProprietaireVue;
import controleur.controleurVue.ProprietaireControleurVue.AjouterListener;
import controleur.controleurVue.ProprietaireControleurVue.ModifierListener;
import controleur.controleurVue.ProprietaireControleurVue.SupprimerListener;
import controleur.dao.EmplacementDAO;
import controleur.dao.ProprietaireDAO;
import controleur.patronJTable.EmplacementPatron;


public class EmplacementControleurVue {
	private JTable table = EmplacementVue.getTable();
	private EmplacementPatron modele = EmplacementVue.getModele();
	
	public EmplacementControleurVue(Quai quai){
		EmplacementVue.ajouterListener(new AjouterListener(quai));
		EmplacementVue.modifierListener(new ModifierListener(quai));
		EmplacementVue.supprimerListener(new SupprimerListener(quai));
	}
	
	class AjouterListener implements ActionListener
	{
		Quai quai;
		public AjouterListener(Quai quai){
			this.quai = quai;
		}

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    JTextField code = new JTextField();
		    JTextField taille = new JTextField();
		    JOptionPane.showOptionDialog(null, new Object[] {"Code :", code, "Taille :", taille},
		      "Emplacement",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null); 
		    if(code.getText().isBlank()|| taille.getText().isBlank()){
		    	JOptionPane d = new JOptionPane();
		    	d.showMessageDialog( null, "Code ou Taille manquant", "Erreur ajout emplacement", JOptionPane.ERROR_MESSAGE);
		    }else{
		    	int iCode = Integer.parseInt(code.getText());
		    	Double dTaille = Double.parseDouble(taille.getText());
		    	EmplacementDAO.ajouterEmplacement(iCode, dTaille, quai);
		    	modele.setListeEmplacement(EmplacementDAO.recupererLesEmplacementsDunQuai(quai));
				modele.fireTableStructureChanged();
		    }
		}
	}
	
	class ModifierListener implements ActionListener
	{
		Quai quai;
		public ModifierListener(Quai quai){
			this.quai = quai;
		}
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow() != -1)
			{
				Emplacement emplacement = modele.getListeEmplacement().get(table.getSelectedRow());
				 JTextField code = new JTextField(emplacement.getCode());
				    JTextField taille = new JTextField(emplacement.getTaille()+"");
				    JOptionPane.showOptionDialog(null, new Object[] {"Code :", code, "Taille :", taille},
				      "Emplacement",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null); 
				    if(code.getText().equals("") || taille.getText().equals("")){
				    	JOptionPane d = new JOptionPane();
				    	d.showMessageDialog( null, "Code ou Taille manquant", "Erreur modifier emplacement", JOptionPane.ERROR_MESSAGE);
				    }else{
				    	int iCode = Integer.parseInt(code.getText());
				    	Double dTaille = Double.parseDouble(taille.getText());
				    	emplacement.setCode(iCode);
				    	emplacement.setTaille(dTaille);
				    	EmplacementDAO.modifierEmplacement(emplacement);
				    	modele.setListeEmplacement(EmplacementDAO.recupererLesEmplacementsDunQuai(quai));
						modele.fireTableStructureChanged();
				    }
			}
			}
			
		
	}
	
	class SupprimerListener implements ActionListener
	{
		Quai quai;
		public SupprimerListener(Quai quai){
			this.quai = quai;
		}
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow() != -1)
			{
				Emplacement  emplacement = modele.getListeEmplacement().get(table.getSelectedRow());
				EmplacementDAO.supprimerEmplacement(emplacement);
				modele.setListeEmplacement(EmplacementDAO.recupererLesEmplacementsDunQuai(quai));
				modele.fireTableStructureChanged();
			}
			
		}
		
	}
}
