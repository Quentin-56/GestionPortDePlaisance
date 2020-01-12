package vue;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.controleurVue.EditerBateauControleurVue;
import controleur.controleurVue.TypeDeBateau;
import modele.Bateau;
import modele.Emplacement;
import modele.Proprietaire;

public class EditerBateauVue extends JDialog {

	private static JButton annuler, valider, modifier;
	private JPanel centerPanel = new JPanel();
	private JTextField nom = new JTextField();
	private JTextField poids = new JTextField();
	private JTextField typeTF = new JTextField();
	private static JComboBox<TypeDeBateau> type = new JComboBox<TypeDeBateau>(TypeDeBateau.values());
	private JComboBox<Proprietaire> proprietaire = new JComboBox<Proprietaire>();
	private JComboBox<Emplacement> emplacement = new JComboBox<Emplacement>();
	private JLabel typeLabel = new JLabel("Surface totale de la voile :");
	private EditerBateauVue maFenetre = this;
	private JLabel nomLabel, poidsLabel, proprietaireLabel, emplacementLabel, categorieLabel;

	/**
	 * Constructeur de confort
	 * 
	 * @param frame la fenetre ou le pop up apparait
	 * @param titre titre du pop up
	 */
	public EditerBateauVue(JFrame frame, String titre, Bateau bateau) {
		super(frame, titre);

		this.setLocationRelativeTo(null);
		init(bateau);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}

	/**
	 * Methode permettant de creer un pop up pour effectuer le filtrage des pointages
	 */
	public void init(Bateau bateau)
	{	
		JPanel northPanel = new JPanel(new FlowLayout());
		
		JPanel southPanel = new JPanel();
		
		annuler = new JButton("Annuler");
		valider = new JButton("Valider");
		modifier = new JButton("Modifier");
		
		southPanel.add(annuler, BorderLayout.WEST);
		
		//Si nous creons un bateau
		if(bateau == null )
		{
			southPanel.add(valider, BorderLayout.EAST);
		}else
		{
			southPanel.add(modifier, BorderLayout.EAST);
		}
		
		
		Container contentPane = this.getContentPane();
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		contentPane.add(centerPanel,BorderLayout.CENTER);
		
		Box verticalBox = Box.createVerticalBox();
		centerPanel.add(verticalBox);
		
		nomLabel = new JLabel("Nom du bateau :");
		verticalBox.add(nomLabel);
		nom.setPreferredSize(new Dimension(100,20));
		verticalBox.add(nom);
		proprietaireLabel = new JLabel("Proprietaire :");
		verticalBox.add(proprietaireLabel);
		verticalBox.add(proprietaire);
		categorieLabel = new JLabel("Categorie :");
		verticalBox.add(categorieLabel);
		verticalBox.add(type);
		verticalBox.add(typeLabel);
		typeTF.setPreferredSize(new Dimension(100,20));
		verticalBox.add(typeTF);
		poidsLabel = new JLabel("Poids du bateau :");
		verticalBox.add(poidsLabel);
		poids.setPreferredSize(new Dimension(100,20));
		verticalBox.add(poids);
		emplacementLabel = new JLabel("Emplacement :");
		verticalBox.add(emplacementLabel);
		verticalBox.add(emplacement);
		
		new EditerBateauControleurVue(nom, poids, typeTF,proprietaire, emplacement, typeLabel, this, centerPanel,type, bateau);
	}

	// Definir les actions sur les boutons
	public static void comboboxListener(ActionListener comboboxListener) {
		type.addActionListener(comboboxListener);
	}

	public static void validerListener(ActionListener validerListener) {
		valider.addActionListener(validerListener);
	}
	
	public static void modifierListener(ActionListener modifierListener) {
		modifier.addActionListener(modifierListener);
	}

	public static void annulerListener(ActionListener annulerListener) {
		annuler.addActionListener(annulerListener);
	}
}
