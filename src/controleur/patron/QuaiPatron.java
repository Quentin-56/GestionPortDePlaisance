package controleur.patron;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Quai;

public class QuaiPatron extends AbstractTableModel{
	
	private String[] entetes = {"Code", "Nombre d'emplacements"};
	private List<Quai> listesQuais = new ArrayList<Quai>(); 
	
	public void ajouterQuai(Quai quai)
	{
		listesQuais.add(quai);
		this.fireTableRowsInserted(listesQuais.size()-1, listesQuais.size()-1);
	}
	
	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
	
		return listesQuais.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex)
		{
	        case 0:
	            return listesQuais.get(rowIndex).getCode();
	       
	        case 1:
	        	return listesQuais.get(rowIndex).getNombreEmplacements();
	        	
	 		default:
	 			return null; //Ne devrait jamais arriver	
	      
		}
	}
	
	public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

	//Getters et setters
	public List<Quai> getListesQuais() {
		return listesQuais;
	}

	public void setListesQuais(List<Quai> listesQuais) {
		this.listesQuais = listesQuais;
		this.fireTableDataChanged();
	}
}
