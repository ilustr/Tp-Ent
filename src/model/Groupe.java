package model;

import java.util.ArrayList;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class Groupe implements TreeModel {
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

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf(Object node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub

	}

}
