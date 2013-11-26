package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Utilisateur;
import view.PortailView;
import view.UserView;

public class ConnectionAction implements ActionListener {

	private PortailView loginView;

	public ConnectionAction(PortailView portailView) {
		super();
		this.loginView = portailView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Utilisateur utilisateur = loginView.getUtilisateur();

		loginView.closeWindow();

		new UserView(utilisateur);
	}

}
