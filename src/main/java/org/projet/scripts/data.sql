-- Utiliser la base de données
USE inventaire_ordinateurs;

-- Insérer des données de test dans la table 'ordinateurs'
INSERT INTO ordinateurs (marque, modele, processeur, ram, stock, prix) VALUES
                                                                           ('Dell', 'Inspiron 15', 'Intel Core i5', 8, 10, 800.00),
                                                                           ('HP', 'Pavilion x360', 'Intel Core i7', 16, 5, 1200.00),
                                                                           ('Lenovo', 'ThinkPad X1', 'Ryzen 7', 16, 7, 1400.00),
                                                                           ('Asus', 'ZenBook 14', 'Intel Core i5', 8, 20, 950.00),
                                                                           ('Apple', 'MacBook Pro', 'M1', 16, 15, 2500.00);
