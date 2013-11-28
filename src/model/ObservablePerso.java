package model;

import java.util.Observable;

public class ObservablePerso extends Observable {

	@Override
	public void notifyObservers() {
		this.setChanged();
		super.notifyObservers();
	}

	@Override
	public void notifyObservers(Object arg) {
		this.setChanged();
		super.notifyObservers(arg);
	}

	
}
