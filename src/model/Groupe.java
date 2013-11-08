package model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class Groupe extends Observable{
	private String name;
	private ArrayList<Objet> listeObjet = new ArrayList<>();
	private ArrayList<Utilisateur> listeMembres = new ArrayList<>();

	public Groupe(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Objet[] getListeObjet() {
		return listeObjet.toArray(new Objet[0]);
	}

	public void addObjet(Objet e) {
		e.setGroupe(this);
		listeObjet.add(e);
		this.setChanged();
		this.notifyObservers();
	}

	public void setListeObjet(ArrayList<Objet> listeObjet) {
		this.listeObjet = listeObjet;
	}

	public ArrayList<Utilisateur> getListeMembres() {
		return listeMembres;
	}

	public void setListeMembres(ArrayList<Utilisateur> listeMembres) {
		this.listeMembres = listeMembres;
	}

	/**
	 * Methode pour ajouter un utilisateur à un groupe. Ce groupe est
	 * automatiquement ajouté à la liste des groupes de l'utilisateur
	 * 
	 * @param e
	 *            : Utilisateur à ajouter
	 * @return
	 */
	public boolean addUtilisateur(Utilisateur e) {
		e.addGroupe(this);
		return listeMembres.add(e);
	}

	public int countUtilisateur() {
		return listeMembres.size();
	}

	@Override
	public String toString() {
		return name;
	}

}
