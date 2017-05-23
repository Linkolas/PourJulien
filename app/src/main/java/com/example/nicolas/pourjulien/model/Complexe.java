package com.example.nicolas.pourjulien.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Complexe implements Serializable {

    private int id = -1;

    private String nom = "Jean-Eude";

    private String photoPath = "";

    private String localisation;

    private long Age;

    private String paragraphe;

    private List<String> Interets = new ArrayList<>();

    private boolean ageVisible;

    private boolean locaVisible;

    private boolean texteVisible;

    private boolean interetVisible;

    public Complexe() {
        super();
    }

    public long getAge() {
        return Age;
    }

    public void setAge(long age) {
        Age = age;
    }

    public boolean isAgeVisible() {
        return ageVisible;
    }

    public void setAgeVisible(boolean ageVisible) {
        this.ageVisible = ageVisible;
    }

    public boolean isLocaVisible() {
        return locaVisible;
    }

    public void setLocaVisible(boolean locaVisible) {
        this.locaVisible = locaVisible;
    }

    public boolean isTexteVisible() {
        return texteVisible;
    }

    public void setTexteVisible(boolean texteVisible) {
        this.texteVisible = texteVisible;
    }

    public boolean isInteretVisible() {
        return interetVisible;
    }

    public void setInteretVisible(boolean interetVisible) {
        this.interetVisible = interetVisible;
    }

    public Complexe(int id, String nom) {
        this.nom = nom;
        this.id = id;
    }

    public Complexe(int id, String nom, String photoPath) {
        this.nom = nom;
        this.id = id;
        this.photoPath = photoPath;
    }

    public Complexe(int id, String nom, String photoPath, String paragraphe, String localisation) {
        this.nom = nom;
        this.id = id;
        this.photoPath = photoPath;
        this.paragraphe = paragraphe;
        this.localisation = localisation;
        this.Interets = new ArrayList<String>();
    }

    public String getLocalisation() {
        return localisation;
    }

    public List<String> getInterets() {
        return Interets;
    }

    public void setInterets(List<String> interets) {
        Interets = interets;
    }

    public String getParagraphe() {
        return paragraphe;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
        //TODO setbase
    }

    public void setParagraphe(String paragraphe) {
        this.paragraphe = paragraphe;
        //TODO setbase
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", localisation='" + localisation + '\'' +
                ", paragraphe='" + paragraphe + '\'' +
                '}';
    }

    /*public Usermin toUsermin(){
        return new Usermin(id, nom, photoPath);
    }*/

}
