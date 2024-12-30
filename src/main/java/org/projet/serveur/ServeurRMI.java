package org.projet.serveur;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.List;

public class ServeurRMI extends UnicastRemoteObject implements InventaireInterface {
    private DAOProduit dao;

    public ServeurRMI() throws RemoteException {
        super();
        this.dao = new DAOProduit(); // Créez une instance de DAO
    }

    @Override
    public void ajouterProduit(Produit produit) throws RemoteException {
        try {
            dao.ajouterProduit(produit);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException("Erreur lors de l'ajout du produit", e);
        }
    }

    @Override
    public List<Produit> listerProduits() throws RemoteException {
        try {
            return dao.listerProduits();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException("Erreur lors de la récupération des produits", e);
        }
    }

    @Override
    public void mettreAJourProduit(Produit produit) throws RemoteException {
        try {
            dao.mettreAJourProduit(produit);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException("Erreur lors de la mise à jour du produit", e);
        }
    }

    @Override
    public void supprimerProduit(int id) throws RemoteException {
        try {
            dao.supprimerProduit(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException("Erreur lors de la suppression du produit", e);
        }
    }
}
