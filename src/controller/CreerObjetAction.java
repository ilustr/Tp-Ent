package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.ICreerObjetView;
import model.Application;
import model.Document;
import model.Groupe;
import model.Objet;
import model.Repertoire;
import model.Objet.typeObjet;



public class CreerObjetAction implements ActionListener {

	private ICreerObjetView frame;
	private String nomObjet;
	private Objet objet;
	private Groupe groupe;
	private typeObjet type;

	public CreerObjetAction(ICreerObjetView frame, Groupe groupe) {
		this.frame = frame;
		this.groupe = groupe;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		this.nomObjet = frame.getNom();
		this.type = frame.getTypeObjet();
		if(!this.nomObjet.equals("")){
			switch(this.type){
			case Repertoire:
				objet = new Repertoire(this.nomObjet);
				break;
			case Application:
				objet = new Application(this.nomObjet);
				break;
			case Document:
				objet = new Document(this.nomObjet);
				break;
			default:
				break;
			}
			groupe.addObjet(objet);
		}
		frame.dispose();
	}

}
