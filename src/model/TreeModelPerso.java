package model;

import java.util.ArrayList;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class TreeModelPerso implements TreeModel {

	private Groupe groupe;
	private ArrayList<TreeModelListener> listeners = new ArrayList<>();
	
	@Override
	public void addTreeModelListener(TreeModelListener l) {
		this.listeners.add(l);
	}

	@Override
	public Object getChild(Object parent, int index) {
		if(parent instanceof Groupe){
			return ((Groupe)parent).getObjet(index);
		}else if(parent instanceof Repertoire){
			return ((Repertoire)parent).getObjet(index);
		}
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		if(parent instanceof Groupe){
			return ((Groupe)parent).countObjet();
		}else if(parent instanceof Repertoire){
			return ((Repertoire)parent).countObjet();
		}
		return 0;
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if(parent instanceof Groupe){
			return ((Groupe)parent).indexOfObjet(child);
		}else if(parent instanceof Repertoire){
			return ((Repertoire)parent).indexOfObjet(child);
		}
		return 0;
	}

	@Override
	public Object getRoot() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
		this.notifyListener();
	}

	@Override
	public boolean isLeaf(Object node) {
		if(node instanceof Groupe || node instanceof Repertoire)
			return false;
		else
			return true;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		this.listeners.remove(l);
	}

	private void notifyListener()
	{
		for (TreeModelListener listener : this.listeners) {
			listener.treeStructureChanged(new TreeModelEvent(this.groupe, new TreePath(this.groupe)));
		}
	}
	
	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub

	}

}
