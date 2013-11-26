package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Groupe;
import view.CreerLinkView;
import view.UserView;

public class OpenWindowAction implements ActionListener {

	private Groupe groupe;
	private UserView userView;

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public OpenWindowAction(UserView userView) {
		this.userView = userView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.groupe != null) {
			new CreerLinkView(groupe);
		}
	}

}
