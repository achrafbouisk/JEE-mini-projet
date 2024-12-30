package org.projet.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InventaireInterface extends Remote {
    void ajouterProduit(Produit produit) throws RemoteException;
    List<Produit> listerProduits() throws RemoteException;
    void mettreAJourProduit(Produit produit) throws RemoteException;
    void supprimerProduit(int id) throws RemoteException;
}
