package controleur.dao;

import javax.persistence.EntityManager;

import modele.Port;
import modele.Proprietaire;

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
	
	/**
	 * Retourner le port, celui ci est unique
	 * @return le port
	 */
	public static Port retournerPort()
	{
		EntityManager em = SetupEM.getEm();
        em.getTransaction().begin();

        Port port = em.find(Port.class, 1);

        em.getTransaction().commit();
        
        return port;
	}
}
