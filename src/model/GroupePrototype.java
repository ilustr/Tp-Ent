package model;

import java.util.ArrayList;

import view.UserView;

public abstract class GroupePrototype implements Cloneable {
   
	public Groupe clone(UserView userview) 
    {
        try 
        {
        	Groupe copy = (Groupe)super.clone();
        	copy.setName(copy.getName()+"Copy");
        	copy.setListeObjet(userview.getSelectedGroupe().getListeRepertoires());
        	Portail.getInstance().addGroupe(copy);
        	copy.addUtilisateur(userview.getUtilisateur());
            return copy;
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }

}
