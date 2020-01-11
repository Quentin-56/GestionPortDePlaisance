package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Port {
	
	@Id
    @GeneratedValue
	private int idPort;
	
	@OneToMany(
			mappedBy = "port",
			orphanRemoval = true
	)
	private List<Quai> listeDeQuais;
	
	/**
	 * Constructeur de confort
	 * @param listeDeQuais
	 */
	public Port(List<Quai> listeDeQuais) {
		super();
		this.listeDeQuais = listeDeQuais;
	}
	
	/**
	 * Constructeur par defaut
	 */
	public Port() {
		this.listeDeQuais = new ArrayList<>();
	}

	//Getters et setters
	public int getIdPort() {
		return idPort;
	}

	public void setIdPort(int idPort) {
		this.idPort = idPort;
	}

	public List<Quai> getListeDeQuais() {
		return listeDeQuais;
	}

	public void setListeDeQuais(List<Quai> listeDeQuais) {
		this.listeDeQuais = listeDeQuais;
	}
	
	

}
