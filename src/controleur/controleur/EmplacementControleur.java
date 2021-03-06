package controleur.controleur;

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
import controleur.controleur.ProprietaireControleur.AjouterListener;
import controleur.controleur.ProprietaireControleur.ModifierListener;
import controleur.controleur.ProprietaireControleur.SupprimerListener;
import controleur.dao.EmplacementDAO;
import controleur.dao.ProprietaireDAO;
import controleur.dao.QuaiDAO;
import controleur.patron.EmplacementPatron;


public class EmplacementControleur {
	private JTable table = EmplacementVue.getTable();
	private EmplacementPatron modele = EmplacementVue.getModele();
	
	public EmplacementControleur(Quai quai){
		EmplacementVue.ajouterListener(new AjouterListener(quai));
		EmplacementVue.modifierListener(new ModifierListener(quai));
		EmplacementVue.supprimerListener(new SupprimerListener(quai));
		
		EmplacementVue.rafraichissementTexteEmplacement(EmplacementDAO.recupererNombreEmplacementCreeDansQuai(quai), quai.getNombreEmplacements());
	}
	
	class AjouterListener implements ActionListener
	{
		private Quai quai;
		public AjouterListener(Quai quai){
			this.quai = quai;
		}

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(EmplacementDAO.recupererNombreEmplacementCreeDansQuai(quai)< quai.getNombreEmplacements()){
				 JTextField code = new JTextField();
				 JTextField taille = new JTextField();
				 int r =JOptionPane.showOptionDialog(null, new Object[] {"Code :", code, "Taille :", taille},
					      "Emplacement",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
				 if(r == JOptionPane.YES_OPTION){
					 if(code.getText().isEmpty()|| taille.getText().isEmpty()){
					    	JOptionPane d = new JOptionPane();
					    	d.showMessageDialog( null, "Code ou Taille manquant", "Erreur ajout emplacement", JOptionPane.ERROR_MESSAGE);
					 }else{
						 try{
							 int iCode = Integer.parseInt(code.getText());
							 Double dTaille = Double.parseDouble(taille.getText());
							 if(EmplacementDAO.estUnEmplacement(iCode) == false){
								 EmplacementDAO.ajouterEmplacement(iCode, dTaille, quai);
								 modele.setListeEmplacement(EmplacementDAO.recupererLesEmplacementsDunQuai(quai));
								 modele.fireTableStructureChanged();
							 }else{
								 JOptionPane d = new JOptionPane();
							     d.showMessageDialog( null, "Le code emplacement doit �tre unique", "Erreur ajout emplacement", JOptionPane.ERROR_MESSAGE); 
							 }
							 
						 }catch(NumberFormatException e){
							 JOptionPane d = new JOptionPane();
						     d.showMessageDialog( null, "Des nombres sont attendus", "Erreur ajout emplacement", JOptionPane.ERROR_MESSAGE);
						 }
					 }    
				 }
    
			}else{
				JOptionPane d = new JOptionPane();
		    	d.showMessageDialog( null, "Nombre maximal d'emplacement atteind pour ce quai", "Erreur ajout emplacement", JOptionPane.ERROR_MESSAGE);
			}
			EmplacementVue.rafraichissementTexteEmplacement(EmplacementDAO.recupererNombreEmplacementCreeDansQuai(quai), quai.getNombreEmplacements()); 
			ApplicationPrincipaleControleur.actualiserTexte(quai);
		}
	}
	
	class ModifierListener implements ActionListener
	{
		private Quai quai;
		public ModifierListener(Quai quai){
			this.quai = quai;
		}
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow() != -1)
			{
				Emplacement emplacement = modele.getListeEmplacement().get(table.getSelectedRow());
				JTextField taille = new JTextField(emplacement.getTaille()+"");
				int r =JOptionPane.showOptionDialog(null, new Object[] { "Taille :", taille},
				      "Emplacement",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null); 
				if(r == JOptionPane.YES_OPTION){
					if( taille.getText().isEmpty()){
					    JOptionPane d = new JOptionPane();
					    d.showMessageDialog( null, "Taille manquant", "Erreur modifier emplacement", JOptionPane.ERROR_MESSAGE);
					 }else{
						 try{
							 Double dTaille = Double.parseDouble(taille.getText());
							 emplacement.setTaille(dTaille);
							 EmplacementDAO.modifierEmplacement(emplacement);
							 modele.setListeEmplacement(EmplacementDAO.recupererLesEmplacementsDunQuai(quai));
						     modele.fireTableStructureChanged();
							 
						 }catch(NumberFormatException e){
							 JOptionPane d = new JOptionPane();
						     d.showMessageDialog( null, "Des nombres sont attendus", "Erreur modifier emplacement", JOptionPane.ERROR_MESSAGE);
						 }
					   
					    }
					}
				}else{
					JOptionPane d = new JOptionPane();
			    	d.showMessageDialog( null, "S�lectionner un emplacement", "Erreur modifier emplacement", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
	}
	
	class SupprimerListener implements ActionListener
	{
		private Quai quai;
		public SupprimerListener(Quai quai){
			this.quai = quai;
		}
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow() != -1)
			{
				Emplacement  emplacement = modele.getListeEmplacement().get(table.getSelectedRow());
				System.out.println(emplacement);
				EmplacementDAO.supprimerEmplacement(emplacement);
				modele.setListeEmplacement(EmplacementDAO.recupererLesEmplacementsDunQuai(quai));
				modele.fireTableStructureChanged();
			}else{
				JOptionPane d = new JOptionPane();
		    	d.showMessageDialog( null, "S�lectionner un emplacement", "Erreur supprimer emplacement", JOptionPane.ERROR_MESSAGE);
			}	
			EmplacementVue.rafraichissementTexteEmplacement(EmplacementDAO.recupererNombreEmplacementCreeDansQuai(quai), quai.getNombreEmplacements());
			ApplicationPrincipaleControleur.actualiserTexte(quai);
		}
	}
}
