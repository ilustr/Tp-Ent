package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CreerObjetAction;
import model.Groupe;
import model.Objet;
import model.Objet.typeObjet;

public class CreerObjetView extends JFrame implements ICreerObjetView{

	private Groupe Groupe;
	private JTextField nameText;
	JComboBox<typeObjet> listeType;

	public CreerObjetView(Groupe groupe) {
		super();
		this.Groupe = groupe;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Nouvel Objet ");
		setSize(600, 200);
		setLayout(new GridLayout(2, 3));

		nameText = new JTextField();
		
		listeType = new JComboBox<typeObjet>(Objet.typeObjet.values());
		
		JButton valider = new JButton("Valider");
		valider.addActionListener(new CreerObjetAction(this, Groupe));
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.add(new JLabel("Type de l'objet : "));
		this.add(listeType);
		this.add(new JLabel("Nom de l'objet : "));
		this.add(nameText);
		this.add(valider);
		this.add(annuler);

		show();
	}

	@Override
	public Groupe getGroupe() {
		return this.Groupe;
	}

	@Override
	public String getNom() {
		return nameText.getText();
	}

	@Override
	public typeObjet getTypeObjet() {
		return (typeObjet)listeType.getSelectedItem();
	}
	
	
}
