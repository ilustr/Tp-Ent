package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.ILoginView;
import main.PortailView;
import main.UserView;
import model.Groupe;
import model.GroupePersonnel;
import model.Portail;
import model.Utilisateur;

public class CreerGroupeAction implements ActionListener {

	private JFrame frame;
	private Utilisateur utilisateur;
	
	
	public CreerGroupeAction(JFrame frame, Utilisateur utilisateur) {
		this.frame = frame;
		this.utilisateur = utilisateur;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String texte = "Taper le nom du groupe � ajouter";
		String s = (String)JOptionPane.showInputDialog(
		                    this.frame,
		                    texte,
		                    "Creer Groupe",
		                    JOptionPane.PLAIN_MESSAGE);

		//If a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
		    Groupe gp = new GroupePersonnel(s, this.utilisateur);
		    Portail.getInstance().addGroupe(gp);
		}
	}

}
