package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controleur.dao.ProprietaireDAO;
import controleur.dao.SetupEM;
import vue.ProprietaireVue;

public class Main {

	public static void main(String[] args) {
		new SetupEM();
	    ProprietaireDAO.ajouterProprietaire("Patrick", "Rue des Patricks");
	    new ProprietaireVue();
	}

}
