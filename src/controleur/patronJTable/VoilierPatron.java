package controleur.patronJTable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import modele.Bateau;
import modele.Quai;
import modele.Voilier;
import vue.ApplicationPrincipaleVue;

public class VoilierPatron extends AbstractTableModel{
	
	private String[] entetes = {"Nom", "Poids", "Surface Voile", "Propietaire", "Emplacement"};
	private List<Voilier> listesVoiliers = new ArrayList<Voilier>(); 
	
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	

	@Override
	public int getRowCount() {
	
		return listesVoiliers.size();
	}
	
	public Bateau retournerBateau(int rowIndex) {
		return listesVoiliers.get(rowIndex);
	}

	public void refresh()
	{
		Quai quai = (Quai) ApplicationPrincipaleVue.getComboboxQuais().getSelectedItem();
		if(quai != null)
		{
			//List<Bateau> bateaux = QuaiDAO.retournerBateauDuQuai(quai);
			//listesVoiliers = bateaux;
			fireTableDataChanged();
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex)
		{
	        case 0:
	            return listesVoiliers.get(rowIndex).getNom();
	       
	        case 1:
	        	return listesVoiliers.get(rowIndex).getPoids();
	        	
	        case 2:
	        	return listesVoiliers.get(rowIndex).getSurfaceTotaleVoile()+" m²";
	        
	        case 3:
	        	return listesVoiliers.get(rowIndex).getPropietaire().getNom();
	        
	        case 4:
	        	return listesVoiliers.get(rowIndex).getEmplacement();
	        
	 		default:
	 			return null; //Ne devrait jamais arriver	
	      
		}
	}
	
	public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
}
