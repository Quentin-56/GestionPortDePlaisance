package main;

import controleur.dao.QuaiDAO;
import controleur.dao.SetupEM;
import modele.Emplacement;
import modele.Quai;
import vue.ApplicationPrincipaleVue;

public class Main {

	public static void main(String[] args) {
		new SetupEM();
	    
	    //fenetre
	    new ApplicationPrincipaleVue();
		
	
	    
	    
	}

}
