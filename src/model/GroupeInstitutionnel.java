package model;

import java.util.ArrayList;

public class GroupeInstitutionnel extends Groupe {

	private ArrayList<Utilisateur> listeGestionnaire = new ArrayList<Utilisateur>();

	public GroupeInstitutionnel(String name) {
		super(name);
	}

	public boolean addGestionnaire(Utilisateur user) {
		return listeGestionnaire.add(user);
	}

	@Override
	public boolean isGestionnaire(Utilisateur user) {
		for (Utilisateur u : listeGestionnaire) {
			if (u == user) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Utilisateur> getListeGestionnaire() {
		return listeGestionnaire;
	}

}
