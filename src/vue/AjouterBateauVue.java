package vue;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.controleurVue.TypeDeBateau;
import modele.Emplacement;
import modele.Proprietaire;

public class AjouterBateauVue extends JDialog {

	private JPanel centerPanel =  new JPanel();
	private JTextField nom = new JTextField();
	private JTextField poids = new JTextField();
	private JTextField prix = new JTextField();
	private JTextField type = new JTextField();
	private JComboBox<TypeDeBateau> categorie= new  JComboBox<TypeDeBateau>(TypeDeBateau.values());
	private JComboBox<Proprietaire> proprietaire = new JComboBox<Proprietaire>();
	private JComboBox<Emplacement> emplacement = new JComboBox<Emplacement>();
	private JLabel typeLabel = new JLabel("Surface voile");
	private AjouterBateauVue maFenetre = this;
	
	/**
	 * Constructeur de confort
	 * @param frame la fenetre ou le pop up apparait
	 * @param titre titre du pop up
	 */
	public  AjouterBateauVue(JFrame frame,String titre) 
	{
		super(frame, titre);
		
		this.setLocationRelativeTo(null); 
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}
	
	/**
	 * Methode permettant de creer un pop up pour effectuer le filtrage des pointages
	 */
	public void init()
	{	
		JPanel northPanel = new JPanel(new FlowLayout());
	
		
		JPanel southPanel = new JPanel();
		
		JButton cancelButton = new JButton("Annuler");
		JButton ok = new JButton("Valider");
		
		southPanel.add(cancelButton, BorderLayout.WEST);
		southPanel.add(ok, BorderLayout.EAST);
		
		Container contentPane = this.getContentPane();
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		contentPane.add(centerPanel,BorderLayout.CENTER);
		
		centerPanel.add(nom);
		centerPanel.add(categorie);
		
		categorie.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg) 
			{
				centerPanel.removeAll();
				centerPanel.repaint();
				
				centerPanel.add(categorie);
				
				centerPanel.repaint();
				centerPanel.updateUI();
				
				pack();
			}
		});
		
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg) 
			{
				String teacherFirstnameName;
				
				
				//Fermer la fenetre
				maFenetre.dispose();
			}
		});
	
	
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg) 
			{
				maFenetre.dispose();
			}
		});
	}

}
