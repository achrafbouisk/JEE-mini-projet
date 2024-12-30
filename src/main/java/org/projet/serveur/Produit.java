package org.projet.serveur;

import java.io.Serializable;

public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;  // Doit être identique sur serveur et client

    private int id;
    private String marque;
    private String modele;
    private String processeur;
    private int ram;
    private int stock;
    private double prix;

    // Constructeur
    public Produit(String marque, String modele, String processeur, int ram, int stock, double prix) {
        this.marque = marque;
        this.modele = modele;
        this.processeur = processeur;
        this.ram = ram;
        this.stock = stock;
        this.prix = prix;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public String getModele() { return modele; }
    public void setModele(String modele) { this.modele = modele; }

    public String getProcesseur() { return processeur; }
    public void setProcesseur(String processeur) { this.processeur = processeur; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", processeur='" + processeur + '\'' +
                ", ram=" + ram +
                ", stock=" + stock +
                ", prix=" + prix +
                '}';
    }
}
