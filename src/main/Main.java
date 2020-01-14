package main;

import controleur.dao.QuaiDAO;
import controleur.dao.SetupEMDAO;
import modele.Emplacement;
import modele.Quai;
import vue.ApplicationPrincipaleVue;

public class Main {

	public static void main(String[] args) {
		new SetupEMDAO();
	    
	    //fenetre
	    new ApplicationPrincipaleVue();
		
	
	    
	    
	}

}
