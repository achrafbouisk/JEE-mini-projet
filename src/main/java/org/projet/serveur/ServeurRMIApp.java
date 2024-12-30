package org.projet.serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurRMIApp {
    public static void main(String[] args) {
        try {
            // Créer et exporter l'objet serveur
            ServeurRMI serveur = new ServeurRMI();

            // Créer le registre RMI sur le port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Enregistrer l'objet serveur sous le nom "InventaireService"
            registry.rebind("InventaireService", serveur);

            System.out.println("Serveur RMI prêt et en écoute sur le port 1099...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
