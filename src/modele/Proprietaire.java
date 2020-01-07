package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Proprietaire {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idProprietaire;
	
	private String nom;
	private String adresse;
	
	@OneToMany(
			mappedBy = "propietaire",
			cascade = CascadeType.ALL
	)
	private List<Bateau> listeDeBateaux;
	
	/**
	 * Constructeur de confort
	 * @param nom
	 * @param adresse
	 * @param listeDeBateaux
	 */
	public Proprietaire(String nom, String adresse, List<Bateau> listeDeBateaux) {
		this.nom = nom;
		this.adresse = adresse;
		this.listeDeBateaux = listeDeBateaux;
	}
	
	/**
	 * Constructeur par defaut
	 */
	public Proprietaire() {
		this.nom = "";
		this.adresse = "";
		this.listeDeBateaux = new ArrayList<>();
	}
	
	//Getters et setters
	public int getIdProprietaire() {
		return idProprietaire;
	}
	public void setIdProprietaire(int idProprietaire) {
		this.idProprietaire = idProprietaire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Bateau> getListeDeBateaux() {
		return listeDeBateaux;
	}
	public void setListeDeBateaux(List<Bateau> listeDeBateaux) {
		this.listeDeBateaux = listeDeBateaux;
	}
	
	
	

}
