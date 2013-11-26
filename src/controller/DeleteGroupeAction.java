package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Portail;
import view.UserView;

public class DeleteGroupeAction implements KeyListener {

	private UserView userView;

	public DeleteGroupeAction(UserView userView) {
		this.userView = userView;
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if ((int) e.getKeyChar() == 127 && userView.getSelectedGroupe() != null) {
			if (userView.getSelectedGroupe().isGestionnaire(
					userView.getUtilisateur())) {
				Portail.getInstance()
						.removeGroupe(userView.getSelectedGroupe());
			}
		}
	}

}
