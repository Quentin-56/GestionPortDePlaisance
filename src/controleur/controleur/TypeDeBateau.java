package controleur.controleur;

public enum TypeDeBateau {
	BateauAVoile("Voilier"),
	BateauAMoteur("Bateau a moteur");
	
	private String typeDeBateau;
	
	private TypeDeBateau(String typeDeBateau){
		this.typeDeBateau = typeDeBateau;
	}

	public String getTypeDeBateau() {
		return typeDeBateau;
	}

	public void setTypeDeBateau(String typeDeBateau) {
		this.typeDeBateau = typeDeBateau;
	}
	
}
