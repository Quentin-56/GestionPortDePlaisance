package controleur.dao;

import javax.persistence.EntityManager;

import modele.BateauMoteur;
import modele.Emplacement;
import modele.Proprietaire;
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
		EntityManager em = SetupEM.getEm();
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

		EntityManager em = SetupEM.getEm();

		em.getTransaction().begin();

		em.merge(voilier);

		em.getTransaction().commit();
	}

	/**
	 * Supprimer un voilier
	 * @param voilier
	 */
	public static void supprimerVoilier(Voilier voilier) {
		EntityManager em = SetupEM.getEm();
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
		EntityManager em = SetupEM.getEm();
		em.getTransaction().begin();

		Voilier voilier = em.find(Voilier.class, idVoilier);

		em.getTransaction().commit();

		return voilier;
	}
}
