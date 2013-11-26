package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Application;
import model.Document;
import model.Groupe;
import model.Objet;
import model.Objet.typeObjet;
import model.Repertoire;
import view.CreerObjetView;

public class CreerObjetAction implements ActionListener {

	private CreerObjetView frame;
	private String nomObjet;
	private Objet objet;
	private Groupe groupe;
	private typeObjet type;
	private Repertoire repertoire;
	private model.Objet.sousType stype;

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
			switch (this.type) {
			case Repertoire:
				objet = new Repertoire(this.nomObjet, this.stype);
				break;
			case Application:
				objet = new Application(this.nomObjet, this.stype);
				break;
			case Document:
				objet = new Document(this.nomObjet, this.stype);
				break;
			default:
				break;
			}

			if (this.repertoire != null)
				this.repertoire.addObjet(objet);
			else
				groupe.addObjet(objet);
		}
		frame.dispose();
	}

}
