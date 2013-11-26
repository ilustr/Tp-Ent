package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import model.Utilisateur;
import controller.ConnectionAction;
import controller.ConnectionController;

public class PortailView extends JFrame {

	private JComboBox<Utilisateur> jComboBox;

	public PortailView() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Ent ");
		setSize(300, 150);
		setLayout(new FlowLayout());

		Utilisateur[] listeUtilisateur = ConnectionController.getUtilisateurs();

		jComboBox = new JComboBox<>(listeUtilisateur);

		JButton button = new JButton("Connection");
		button.addActionListener(new ConnectionAction(this));

		this.add(jComboBox);
		this.add(button);

		pack();
		show();
	}

	public Utilisateur getUtilisateur() {
		return (Utilisateur) this.jComboBox.getSelectedItem();
	}

	public void closeWindow() {
		this.dispose();
	}

}
