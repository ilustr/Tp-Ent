package model;

import java.util.ArrayList;

public class Portail {
	ArrayList<Groupe> listeGroupe = new ArrayList<>();

	public boolean removeGroupe(Groupe groupe) {
		for (Utilisateur u : groupe.getListeMembres()) {
			u.removeGroupe(groupe);
		}

		for (Utilisateur u : groupe.getListeGestionnaire()) {
			u.removeGroupe(groupe);
		}
		return listeGroupe.remove(groupe);
	}

	ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

	private static Portail singleton = new Portail();

	private Portail() {
		super();
	}

	public static Portail getInstance() {
		return singleton;
	}

	public Utilisateur[] getUtilisateurs() {
		return utilisateurs.toArray(new Utilisateur[0]);
	}

	public void setUtilisateurs(ArrayList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public ArrayList<Groupe> getListeGroupe() {
		return listeGroupe;
	}

	public void setListeGroupe(ArrayList<Groupe> listeGroupe) {
		this.listeGroupe = listeGroupe;
	}

	public boolean addGroupe(Groupe e) {
		return listeGroupe.add(e);
	}

	public int countGroupe() {
		return listeGroupe.size();
	}

	public boolean addUtilisateur(Utilisateur e) {
		return utilisateurs.add(e);
	}

	public int countUtilisateur() {
		return utilisateurs.size();
	}

}
