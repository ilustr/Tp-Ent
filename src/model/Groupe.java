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
	
	public int indexOfObjet(Object o) {
		return listeObjet.indexOf(o);
	}

	public Objet[] getListeObjet() {
		return listeObjet.toArray(new Objet[0]);
	}
	
	public Objet getObjet(int index){
		return listeObjet.get(index);
	}

	public int countObjet() {
		return listeObjet.size();
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
	 * Methode pour ajouter un utilisateur � un groupe. Ce groupe est
	 * automatiquement ajout� � la liste des groupes de l'utilisateur
	 * 
	 * @param e
	 *            : Utilisateur � ajouter
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
