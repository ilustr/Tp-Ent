package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Groupe;
import model.GroupePersonnel;
import model.Portail;
import model.Utilisateur;
import view.UserView;

public class CreerGroupeAction implements ActionListener {

	private UserView frame;
	private Utilisateur utilisateur;

	public CreerGroupeAction(UserView frame, Utilisateur utilisateur) {
		this.frame = frame;
		this.utilisateur = utilisateur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String texte = "Taper le nom du groupe � ajouter";
		String s = (String) JOptionPane.showInputDialog(
				this.frame.getComponent(), texte, "Creer Groupe",
				JOptionPane.PLAIN_MESSAGE);

		// If a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
			Groupe gp = new GroupePersonnel(s, this.utilisateur);
			Portail.getInstance().addGroupe(gp);
		}
	}

}
