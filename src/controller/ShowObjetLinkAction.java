package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Objet;
import view.UserView;

public class ShowObjetLinkAction implements ActionListener {

	private UserView userView;

	public ShowObjetLinkAction(UserView userView) {
		this.userView = userView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Objet selectedObjet = this.userView.getSelectedObjet();

		if (selectedObjet != null)
			JOptionPane.showMessageDialog(this.userView,
					selectedObjet.getLinkAsText());
	}

}
