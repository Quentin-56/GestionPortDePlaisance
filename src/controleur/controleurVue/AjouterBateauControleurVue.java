package controleur.controleurVue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.dao.BateauMoteurDAO;
import controleur.dao.EmplacementDAO;
import controleur.dao.ProprietaireDAO;
import controleur.dao.VoilierDAO;
import modele.Emplacement;
import modele.Proprietaire;
import modele.Quai;
import vue.AjouterBateauVue;
import vue.ApplicationPrincipaleVue;

public class AjouterBateauControleurVue {
	
	private JTextField nom;
	private JTextField poids;
	private JTextField typeTF;
	private JComboBox<Proprietaire> proprietaire;
	private JComboBox<Emplacement> emplacement;
	private JLabel typeLabel;
	private AjouterBateauVue maFenetre;
	private JPanel centerPanel;
	private JComboBox<TypeDeBateau> type;

	
	public AjouterBateauControleurVue(JTextField nom,JTextField poids,JTextField typeTF,JComboBox<Proprietaire> proprietaire,
			JComboBox<Emplacement> emplacement,JLabel typeLabel,AjouterBateauVue maFenetre,JPanel centerPanel,
			JComboBox<TypeDeBateau> type) {
		
		AjouterBateauVue.comboboxListener(new ComboboxListener());
		AjouterBateauVue.annulerListener(new AnnulerBateauListener());
		AjouterBateauVue.validerListener(new ValiderBateauListener());
		
		this.nom = nom;
		this.poids = poids;
		this.typeTF = typeTF;
		this.proprietaire = proprietaire;
		this.emplacement = emplacement;
		this.typeLabel = typeLabel;
		this.maFenetre = maFenetre;
		this.centerPanel = centerPanel;
		this.type = type;
		
		remplirProprietaire();
		remplirEmplacement();
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
		System.out.println(emplacements);
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
			
			maFenetre.dispose();
			ApplicationPrincipaleVue.getModele().refresh();
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
}
