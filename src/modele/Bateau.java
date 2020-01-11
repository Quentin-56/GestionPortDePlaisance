package modele;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Bateau {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBateau;
	
	private String nom;
	private Double poids;
	
	@OneToOne
	private Emplacement emplacement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Proprietaire propietaire;
	
	/**
	 * Constructeur de confort
	 * @param nom
	 * @param poids
	 * @param propietaire
	 */
	public Bateau(String nom, Double poids, Proprietaire propietaire,Emplacement emplacement) {
		this.nom = nom;
		this.poids = poids;
		this.propietaire = propietaire;
		this.emplacement = emplacement;
	}

	
	/**
	 * Constructeur par defaut
	 */
	public Bateau() {
		this.nom = "";
		this.poids = 0.0;
		this.propietaire = null;
		this.emplacement = null;
	}


	@Override
	public String toString() {
		return "Bateau [idBateau=" + idBateau + ", nom=" + nom + ", poids=" + poids + "]";
	}


	//Getters et setters
	public int getIdBateau() {
		return idBateau;
	}

	public void setIdBateau(int idBateau) {
		this.idBateau = idBateau;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}

	public Proprietaire getPropietaire() {
		return propietaire;
	}

	public void setPropietaire(Proprietaire propietaire) {
		this.propietaire = propietaire;
	}


	public Emplacement getEmplacement() {
		return emplacement;
	}


	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	}
}
