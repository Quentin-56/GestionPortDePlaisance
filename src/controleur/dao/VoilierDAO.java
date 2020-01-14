package controleur.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modele.Emplacement;
import modele.Proprietaire;
import modele.Quai;
import modele.Voilier;

public class VoilierDAO {
	
	/**
	 * Creer un voilier 
	 * @param nom
	 * @param poids
	 * @param proprietaire
	 * @param surfaceTotaleVoile
	 * @param emplacement
	 */
	public static void ajouterVoilier(String nom, Double poids, Proprietaire proprietaire, double surfaceTotaleVoile,Emplacement emplacement) {
		 Voilier voilier = new Voilier(nom, poids, proprietaire, surfaceTotaleVoile, emplacement);
		EntityManager em = SetupEMDAO.getEm();
		em.getTransaction().begin();
		// Ajout du proprio dans la bdd
		em.persist(voilier);
		em.getTransaction().commit();
	}

	/**
	 * Modifier un voilier
	 * @param voilier
	 */
	public static void modifierVoilier(Voilier voilier) {

		EntityManager em = SetupEMDAO.getEm();

		em.getTransaction().begin();

		em.merge(voilier);

		em.getTransaction().commit();
	}

	/**
	 * Supprimer un voilier
	 * @param voilier
	 */
	public static void supprimerVoilier(Voilier voilier) {
		EntityManager em = SetupEMDAO.getEm();
		em.getTransaction().begin();

		em.remove(voilier);

		em.getTransaction().commit();
	}

	/**
	 * Permet de retourner un voilier avec un id
	 * @param idVoilier
	 * @return le voilier associe a l'id
	 */
	public static Voilier trouverVoilierAvecSonId(int idVoilier) {
		EntityManager em = SetupEMDAO.getEm();
		em.getTransaction().begin();

		Voilier voilier = em.find(Voilier.class, idVoilier);

		em.getTransaction().commit();

		return voilier;
	}
	
	/**
	 * Recupere les voiliers ayant une surface total de voile superieur a la valeur saisie
	 * @param valeur
	 * @param quai
	 * @return la liste des voiliers
	 */
	public static List<Voilier> trouverVoilierAvecSurfaceDeVoileSuperieureAValeur(double valeur, Quai quai)
	{
		Query requete = SetupEMDAO.getEm().createQuery("From Voilier v where v.surfaceTotaleVoile > ?1 and v.emplacement  in (select e from Emplacement e where e.quai =?2)" + 
				"");
		requete.setParameter(2, quai);
		requete.setParameter(1, valeur);
		return requete.getResultList();
	}
}
