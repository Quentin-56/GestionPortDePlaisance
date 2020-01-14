package controleur.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.dao.BateauDAO;
import controleur.dao.BateauMoteurDAO;
import controleur.dao.EmplacementDAO;
import controleur.dao.ProprietaireDAO;
import controleur.dao.VoilierDAO;
import modele.Bateau;
import modele.BateauMoteur;
import modele.Emplacement;
import modele.Proprietaire;
import modele.Quai;
import modele.Voilier;
import vue.ApplicationPrincipaleVue;
import vue.EditerBateauVue;

public class EditerBateauControleur {
	
	private JTextField nom;
	private JTextField poids;
	private JTextField typeTF;
	private JComboBox<Proprietaire> proprietaire;
	private JComboBox<Emplacement> emplacement;
	private JLabel typeLabel;
	private EditerBateauVue maFenetre;
	private JPanel centerPanel;
	private JComboBox<TypeDeBateau> type;
	private Bateau bateau;

	
	public EditerBateauControleur(JTextField nom,JTextField poids,JTextField typeTF,JComboBox<Proprietaire> proprietaire,
			JComboBox<Emplacement> emplacement,JLabel typeLabel,EditerBateauVue maFenetre,JPanel centerPanel,
			JComboBox<TypeDeBateau> type, Bateau bateau) {
		
		EditerBateauVue.comboboxListener(new ComboboxListener());
		EditerBateauVue.annulerListener(new AnnulerBateauListener());
		EditerBateauVue.validerListener(new ValiderBateauListener());
		EditerBateauVue.modifierListener(new ModifierBateauListener());
		
		this.nom = nom;
		this.poids = poids;
		this.typeTF = typeTF;
		this.proprietaire = proprietaire;
		this.emplacement = emplacement;
		this.typeLabel = typeLabel;
		this.maFenetre = maFenetre;
		this.centerPanel = centerPanel;
		this.type = type;
		this.bateau = bateau;
		
		remplirProprietaire();
		remplirEmplacement();
		
		if(bateau != null)
		{
			nom.setText(bateau.getNom());
			poids.setText(bateau.getPoids()+"");
			proprietaire.setSelectedItem(bateau.getPropietaire());
			emplacement.addItem(bateau.getEmplacement());
			emplacement.setSelectedItem(bateau.getEmplacement());
			
			//Si est un voilier sinon est un bateau a moteur
			if(BateauDAO.estUnVoilier(bateau))
			{
				Voilier voilier = VoilierDAO.trouverVoilierAvecSonId(bateau.getIdBateau());
				type.removeItem(TypeDeBateau.BateauAMoteur);
				typeTF.setText(voilier.getSurfaceTotaleVoile()+"");
			}else
			{
				type.removeItem(TypeDeBateau.BateauAVoile);
				typeLabel.setText("Nombre de chevaux vapeur :");
				BateauMoteur bateauMoteur = BateauMoteurDAO.trouverBateauMoteurAvecSonId(bateau.getIdBateau());
				typeTF.setText(bateauMoteur.getNombreChevauxVapeur()+"");
			}
		}
	}
	
	public void remplirProprietaire()
	{
		List<Proprietaire> proprietaires = ProprietaireDAO.recupererTousLesProprietaires();
		for(Proprietaire proprio : proprietaires)
		{
			proprietaire.addItem(proprio);
		}
	}
	
	public void remplirEmplacement()
	{
		Quai quaiCourant = (Quai) ApplicationPrincipaleVue.getComboboxQuais().getSelectedItem();
		List<Emplacement> emplacements = EmplacementDAO.recupererLesEmplacementsDunQuai(quaiCourant);
		for(Emplacement emp : emplacements)
		{
			if(emp.getBateau() == null)
			{
				emplacement.addItem(emp);
			}
		}
	}
	
	class ValiderBateauListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try {
				String nomBateau = nom.getText();
				double poidsBateau = Double.parseDouble(poids.getText());
				Proprietaire proprietaireBateau = (Proprietaire)proprietaire.getSelectedItem();
				Emplacement emplacementBateau = (Emplacement) emplacement.getSelectedItem();
				
				
				if(type.getSelectedItem().equals(TypeDeBateau.BateauAMoteur))
				{
					int moteur = Integer.parseInt(typeTF.getText());
					BateauMoteurDAO.ajouterBateauMoteur(nomBateau, poidsBateau, proprietaireBateau, moteur, emplacementBateau);
				}
				else {
					double voile = Double.parseDouble(typeTF.getText());
					VoilierDAO.ajouterVoilier(nomBateau, poidsBateau, proprietaireBateau, voile, emplacementBateau);
				}
				
				Bateau bateau = BateauDAO.retournerBateauDeLEmplacement(emplacementBateau);
				emplacementBateau.setBateau(bateau);
				
				maFenetre.dispose();
				ApplicationPrincipaleVue.getModele().refresh();
				ApplicationPrincipaleControleur.actualiserTexte(bateau.getEmplacement().getQuai());
				
				
			}catch(NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "Champ(s) vide(s) ou incorrect(s)","Erreur de saisie",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class AnnulerBateauListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			maFenetre.dispose();
		}
	}
	
	class ComboboxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(type.getSelectedItem().equals(TypeDeBateau.BateauAMoteur))
			{
				typeLabel.setText("Nombre de chevaux vapeur :");
			}
			else {
				typeLabel.setText("Surface totale de la voile  :");
			}
			
			centerPanel.repaint();
			centerPanel.updateUI();
			
			maFenetre.pack();
		}
	}
	
	class ModifierBateauListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try {
				String nomBateau = nom.getText();
				double poidsBateau = Double.parseDouble(poids.getText());
				Proprietaire proprietaireBateau = (Proprietaire)proprietaire.getSelectedItem();
				Emplacement emplacementBateau = (Emplacement) emplacement.getSelectedItem();
				boolean emplacementEstModifie = false;
				Emplacement emplacementActuel = bateau.getEmplacement();
				
				if(emplacementBateau.getCode() != bateau.getEmplacement().getCode())
				{
					emplacementEstModifie = true;
				}
				
				if(type.getSelectedItem().equals(TypeDeBateau.BateauAMoteur))
				{
					int moteur = Integer.parseInt(typeTF.getText());
					
					BateauMoteur bateauMoteur = new BateauMoteur(nomBateau, poidsBateau, proprietaireBateau, moteur, emplacementBateau);
					bateauMoteur.setIdBateau(bateau.getIdBateau());
					BateauMoteurDAO.modifierBateauMoteur(bateauMoteur);  
				}
				else {
					double voile = Double.parseDouble(typeTF.getText());
					
					Voilier voilier = new Voilier(nomBateau, poidsBateau, proprietaireBateau, voile, emplacementBateau);
					voilier.setIdBateau(bateau.getIdBateau());
					VoilierDAO.modifierVoilier(voilier);
				}
				
				Bateau bateau = BateauDAO.retournerBateauDeLEmplacement(emplacementBateau);
				emplacementBateau.setBateau(bateau);
				
				//Changement d'emplacement du bateau
				if(emplacementEstModifie)
				{
					emplacementActuel.setBateau(null);
				}
				
				maFenetre.dispose();
				ApplicationPrincipaleVue.getModele().refresh();
			}catch(NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "Champ(s) vide(s) ou incorrect(s)","Erreur de saisie",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
