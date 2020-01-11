package modele;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Emplacement {
	
	@Id
	private int code;
	
	private double taille;
	
	@OneToOne(mappedBy = "emplacement",fetch = FetchType.LAZY, orphanRemoval = true)
	private Bateau bateau;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Quai quai;
	/**
	 * Constructeur de confort
	 * @param code
	 * @param taille
	 * @param bateau
	 * @param quai
	 */
	public Emplacement(int code, double taille, Bateau bateau, Quai quai) {
		this.taille = taille;
		this.bateau = bateau;
		this.quai = quai;
		this.code = code;
	}

	/**
	 * Constructeur par defaut
	 */
	public Emplacement() {
		this.taille = 0.0;
		this.bateau = null;
		this.quai = null;
		this.code = 0;
	}
	
	

	@Override
	public String toString() {
		return "Numero "+ code;
	}

	//Getters et setters
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	public Quai getQuai() {
		return quai;
	}

	public void setQuai(Quai quai) {
		this.quai = quai;
	}
}