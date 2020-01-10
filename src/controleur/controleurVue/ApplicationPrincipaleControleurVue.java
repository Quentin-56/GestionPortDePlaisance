package controleur.controleurVue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.dao.PortDAO;
import controleur.patronJTable.BateauPatron;
import modele.Bateau;
import modele.Emplacement;
import modele.Port;
import modele.Proprietaire;
import modele.Quai;
import vue.ApplicationPrincipaleVue;
import vue.ProprietaireVue;
import vue.QuaiVue;

public class ApplicationPrincipaleControleurVue 
{
	
	private JComboBox comboboxQuai = ApplicationPrincipaleVue.getComboboxQuais();
	private Port port = PortDAO.retournerPort();
	private BateauPatron modele = ApplicationPrincipaleVue.getModele();
	private JTable table = ApplicationPrincipaleVue.getTable();
	
	public ApplicationPrincipaleControleurVue()
	{
		ApplicationPrincipaleVue.comboboxListener(new ComboboxListener());
		ApplicationPrincipaleVue.gestionQuaisListener(new GestionQuaisListener());
		ApplicationPrincipaleVue.gestionProprietairesListener(new GestionProprietairesListener());
		ApplicationPrincipaleVue.gestionEmplacementsListener(new GestionEmplacementsListener());
		ApplicationPrincipaleVue.ajouterListener(new AjouterBateauListener());
		
		
		//Parcourir tout les quais du port et ajouter au combobox
		for(Quai quai : port.getListeDeQuais())
		{
			comboboxQuai.addItem(quai);
		}
		
		
		if(comboboxQuai.getSelectedItem() != null)
		{
			Quai quai = (Quai) comboboxQuai.getSelectedItem();
			afficherBateauxDuQuai(quai);
		}
		
	}
	
	public void afficherBateauxDuQuai(Quai quai)
	{
		List<Bateau> bateaux = new ArrayList<>();
		for(Emplacement emplacement : quai.getListeEmplacements())
		{
			//Si l'emplacement possede un bateau
			if(emplacement.getBateau() != null)
			{
				bateaux.add(emplacement.getBateau());
			}
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
	
	class GestionQuaisListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			QuaiVue quaiVue = new QuaiVue(port);
		}
	}
	
	class GestionProprietairesListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new ProprietaireVue();
		}
	}
	
	class GestionEmplacementsListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Rien encore
		}
	}
	
	class AjouterBateauListener implements ActionListener
	{
		private JTextField nom = new JTextField();
		private JTextField poids = new JTextField();
		private JTextField prix = new JTextField();
		private JTextField type = new JTextField();
		private JComboBox<TypeDeBateau> categorie= new  JComboBox<TypeDeBateau>(TypeDeBateau.values());
		private JComboBox<Proprietaire> proprietaire = new JComboBox<Proprietaire>();
		private JComboBox<Emplacement> emplacement = new JComboBox<Emplacement>();
		private JLabel typeLabel = new JLabel("Surface voile");
		
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			Object[] fieldsAdd = {" Nom :", nom, 
					  "Poids :", poids,
					  "Categorie :", categorie,
					  typeLabel.getText()+" :", type, 
					  "Proprietaire :",	proprietaire,
					  "Emplacement :", emplacement, 
					  };
			
			categorie.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(categorie.getSelectedIndex() == 0)
					{
						 typeLabel.setText("Surface voile");
						 System.out.println("hello");
					}else
					{
						typeLabel.setText("Chevaux vapeur");
						typeLabel.repaint();
						typeLabel.updateUI();
						System.out.println("hi");
					}
						
					
				}
				
			});
			
			int option = JOptionPane.showConfirmDialog(null, fieldsAdd, "Ajouter bateau", JOptionPane.OK_CANCEL_OPTION);
			try {
				if (option == JOptionPane.OK_OPTION) 
				{
						/*String nomP = nom.getText();
						Categorie catP =categorie.getItemAt(categorie.getSelectedIndex());
						String espP = espece.getText();
						Double prixP = Double.valueOf(prix.getText().replace(",", "."));
						int quantiteP = Integer.parseInt(quantite.getText());
					
							if(prixP < 0 || quantiteP < 0){
							
								throw new Exception();
							} 
						
						
						Produit prod = new Produit(nomP,catP,espP,prixP,quantiteP);
						
						ProduitController.ajouterProduit(prod);
						
						modele.actualiserProduits();
						
						nom.setText(null);
						espece.setText(null);
						prix.setText(null);
						quantite.setText(null);*/
						
				}
			}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Nombre Negatif Interdit", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
		}
	}
}

