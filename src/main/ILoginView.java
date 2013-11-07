package main;

import model.Utilisateur;

public interface ILoginView {
	public Utilisateur getUtilisateur();
	public void closeWindow();
}
