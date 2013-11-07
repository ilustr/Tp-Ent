package controller;

import java.util.ArrayList;

import model.Groupe;
import model.GroupeInstitutionnel;
import model.GroupePersonnel;
import model.Portail;
import model.Utilisateur;

public class InitController {

	public static void initPortail()
	{
		Portail portail = Portail.getInstance();
		
		Utilisateur utilisateurJRene = new Utilisateur("Jean-René");
		Utilisateur utilisateurJClaude = new Utilisateur("Jean-Claude");
		Utilisateur utilisateurJP = new Utilisateur("Jean-Pierre");
		Utilisateur utilisateurJPaul = new Utilisateur("Jean-Paul");
		Utilisateur utilisateurJJacques = new Utilisateur("Jean-Jacques");
		
		Groupe groupeInfo = new GroupeInstitutionnel("STIC Info");
		Groupe groupeTr = new GroupeInstitutionnel("STIC TR");

		Groupe groupePerso = new GroupePersonnel("Perso JJ", utilisateurJJacques);

		groupeInfo.addUtilisateur(utilisateurJJacques);
		groupeInfo.addUtilisateur(utilisateurJClaude);
		groupeInfo.addUtilisateur(utilisateurJPaul);

		groupeTr.addUtilisateur(utilisateurJP);
		groupeTr.addUtilisateur(utilisateurJRene);
		
		groupePerso.addUtilisateur(utilisateurJPaul);

		portail.addGroupe(groupePerso);
		portail.addGroupe(groupeInfo);
		portail.addGroupe(groupeTr);

		portail.addUtilisateur(utilisateurJRene);
		portail.addUtilisateur(utilisateurJClaude);
		portail.addUtilisateur(utilisateurJP);
		portail.addUtilisateur(utilisateurJPaul);
		portail.addUtilisateur(utilisateurJJacques);
	}
}
