package controleur.controleurVue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.ProprietaireVue;

public class ProprietaireControleurVue {
	
	public ProprietaireControleurVue(){
		ProprietaireVue.ajouterListener(new AjouterListener());
		ProprietaireVue.modifierListener(new ModifierListener());
		ProprietaireVue.supprimerListener(new SupprimerListener());
	}
	
	class AjouterListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class ModifierListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class SupprimerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
