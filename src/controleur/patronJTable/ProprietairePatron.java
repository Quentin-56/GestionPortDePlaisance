package controleur.patronJTable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import controleur.dao.ProprietaireDAO;
import modele.Proprietaire;

public class ProprietairePatron extends AbstractTableModel{
	
	private static String[] entetes = {"Nom", "Adresse"};
	private static List<Proprietaire> listeProprietaire = ProprietaireDAO.recupererTousLesProprietaires();
	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
	
		return listeProprietaire.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex)
		{
	        case 0:
	            return listeProprietaire.get(rowIndex).getNom();
	       
	        case 1:
	        	return listeProprietaire.get(rowIndex).getAdresse();
	        
	 		default:
	 			return null; //Ne devrait jamais arriver	
	      
		}
	}
	public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
}
