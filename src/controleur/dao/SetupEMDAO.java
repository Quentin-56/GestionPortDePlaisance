package controleur.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SetupEMDAO {

    private static EntityManager em;

    public SetupEMDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("portDePlaisance");
        em = emf.createEntityManager();
    }
    
    /**
     * Permet de fermer l'entity manager
     */
    public static void closeEntityManager()
    {
    	em.close();
    }

    //Getters et setters
    public static EntityManager getEm() {
        return em;
    }

    public static void setEm(EntityManager em) {
        SetupEMDAO.em = em;
    }
}