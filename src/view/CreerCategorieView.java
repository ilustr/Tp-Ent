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
import model.Objet.natureObjet;
import controller.CreerCategorieAction;

public class CreerCategorieView extends JFrame {

	private Groupe Groupe;
	private Object repertoire;
	private JTextField nameLink;
	private JTextField nameLinkInverse;
	private JComboBox<Objet.natureObjet> listeTypeInput;
	private JComboBox<natureObjet> listeTypeOutput;

	public CreerCategorieView(Groupe groupe) {
		super();
		this.Groupe = groupe;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Nouvel Objet ");
		setSize(600, 200);
		setLayout(new GridLayout(3, 4));

		nameLink = new JTextField();
		nameLinkInverse = new JTextField();

		listeTypeInput = new JComboBox<Objet.natureObjet>(Objet.natureObjet.values());
		listeTypeOutput = new JComboBox<Objet.natureObjet>(Objet.natureObjet.values());
		
		JButton valider = new JButton("Valider");
		valider.addActionListener(new CreerCategorieAction(this));

		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		this.add(new JLabel("Type de l'objet A : "));
		this.add(new JLabel("Nom du lien : "));
		this.add(new JLabel("Nom du lien inverse : "));
		this.add(new JLabel("Type de l'objet B : "));
		this.add(listeTypeInput);
		this.add(nameLink);
		this.add(nameLinkInverse);
		this.add(listeTypeOutput);
		this.add(new JLabel(" "));
		this.add(valider);
		this.add(annuler);

		show();
	}

	public Groupe getGroupe() {
		return this.Groupe;
	}

	public String getNomLink() {
		return nameLink.getText();
	}
	
	public String getNomLinkInverse() {
		return nameLinkInverse.getText();
	}

	public Objet.natureObjet getListeTypeInput() {
		return (Objet.natureObjet) listeTypeInput.getSelectedItem();
	}

	public Objet.natureObjet getListeTypeOutput() {
		return (Objet.natureObjet) listeTypeOutput.getSelectedItem();
	}

}
