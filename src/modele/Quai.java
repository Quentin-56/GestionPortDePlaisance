package modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Quai {
	
	@Id
	private int code;
	
	private int nombreEmplacements;
	
	@OneToMany(
			mappedBy = "quai",
			cascade = CascadeType.ALL
	)
	private List<Emplacement> listeEmplacements;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Port port;
	
	/**
	 * Constructeur de confort
	 * @param code
	 * @param nombreEmplacements
	 * @param listeEmplacements
	 * @param port
	 */
	public Quai(int code, int nombreEmplacements, List<Emplacement> listeEmplacements, Port port) {
		this.code = code;
		this.nombreEmplacements = nombreEmplacements;
		this.listeEmplacements = listeEmplacements;
		this.port = port;
	}
	
	/**
	 * Constructeur par defaut
	 */
	public Quai() {
		this.code = 0;
		this.nombreEmplacements = 0;
		this.listeEmplacements = listeEmplacements;
		this.port = port;
	}
	
	//Getters et setters
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getNombreEmplacements() {
		return nombreEmplacements;
	}
	public void setNombreEmplacements(int nombreEmplacements) {
		this.nombreEmplacements = nombreEmplacements;
	}
	public List<Emplacement> getListeEmplacements() {
		return listeEmplacements;
	}
	public void setListeEmplacements(List<Emplacement> listeEmplacements) {
		this.listeEmplacements = listeEmplacements;
	}
	public Port getPort() {
		return port;
	}
	public void setPort(Port port) {
		this.port = port;
	}
	
	
	

}
