package controleur.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modele.Bateau;
import modele.Emplacement;
import modele.Proprietaire;
import modele.Quai;

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
	public static List<Bateau> recupererLesBateauxs(){
		Query requete = SetupEM.getEm().createQuery("from Bateau ");
		List<Bateau> listeBateau = requete.getResultList();
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

	/**
	 * Recuperer le nombre de voilier d'un quai
	 * @param quai
	 * @return
	 */
	public static int recupererNbVoilierDunQuai(Quai quai){
		Query requete = SetupEM.getEm().createQuery("from Voilier v where v.emplacement in ( select e from Emplacement e where e.quai = ?1)");
		requete.setParameter(1, quai);
		return requete.getResultList().size();
	}
	/**
	 * Recuperer le nombre de bateau moteur d'un quai
	 * @param quai
	 * @return
	 */
	public static int recupererNbBateauMoteurDunQuai(Quai quai){
		Query requete = SetupEM.getEm().createQuery("from BateauMoteur v where v.emplacement in ( select e from Emplacement e where e.quai = ?1)");
		requete.setParameter(1, quai);
		return requete.getResultList().size();
	}
	
	public static boolean estUnVoilier(Bateau bateau)
	{
		Query requete = SetupEM.getEm().createQuery("from Voilier v WHERE v.idBateau = ?1");
		requete.setParameter(1, bateau.getIdBateau());

		if(requete.getResultList().size() == 0)
		{
			return false;
		}else
		{
			return true;
		}
	}
}
