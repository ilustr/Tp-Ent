package view;

import model.Groupe;
import model.Objet.typeObjet;

public interface ICreerObjetView {
public Groupe getGroupe();
public typeObjet getTypeObjet();
public String getNom();
public void dispose();
}
