package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Groupe;
import model.Objet;
import model.Objet.typeObjet;
import model.Repertoire;
import controller.CreerObjetAction;

public class CreerObjetView extends JFrame {

	private Groupe Groupe;
	private JTextField nameText;
	private Repertoire repertoire;
	JComboBox<typeObjet> listeType;

	public CreerObjetView(Groupe groupe) {
		this(groupe, null);
	}

	public CreerObjetView(Groupe groupe, Repertoire repertoire) {
		super();
		this.Groupe = groupe;
		this.repertoire = repertoire;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Nouvel Objet ");
		setSize(600, 200);
		setLayout(new GridLayout(3, 2));

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

	public Groupe getGroupe() {
		return this.Groupe;
	}

	public String getNom() {
		return nameText.getText();
	}

	public typeObjet getTypeObjet() {
		return (typeObjet) listeType.getSelectedItem();
	}

	public Repertoire getRepertoire() {
		return this.repertoire;
	}

}
