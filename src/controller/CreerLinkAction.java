package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Categorie;
import view.UserView;

public class CreerLinkAction implements ActionListener {

	private UserView userView;

	public CreerLinkAction(UserView userView) {
		this.userView = userView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String result = JOptionPane
				.showInputDialog("Entrer votre nouveau lien");
		if (userView.getSelectedGroupe() != null) {
			this.userView.getSelectedGroupe().addLink(new Categorie(result));
		}
	}

}
