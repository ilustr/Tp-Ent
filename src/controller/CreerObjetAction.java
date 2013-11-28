package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ConcreteObjetFactory;
import model.Groupe;
import model.Objet;
import model.Repertoire;
import view.CreerObjetView;

public class CreerObjetAction implements ActionListener {

	private CreerObjetView frame;
	private String nomObjet;
	private Objet objet;
	private Groupe groupe;
	private String type;
	private Repertoire repertoire;
	private model.Objet.natureObjet stype;

	public CreerObjetAction(CreerObjetView frame, Groupe groupe) {
		this.frame = frame;
		this.groupe = groupe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		this.nomObjet = frame.getNom();
		this.type = frame.getTypeObjet();
		this.stype = frame.getSousTypeObjet();
		this.repertoire = frame.getRepertoire();

		if (!this.nomObjet.equals("")) {
			groupe.addObjet(type, nomObjet, stype, this.repertoire);
		}
		frame.dispose();
	}

}
