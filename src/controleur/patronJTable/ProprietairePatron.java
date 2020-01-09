package controleur.patronJTable;
import javax.swing.table.AbstractTableModel;

public class ProprietairePatron extends AbstractTableModel{
	
	private static String[] entetes = {"Nom", "Adresse"};
	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
	
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex)
		{
	        case 0:
	            return null;
	       
	        case 1:
	        	return null;
	        
	 		default:
	 			return null; //Ne devrait jamais arriver	
	      
		}
	}
}
