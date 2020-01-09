package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import vue.ProprietaireVue;

public class Main {

	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("portDePlaisance");
	     EntityManager em = emf.createEntityManager();
	     new ProprietaireVue();
	}

}
