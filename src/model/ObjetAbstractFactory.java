package model;

import java.util.ArrayList;
import java.util.List;

import model.Objet.natureObjet;

public abstract class ObjetAbstractFactory {
	
	public static final String OBJET_TYPE_APPLICATION = "Application";
	public static final String OBJET_TYPE_REPERTOIRE = "Repertoire";
	public static final String OBJET_TYPE_DOCUMENT = "Document";

	public List<String> getObjetType()
	{
		ArrayList<String> types = new ArrayList<>();

		types.add(OBJET_TYPE_REPERTOIRE);
		types.add(OBJET_TYPE_APPLICATION);
		types.add(OBJET_TYPE_DOCUMENT);
		
		return types;
	}
	
	public Objet constructObjet(String objetType, String nomObjet, natureObjet stype)
	{
		if(OBJET_TYPE_REPERTOIRE.equals(objetType))
			return new Repertoire(nomObjet, stype);
		
		if(OBJET_TYPE_APPLICATION.equals(objetType))
			return new Application(nomObjet, stype);
		
		if(OBJET_TYPE_DOCUMENT.equals(objetType))
			return new Document(nomObjet, stype);
		
		return null;
	}
}
