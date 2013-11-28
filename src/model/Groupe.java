package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Objet.natureObjet;

public abstract class Groupe extends GroupePrototype implements Observer {
	private String name;
	private ObservablePerso observer;
	private ArrayList<Objet> listeObjet = new ArrayList<>();
	private ArrayList<Categorie> listeCategories = new ArrayList<>();
	private ObjetAbstractFactory objetFactory;

	
	public Groupe(String name) {
		super();
		this.name = name;
		this.objetFactory = new ConcreteObjetFactory();
		this.observer = new ObservablePerso();
	}

	public boolean addCategorie(Categorie categorie) {
		return listeCategories.add(categorie);
	}

	public boolean removeCategorie(Categorie categorie) {
		return listeCategories.remove(categorie);
	}

	public ArrayList<Categorie> getListeLink() {
		return listeCategories;
	}

	private ArrayList<Utilisateur> listeMembres = new ArrayList<>();

	public abstract boolean isGestionnaire(Utilisateur user);

	public abstract ArrayList<Utilisateur> getListeGestionnaire();

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
	
	public ArrayList<Objet> getListeRepertoires() {
		ArrayList<Objet> resultat = new ArrayList<Objet>();
		for(Objet o : this.listeObjet){
			if(o instanceof Repertoire){
				Repertoire r = null;
				try {
					r = (Repertoire)o.clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resultat.add(r);
			}
		}
		return resultat;
	}

	public void removeObjet(Objet objet) {
		if (listeObjet.contains(objet)) {
			for (Link l : objet.getLinks()) {
				l.getObjetA().removeLink(l);
				l.getObjetB().removeLink(l);
			}
			listeObjet.remove(objet);
			this.notifyObservers();
		} else {
			for (Objet nObjet : listeObjet) {
				if (nObjet instanceof Repertoire)
					((Repertoire) nObjet).removeObjet(objet);
			}
		}
	}

	public Objet getObjet(int index) {
		return listeObjet.get(index);
	}

	public int countObjet() {
		return listeObjet.size();
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

	@Override
	public void update(Observable o, Object arg) {
		this.notifyObservers();
	}

	public List<String> getObjetType() {
		return objetFactory.getObjetType();
	}

	public void addObjet(String type, String nomObjet, natureObjet stype,
			Repertoire repertoire) {
		
		Objet obj = objetFactory.constructObjet(type, nomObjet, stype);
		
		obj.setGroupe(this);
		
		if(repertoire != null)
			repertoire.addObjet(obj);
		else
			this.listeObjet.add(obj);
		
		obj.addObserver(this);
		
		this.notifyObservers();
	}

	public void addObjet(String type, String nomObjet, natureObjet stype) {
		
		this.addObjet(type, nomObjet, stype, null);
	}

	public void addObjet(Objet obj) {
		obj.setGroupe(this);
		this.listeObjet.add(obj);
		obj.addObserver(this);

		this.notifyObservers();
	}

	public void addObserver(Observer o) {
		observer.addObserver(o);
	}

	public int countObservers() {
		return observer.countObservers();
	}

	public void deleteObserver(Observer o) {
		observer.deleteObserver(o);
	}

	public void deleteObservers() {
		observer.deleteObservers();
	}

	public void notifyObservers() {
		observer.notifyObservers();
	}

	public boolean removeAllCategorie(ArrayList<Categorie> cat) {
		return listeCategories.removeAll(cat);
	}
	
	public boolean removeAllObjet(ArrayList<Objet> obj) {
		return listeObjet.removeAll(obj);
	}


	public void notifyObservers(Object arg) {
		observer.notifyObservers(arg);
	}

	public ArrayList<Categorie> getListeCategories() {
		return listeCategories;
	}
	

	
}
