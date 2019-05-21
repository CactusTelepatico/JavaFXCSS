package modelo;

import controlador.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccesoDatos extends Main{
	
	protected ObservableList<Persona> personData;
	
	public AccesoDatos() {
		personData = FXCollections.observableArrayList();
		personData.add(new Persona("Adrian","cactus","19"));
	}
	
	public void addPersona(Persona nueva) {
		personData.add(nueva);
	}
	
	public void deletePerson(int position) {
		personData.remove(position);
	}
	
	public ObservableList<Persona> getPersonData() {
		return personData;
	}
	
	

}
