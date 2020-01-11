package modele;

import javax.persistence.Entity;

@Entity
public class Voilier extends Bateau{
	
	private double surfaceTotaleVoile;

	/**
	 * Constructeur de confort appelant le constructeur de confort de Bateau
	 * @param nom
	 * @param poids
	 * @param propietaire
	 * @param surfaceTotaleVoile
	 */
	public Voilier(String nom, Double poids, Proprietaire propietaire, double surfaceTotaleVoile,Emplacement emplacement) {
		super(nom, poids, propietaire, emplacement);
		this.surfaceTotaleVoile = surfaceTotaleVoile;
	}

	public Voilier() {
		super();
		this.surfaceTotaleVoile = 0.0;
	}
	
	//Getter et setter
	public double getSurfaceTotaleVoile() {
		return surfaceTotaleVoile;
	}

	public void setSurfaceTotaleVoile(double surfaceTotaleVoile) {
		this.surfaceTotaleVoile = surfaceTotaleVoile;
	}
	
	
	
	

}
