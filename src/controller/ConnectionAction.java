package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import main.ILoginView;
import main.PortailView;
import main.UserView;
import model.Utilisateur;

public class ConnectionAction implements ActionListener {

	private ILoginView loginView;
	
	
	public ConnectionAction(ILoginView portailView) {
		super();
		this.loginView = portailView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Utilisateur utilisateur =  loginView.getUtilisateur();
		
		loginView.closeWindow();
		
		new UserView(utilisateur);
	}

}
