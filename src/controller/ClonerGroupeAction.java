package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Groupe;
import model.Objet;
import model.Repertoire;
import view.CreerObjetView;
import view.UserView;

public class ClonerGroupeAction implements ActionListener {

	private UserView frame;

	public ClonerGroupeAction(UserView frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.frame.getSelectedGroupe().isGestionnaire(this.frame.getUtilisateur())){
			frame.getSelectedGroupe().clone(this.frame);
		}
	}

}
