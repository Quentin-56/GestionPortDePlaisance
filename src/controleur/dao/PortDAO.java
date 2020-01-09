package controleur.dao;

import javax.persistence.EntityManager;

import modele.Port;

public class PortDAO {
	/**
	 * Creation du port 
	 */
	public static void creationDuPort(){
		Port port = new Port();
		EntityManager em =SetupEM.getEm();
		em.getTransaction().begin();
	    //Ajout du proprio dans la bdd
	    em.persist(port);
	    em.getTransaction().commit(); 
		
	    
	}
}
