package model;

import java.util.ArrayList;

public class GroupePersonnel extends Groupe {

	private Utilisateur gestionnaire;

	public GroupePersonnel(String name, Utilisateur utilisateur) {
		super(name);
		utilisateur.addGroupe(this);
		this.gestionnaire = utilisateur;
	}

	@Override
	public boolean isGestionnaire(Utilisateur user) {
		if (user == this.gestionnaire) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Utilisateur> getListeGestionnaire() {
		ArrayList<Utilisateur> liste = new ArrayList<Utilisateur>();
		liste.add(gestionnaire);
		return liste;
	}

}
