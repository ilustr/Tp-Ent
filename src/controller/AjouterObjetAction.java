package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Groupe;
import model.Objet;
import model.Repertoire;
import view.CreerObjetView;
import view.UserView;

public class AjouterObjetAction implements ActionListener {

	private Groupe groupe;
	private UserView userView;

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public AjouterObjetAction(UserView userView) {
		this.userView = userView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.groupe != null) {
			Objet selectedObjet = this.userView.getSelectedObjet();

			if (selectedObjet != null && selectedObjet instanceof Repertoire)
				new CreerObjetView(groupe, (Repertoire) selectedObjet);
			else
				new CreerObjetView(groupe);
		}
	}

}
