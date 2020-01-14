package main;

import javax.persistence.EntityManager;

import controleur.dao.BateauMoteurDAO;
import controleur.dao.EmplacementDAO;
import controleur.dao.PortDAO;
import controleur.dao.ProprietaireDAO;
import controleur.dao.QuaiDAO;
import controleur.dao.SetupEMDAO;
import controleur.dao.VoilierDAO;
import modele.Emplacement;
import modele.Port;
import modele.Proprietaire;
import modele.Quai;

public class MainBDD {
	
	public static void main(String[] args) {
		
		new SetupEMDAO();
		
		EntityManager em = SetupEMDAO.getEm();
		
		//Creation du port
		PortDAO.creationDuPort();
		Port port = PortDAO.retournerPort();
		
		//Creation de 3 quais
		QuaiDAO.ajouterQuai(1, 3, port);
		Quai quai1 = em.find(Quai.class, 1);
		
		QuaiDAO.ajouterQuai(2, 4, port);
		Quai quai2 = em.find(Quai.class, 2);
		
		QuaiDAO.ajouterQuai(3, 3, port);
		Quai quai3 = em.find(Quai.class, 3);
		
		//Affectation d'emplacements aux quais
		EmplacementDAO.ajouterEmplacement(1, 3, quai1);
		Emplacement e1 = EmplacementDAO.trouverEmplacementAvecSonCode(1);
		
		EmplacementDAO.ajouterEmplacement(2, 4, quai1);
		Emplacement e2 = EmplacementDAO.trouverEmplacementAvecSonCode(2);
		
		EmplacementDAO.ajouterEmplacement(3, 3, quai1);
		
		
		EmplacementDAO.ajouterEmplacement(4, 2, quai2);
		Emplacement e4 = EmplacementDAO.trouverEmplacementAvecSonCode(4);
		
		EmplacementDAO.ajouterEmplacement(5, 3, quai2);
		
		EmplacementDAO.ajouterEmplacement(6, 4, quai3);
		EmplacementDAO.ajouterEmplacement(7, 3, quai3);
		
		//Creation des proprietaires
		ProprietaireDAO.ajouterProprietaire("Colin", "Agen");
		Proprietaire p1 = ProprietaireDAO.trouverProprietaireAvecSonId(1);
		
		ProprietaireDAO.ajouterProprietaire("Flo", "Tours");
		Proprietaire p2 = ProprietaireDAO.trouverProprietaireAvecSonId(2);
		
		ProprietaireDAO.ajouterProprietaire("Quentin", "Lorient");
		Proprietaire p3 = ProprietaireDAO.trouverProprietaireAvecSonId(3);
		
		ProprietaireDAO.ajouterProprietaire("Colin", "Caen");
		Proprietaire p4 = ProprietaireDAO.trouverProprietaireAvecSonId(4);
		
		//Creation des bateaux
		BateauMoteurDAO.ajouterBateauMoteur("Gambetta", 300.0, p1, 200, e1);
		BateauMoteurDAO.ajouterBateauMoteur("Titanic", 3000.0, p2, 500, e2);
		
		VoilierDAO.ajouterVoilier("Flipper", 1000.0, p3, 400.0, e4);
		
	}
}
