package controller;

import model.Portail;
import model.Utilisateur;

public class ConnectionController {

	public static Utilisateur[] getUtilisateurs()
	{
		return Portail.getInstance().getUtilisateurs();
	}
}
