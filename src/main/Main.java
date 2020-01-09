package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controleur.dao.PortDAO;
import controleur.dao.ProprietaireDAO;
import controleur.dao.SetupEM;
import modele.Proprietaire;
import vue.ProprietaireVue;

public class Main {

	public static void main(String[] args) {
		new SetupEM();
	    
	    //fenetre
	    //new ProprietaireVue();
		
		Proprietaire flo  = ProprietaireDAO.trouverProprietaireAvecSonId(2);
		
		System.out.println(flo.getListeDeBateaux());
	    
	    
	}

}
