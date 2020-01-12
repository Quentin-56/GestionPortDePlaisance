package controleur.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modele.Bateau;
import modele.Emplacement;
import modele.Proprietaire;

public class BateauDAO {
	/**
	 * Ajouter un bateau
	 * @param nom nom du bateau
	 * @param poids poids du bateau
	 * @param emplacement son emplacement
	 * @param proprietaire son proprietaire
	 */
	public static void ajouterBateau(String nom, Double poids, Emplacement emplacement, Proprietaire proprietaire ){
		Bateau bateau = new Bateau(nom,poids,proprietaire,emplacement);
		EntityManager em = SetupEM.getEm();
		em.getTransaction().begin();
		em.persist(bateau);
		em.getTransaction().commit();
		
	}
	/**
	 * Modifier un bateau
	 * @param bateau le bateau modifie
	 */
	public static void modifierBateau(Bateau bateau){		
		EntityManager em =SetupEM.getEm();
		
	    em.getTransaction().begin();
	    
	    em.merge(bateau);
	    
	    em.getTransaction().commit();		
	}
	/**
	 * Supprimer un Bateau
	 * @param quai Bateau a supprimer
	 */
	public static void supprimerBateau(Bateau bateau){
		EntityManager em = SetupEM.getEm();
		em.getTransaction().begin();
		em.remove(bateau);
		em.getTransaction().commit();
		
	}
	/**
	 * Recuperer tous les bateaux
	 * @return liste des bateaux
	 */
	public static List<Emplacement> recupererLesEmplacementsDunQuai(){
		Query requete = SetupEM.getEm().createQuery("from Bateau ");
		List<Emplacement> listeBateau = requete.getResultList();
		return listeBateau;		
	}
	
	/**
	 * Retourner le bateau se trouvant a un emplacement donne
	 * @param emplacement
	 * @return le bateau
	 */
	public static Bateau retournerBateauDeLEmplacement(Emplacement emplacement)
	{
		Query requete = SetupEM.getEm().createQuery("from Bateau b WHERE b.emplacement = ?1");
		requete.setParameter(1, emplacement);
		return (Bateau) requete.getSingleResult();
	}
	
}
