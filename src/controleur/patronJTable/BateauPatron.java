package controleur.patronJTable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import controleur.controleurVue.ApplicationPrincipaleControleurVue;
import controleur.dao.QuaiDAO;
import modele.Bateau;
import modele.Quai;
import vue.ApplicationPrincipaleVue;

public class BateauPatron extends AbstractTableModel{
	
	private String[] entetes = {"Nom", "Poids", "Propietaire"};
	private List<Bateau> listesBateaux = new ArrayList<Bateau>(); 
	
	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
	
		return listesBateaux.size();
	}
	
	public Bateau retournerBateau(int rowIndex) {
		return listesBateaux.get(rowIndex);
	}

	public void refresh()
	{
		Quai quai = (Quai) ApplicationPrincipaleVue.getComboboxQuais().getSelectedItem();
		if(quai != null)
		{
			List<Bateau> bateaux = QuaiDAO.retournerBateauDuQuai(quai);
			listesBateaux = bateaux;
			fireTableDataChanged();
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex)
		{
	        case 0:
	            return listesBateaux.get(rowIndex).getNom();
	       
	        case 1:
	        	return listesBateaux.get(rowIndex).getPoids();
	        	
	        case 2:
	        	return listesBateaux.get(rowIndex).getPropietaire().getNom();
	        
	 		default:
	 			return null; //Ne devrait jamais arriver	
	      
		}
	}
	
	public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

	//Getters et setters
	public List<Bateau> getListesBateaux() {
		return listesBateaux;
	}

	public void setListesBateaux(List<Bateau> listesBateaux) {
		this.listesBateaux = listesBateaux;
	}
}

