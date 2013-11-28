package model;

public class ObjetPrototype implements Cloneable {
    
    public Objet clone() throws CloneNotSupportedException 
    {
        try 
        {
        	Objet copy = (Objet)super.clone();
            return copy;
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
	
}
