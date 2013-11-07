package main;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.text.View;

import model.Groupe;
import model.Utilisateur;
import controller.ConnectionAction;
import controller.ConnectionController;


public class UserView extends JFrame{


	public UserView(Utilisateur utilisateur) {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Ent - "+ utilisateur.getName());
		setSize(300, 150);
		setLayout(new FlowLayout());
		
		Groupe[] groupes = utilisateur.getListeGroupes();
		
		JList<Groupe> jList = new JList(groupes);
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.add(jList);
		// we was here
		
		pack();
		show();
	}

}
