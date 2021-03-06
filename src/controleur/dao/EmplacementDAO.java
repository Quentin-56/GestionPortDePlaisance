package controleur.dao;


import java.util.List;

import javax.persistence.EntityManager;


import javax.persistence.Query;

import modele.Bateau;
import modele.Emplacement;
import modele.Quai;

public class EmplacementDAO {
	/**
	 * Creer un emplacement 
	 * @param code code de l'emplacement
	 * @param taille taille de l'emplacement
	 * @param bateau bateau associe a l'emplacement 
	 * @param quai quai de l'emplacement
	 */
	public static void ajouterEmplacement(int code, double taille, Quai quai){
		Emplacement emplacement = new Emplacement(code, taille, null, quai);
		EntityManager em = SetupEMDAO.getEm();
		em.getTransaction().begin();
		em.persist(emplacement);
		em.getTransaction().commit();
		
	}
	/**
	 * Modifier un emplacement
	 * @param emplacement emplacement modifie
	 */
	public static void modifierEmplacement(Emplacement emplacement){
		EntityManager em = SetupEMDAO.getEm();
		em.getTransaction().begin();
		em.merge(emplacement);
		em.getTransaction().commit();
	}
	/**
	 * Supprimer un emplacement
	 * @param quai Emplacement a supprimer
	 */
	public static void supprimerEmplacement(Emplacement emplacement){
		EntityManager em = SetupEMDAO.getEm();
		em.getTransaction().begin();
		em.remove(emplacement);
		em.getTransaction().commit();
		
	}
	/**
	 * Recuperer tous les emplacements d'un quai
	 * @param quai quai selectione
	 * @return liste d'emplacement
	 */
	public static List<Emplacement> recupererLesEmplacementsDunQuai(Quai quai){
		Query requete = SetupEMDAO.getEm().createQuery("from Emplacement e where e.quai = ?1");
		requete.setParameter(1, quai);
		List<Emplacement> listeEmplacement = requete.getResultList();
		return listeEmplacement;		
	}
	/**
	 * Recuperer le nombre d'emplacement cree dans un quai
	 * @param quai quai selectione
	 * @return nombre d'emplacements cree
	 */
	public static int recupererNombreEmplacementCreeDansQuai(Quai quai){
		Query requete = SetupEMDAO.getEm().createQuery("from Emplacement e where e.quai = ?1");
		requete.setParameter(1, quai);
		return requete.getResultList().size();
	}
	
	/**
	 * Retourner le nombre d'emplacements occupe dans un quai
	 * @param quai
	 * @return le nombre d'emplacement occupe
	 */
	public static int recupererNombreEmplacementOccupeDansQuai(Quai quai)
	{
		Query requete = SetupEMDAO.getEm().createQuery("FROM Emplacement e INNER JOIN Bateau b ON e.bateau = b.emplacement where e.quai = ?1");
		requete.setParameter(1, quai);
		return requete.getResultList().size();
	}
	
	/**
	 * Retourner un emplacement connaissant son code
	 * @param code
	 * @return l'emplacement associe au code
	 */
	public static Emplacement trouverEmplacementAvecSonCode(int code){
		EntityManager em = SetupEMDAO.getEm();
        em.getTransaction().begin();

        Emplacement emplacement = em.find(Emplacement.class, code);

        em.getTransaction().commit();
        
        return emplacement;
	}

	/**
	 * Permet de savoir si un emplacement existe d�j� dans la base
	 * @param code code de l'emplacement
	 * @return Vrai il existe Faux sinon
	 */
	public static Boolean estUnEmplacement(int code){
		Query requete = SetupEMDAO.getEm().createQuery("from Emplacement e where e.code = ?1");
		requete.setParameter(1, code);
		if(requete.getResultList().isEmpty()){
			return false;
		}
		return true;
	}	
}
