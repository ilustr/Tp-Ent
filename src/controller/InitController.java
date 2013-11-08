package controller;

import model.Application;
import model.Document;
import model.Groupe;
import model.GroupeInstitutionnel;
import model.GroupePersonnel;
import model.Portail;
import model.Repertoire;
import model.Utilisateur;

public class InitController {

	public static void initPortail() {
		Portail portail = Portail.getInstance();

		Utilisateur utilisateurJRene = new Utilisateur("Jean-Ren�");
		Utilisateur utilisateurJClaude = new Utilisateur("Jean-Claude");
		Utilisateur utilisateurJP = new Utilisateur("Jean-Pierre");
		Utilisateur utilisateurJPaul = new Utilisateur("Jean-Paul");
		Utilisateur utilisateurJJacques = new Utilisateur("Jean-Jacques");
		
		Repertoire repertoire = new Repertoire("Repertoire TP");
		Document d1 = new Document("Essai du TP");
		Document d2 = new Document("Essai du TP1");
		Document d3 = new Document("Essai du TP2");
		Document d4 = new Document("Essai du TP3");

		repertoire.addObjet(d1);
		repertoire.addObjet(d2);
		repertoire.addObjet(d3);
		repertoire.addObjet(d4);
		
		Groupe groupeInfo = new GroupeInstitutionnel("STIC Info");
		Groupe groupeTr = new GroupeInstitutionnel("STIC TR");
		Groupe groupeEtudiant = new GroupeInstitutionnel("Etudiant");
		Groupe groupeSFA = new GroupeInstitutionnel("SFA");

		Groupe groupePerso = new GroupePersonnel("Perso JJ",
				utilisateurJJacques);

		groupeInfo.addUtilisateur(utilisateurJJacques);
		groupeInfo.addUtilisateur(utilisateurJClaude);
		groupeInfo.addUtilisateur(utilisateurJPaul);
		groupeInfo.addObjet(new Document("Correction TP"));
		groupeInfo.addObjet(new Document("Photo"));

		groupeSFA.addUtilisateur(utilisateurJJacques);
		groupeSFA.addUtilisateur(utilisateurJPaul);
		groupeSFA.addUtilisateur(utilisateurJP);

		groupeEtudiant.addUtilisateur(utilisateurJJacques);
		groupeEtudiant.addUtilisateur(utilisateurJClaude);
		groupeEtudiant.addUtilisateur(utilisateurJPaul);
		groupeEtudiant.addUtilisateur(utilisateurJP);
		groupeEtudiant.addUtilisateur(utilisateurJRene);
		groupeEtudiant.addObjet(new Application("Tp1"));
		groupeEtudiant.addObjet(repertoire);

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
