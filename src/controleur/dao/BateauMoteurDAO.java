package controleur.dao;

import javax.persistence.EntityManager;

import modele.BateauMoteur;
import modele.Emplacement;
import modele.Proprietaire;

public class BateauMoteurDAO {

	/**
	 * Creer un bateau a moteur 
	 * @param nom
	 * @param poids
	 * @param proprietaire
	 * @param nombreChevauxVapeur
	 * @param emplacement
	 */
	public static void ajouterBateauMoteur(String nom, Double poids, Proprietaire proprietaire, int nombreChevauxVapeur,Emplacement emplacement) {
		BateauMoteur bateauMoteur = new BateauMoteur(nom, poids, proprietaire, nombreChevauxVapeur, emplacement);
		EntityManager em = SetupEMDAO.getEm();
		em.getTransaction().begin();
		// Ajout du proprio dans la bdd
		em.persist(bateauMoteur);
		em.getTransaction().commit();
	}

	/**
	 * Modifier un bateau a moteur 
	 * @param bateauMoteur
	 */
	public static void modifierBateauMoteur(BateauMoteur bateauMoteur) {

		EntityManager em = SetupEMDAO.getEm();

		em.getTransaction().begin();

		em.merge(bateauMoteur);

		em.getTransaction().commit();
	}

	/**
	 * Supprimer un bateau a moteur
	 * @param bateauMoteur
	 */
	public static void supprimerBateauMoteur(BateauMoteur bateauMoteur) {
		EntityManager em = SetupEMDAO.getEm();
		em.getTransaction().begin();

		em.remove(bateauMoteur);

		em.getTransaction().commit();
	}

	/**
	 * Permet de retourner un bateau moteur avec un id
	 * @param idBateau
	 * @return le bateau moteur associe a l'id
	 */
	public static BateauMoteur trouverBateauMoteurAvecSonId(int idBateau) {
		EntityManager em = SetupEMDAO.getEm();
		em.getTransaction().begin();

		BateauMoteur bateauMoteur = em.find(BateauMoteur.class, idBateau);

		em.getTransaction().commit();

		return bateauMoteur;
	}
}
