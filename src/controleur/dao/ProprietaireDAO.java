package controleur.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modele.Proprietaire;

public class ProprietaireDAO {
	
	/**
	 * Creer un proprietaire dans la BDD
	 * @param nom nom du proprio
	 * @param adresse adresse du proprio
	 */
	public static void ajouterProprietaire(String nom, String adresse){
		Proprietaire proprio = new Proprietaire(nom, adresse, new ArrayList());
		EntityManager em =SetupEMDAO.getEm();
	    em.getTransaction().begin();
	    //Ajout du proprio dans la bdd
	    em.persist(proprio);
	    em.getTransaction().commit();
	}
	/**
	 * Modifier un proprietaire
	 * @param proprio le proprietaire modifie
	 */
	public static void modifierProprietaire(Proprietaire proprio){

		EntityManager em = SetupEMDAO.getEm();

	    em.getTransaction().begin();
	        
	    em.merge(proprio);
	        
	    em.getTransaction().commit();
	}
	/**
	 * Supprimer un proprietaire
	 * @param idProprioASupprimer
	 */
	public static void supprimerProprietaire(Proprietaire proprio){
		EntityManager em =SetupEMDAO.getEm();
        em.getTransaction().begin();

        em.remove(proprio);

        em.getTransaction().commit();
	}
	/**
	 * Trouver proprietaire avec son id
	 * @param idProprio
	 * @return Proprietaire
	 */
	public static Proprietaire trouverProprietaireAvecSonId(int idProprio){
		EntityManager em =SetupEMDAO.getEm();
        em.getTransaction().begin();

        Proprietaire proprio = em.find(Proprietaire.class, idProprio);

        em.getTransaction().commit();
        
        return proprio;
	}
	/**
	 * Recuperer tous les proprietaires
	 * @return liste de proprietaire
	 */
	public static List<Proprietaire> recupererTousLesProprietaires(){
		Query requete = SetupEMDAO.getEm().createQuery("from Proprietaire");
	    List<Proprietaire> listeProprio =requete.getResultList();
	    return listeProprio;

	}
}
