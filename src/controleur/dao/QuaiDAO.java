package controleur.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modele.Port;
import modele.Quai;

public class QuaiDAO {
	
	/**
	 * Ajouter un quai au port
	 * @param code numero de quai
	 * @param nombreEmplacements nombre emplacement du quai
	 * @param port port du quai
	 */
	public static void ajouterQuai(int code, int nombreEmplacements, Port port){
		Quai quai = new Quai(code, nombreEmplacements, new ArrayList(), port);
		EntityManager em = SetupEM.getEm();
		em.getTransaction().begin();
		//Ajout du quai dans la BDD
		em.persist(quai);
		em.getTransaction().commit();
		
	}
	/**
	 * Modification d'un quai
	 * @param quai le quai modifier
	 */
	public static void modifierQuai(Quai quai){
		EntityManager em = SetupEM.getEm();
		em.getTransaction().begin();
		em.merge(quai);
		em.getTransaction().commit();
	}
	/**
	 * Supprimer un quai
	 * @param quai Quai a supprimer
	 */
	public static void supprimerQuai(Quai quai){
		EntityManager em = SetupEM.getEm();
		em.getTransaction().begin();
		em.remove(quai);
		em.getTransaction().commit();
		
	}
	/**
	 * Recuperer tous les quais du port
	 * @return liste de quai
	 */
	public static List<Quai> recupererTousLesQuaisDuPort(){
		Query requete = SetupEM.getEm().createQuery("from Quai");
		List<Quai> listeQuai = requete.getResultList();
		return listeQuai;
		
	}

}
