package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Groupe;
import model.Objet;
import model.Utilisateur;
import view.CreerObjetView;
import view.ILoginView;
import view.UserView;

public class AjouterObjetAction implements ActionListener {

	private Groupe groupe;

	public void setGroupe(Groupe groupe){
		this.groupe = groupe;
	}

	public AjouterObjetAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.groupe != null){
			new CreerObjetView(groupe);
		}
	}

}
