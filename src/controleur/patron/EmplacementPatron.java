package controleur.patron;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Emplacement;
import modele.Quai;
import controleur.dao.EmplacementDAO;


@SuppressWarnings("serial")
public class EmplacementPatron extends AbstractTableModel {
	private static String[] entetes = {"Code", "Taille"};
	private static List<Emplacement> listeEmplacement = new ArrayList<Emplacement>();
	
	public EmplacementPatron(Quai quai){
		listeEmplacement = EmplacementDAO.recupererLesEmplacementsDunQuai(quai);
	}
	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
	
		return listeEmplacement.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex)
		{
	        case 0:
	            return listeEmplacement.get(rowIndex).getCode();
	       
	        case 1:
	        	return listeEmplacement.get(rowIndex).getTaille();
	        
	 		default:
	 			return null; //Ne devrait jamais arriver	
	      
		}
	}
	public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
	public static String[] getEntetes() {
		return entetes;
	}
	public static void setEntetes(String[] entetes) {
		EmplacementPatron.entetes = entetes;
	}
	public static List<Emplacement> getListeEmplacement() {
		return listeEmplacement;
	}
	public static void setListeEmplacement(List<Emplacement> listeEmplacement) {
		EmplacementPatron.listeEmplacement = listeEmplacement;
	}
	
}
