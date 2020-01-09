package modele;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idBateau")
public class BateauMoteur extends Bateau{
	
	private int nombreChevauxVapeur;

	 /**
	  * Constructeur de confort appelant le constructeur de confort de Bateau
	  * @param nom
	  * @param poids
	  * @param propietaire
	  * @param nombreChevauxVapeur
	  */
	public BateauMoteur(String nom, Double poids, Proprietaire propietaire, int nombreChevauxVapeur,Emplacement emplacement) {
		super(nom, poids, propietaire, emplacement);
		this.nombreChevauxVapeur = nombreChevauxVapeur;
	}
	
	/**
	 * Constructeur par defaut appelant le constructeur par defaut de Bateau
	 */
	public BateauMoteur() {
		super();
		this.nombreChevauxVapeur = 0;
	}

	//Getter et setter
	public int getNombreChevauxVapeur() {
		return nombreChevauxVapeur;
	}

	public void setNombreChevauxVapeur(int nombreChevauxVapeur) {
		this.nombreChevauxVapeur = nombreChevauxVapeur;
	}
}
