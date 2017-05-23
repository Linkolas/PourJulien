package com.example.nicolas.pourjulien.model;

import java.io.Serializable;

public class Simple implements Serializable {

    private int id = 0;
    private String libelle = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Simple " + id + " - " + libelle;
    }
}
