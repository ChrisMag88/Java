package com.boot.bookingrestaurantapi.jsons;

import java.util.List;

public class JsonToCsvRest {
	
	private String name;
	private String position;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MiObjeto{" +
				"name='" + name + '\'' +
				", position=" + position +
				",email=" + email + '\'' +
				'}';
	}
	
	
	public class MiObjetoList {
	    private List<JsonToCsvRest> personas;

	    public List<JsonToCsvRest> getPersonas() {
	        return personas;
	    }

	    public void setPersonas(List<JsonToCsvRest> personas) {
	        this.personas = personas;
	    }
	}

}


