package com.capitole.harryarbol.dtos;

public class Arbol {
	
    private Integer index;
    private String bordeIzquierdo;
    private String bordeDerecho;

    public Arbol(Integer index, String bordea, String bordeb){
        this.index = index;
        this.bordeIzquierdo = bordea;
        this.bordeDerecho = bordeb;
    }

    public Arbol() {
		// TODO Auto-generated constructor stub
        this.bordeIzquierdo = "null";
        this.bordeDerecho = "null";
	}

	public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public String getBordeIzquierdo() {
        return bordeIzquierdo;
    }

    public String getBordeDerecho() {
        return bordeDerecho;
    }
    
    public Boolean aIsColorValid(String color) {
        return bordeIzquierdo.equalsIgnoreCase(color);
    }
    
    public Boolean bIsColorValid(String color) {
        return bordeDerecho.equalsIgnoreCase(color);
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "" + bordeIzquierdo + " <- " + index + " -> " + bordeDerecho;
    }
}
