package main;

import controller.InitController;


public class EntryPoint {

	public static void main(String[] args) {
		
		//init le portail
		InitController.initPortail();
		
		new PortailView();
	}

}
