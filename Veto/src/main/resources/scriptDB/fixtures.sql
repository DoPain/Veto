INSERT INTO Personne (idVille, nom, prenom, dateNaissance, adresse, mail, telephone) VALUES 
((SELECT idVille FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestE1', 'Employe1', DATE("1999-12-23"), '45 Route de Employe1 34530 Mutch', 'emp1.test@email.com', '06.01.01.01.01'),
((SELECT idVille FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestE2', 'Employe2', DATE("1999-12-23"), '45 Route de Employe2 34530 Mutch', 'emp2.test@email.com', '06.01.01.01.02'),
((SELECT idVille FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestE3', 'Employe3', DATE("1999-12-23"), '45 Route de Employe3 34530 Mutch', 'emp3.test@email.com', '06.01.01.01.03'),
((SELECT idVille FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestC1', 'Client1', DATE("1999-12-23"), '45 Route de Client1 34530 Mutch', 'cli1.test@email.com', '06.01.01.02.01'),
((SELECT idVille FROM Ville WHERE Ville.ville_nom_reel = 'Libourne'), 'TestC2', 'Client2', DATE("1999-12-23"), '45 Route de Client2 34530 Mutch', 'cli2.test@email.com', '06.01.01.02.02'),
((SELECT idVille FROM Ville WHERE Ville.ville_nom_reel = 'Gradignan'), 'TestC3', 'Client3', DATE("1999-12-23"), '45 Route de Client3 34530 Mutch', 'cli3.test@email.com', '06.01.01.02.03'),
((SELECT idVille FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestC4', 'Client4', DATE("1999-12-23"), '45 Route de Client4 34530 Mutch', 'cli4.test@email.com', '06.01.01.02.04'),
((SELECT idVille FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestC5', 'Client5', DATE("1999-12-23"), '45 Route de Client5 34530 Mutch', 'cli5.test@email.com', '06.01.01.02.05');

INSERT INTO Employe (idEmploye, idConnexion, motDePasse) VALUES 
(	, 'empTest1', 'test'),
((SELECT idPersonne FROM Personne WHERE Personne.nom = 'TestE2'), 'empTest2', 'test'),
((SELECT idPersonne FROM Personne WHERE Personne.nom = 'TestE3'), 'empTest3', 'test');

INSERT INTO Client (idClient) VALUES
((SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC1")),
((SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC2")),
((SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC3")),
((SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC4")),
((SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC5"));

INSERT INTO Log (idEmploye, action) VALUES 
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest1'), "New Client"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest1'), "New Race"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest2'), "Remove Client"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest1'), "Remove Produit"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest3'), "Edit Produit"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest3'), "New Produit"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest2'), "New Client"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest2'), "New Race"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest1'), "New Espece"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest1'), "New Race"),
((SELECT idEmploye FROM Employe WHERE Employe.idConnexion = 'empTest1'), "Remove Ordonnance");

INSERT INTO Espece (nom) VALUES 
('Lapin'), 
('Chat'),
('Cheval'), 
('Chien'), 
('Serpent'), 
('Hamster');

INSERT INTO Race (idEspece, nom) VALUES 
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'),'Alaska'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'),'Blanc danois'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'),'Grand Russe'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'),'Japonais')
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'),'Abyssin'), 
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'),'American curl'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'),'Anatoli'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'),'Balinais')
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'),'Appaloosa'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'),'Bachkir'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'),'Baladi'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'),'Edelbluthaflinger')
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'),'Berger allemand'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'),'Berger belge'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'),'Border Terrier'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'),'Golden retriever')
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster de Syrie'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster d\'Europe'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster de Campbell'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster hybride');

INSERT INTO Animal (idEspece, idClient, nom, dateNaissance) VALUES
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC1"), 'PamPam', DATE("2007-10-23")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC1"), 'Capucine', DATE("2007-10-13")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC1"), 'Aristide', DATE("2007-10-4")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC1"), 'Barney', DATE("2007-10-5")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC1"), 'Chanel', DATE("2007-10-10")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC2"), 'Dolph', DATE("2007-2-1")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC2"), 'Fripouille', DATE("2007-2-5")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC3"), 'Noisette', DATE("2007-3-1")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC3"), 'Ducros', DATE("2007-3-2")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC3"), 'Diego', DATE("2007-3-3")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC3"), 'Ed', DATE("2007-3-4")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC3"), 'Earl', DATE("2007-3-5")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC3"), 'Dolf', DATE("2007-3-6")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC3"), 'Boris', DATE("2007-3-7")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC3"), 'Barney', DATE("2007-3-8"));
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC4"), 'Alex', DATE("2007-4-1")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC4"), 'Choupette', DATE("2007-4-5")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC4"), 'PamPam', DATE("2007-4-4")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC4"), 'Houmou', DATE("2007-4-13")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC5"), 'Bounty', DATE("2007-5-5")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC5"), 'Noisette', DATE("2007-5-13")),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'), (SELECT idPersonne FROM Personne WHERE Personne.nom = "TestC5"), 'Gerbille', DATE("2007-5-24"));

INSERT INTO Produit (nom, QuantiteEnStock, QuantiteMinimum, prix) VALUES 
('ABCEDYL PA', 350, 20,  9.62),
('ACTI-TETRA I', 200, 10,  41.23),
('AMPHOPRIM', 50, 5,  5.30),
('AMPICOLINE', 75, 8,  14.20),
('ALUSPRAY', 100, 10,  12.45),
('ALFABEDYL', 230, 20,  19.99),
('AMPIDEXALONE', 350, 30,  31.34),
('ACETAL', 130, 10,  9.80),
('AD-JECT', 160, 10,  34.98),
('ACTILIVER I', 380, 30,  84.00),
('AZIUM', 90, 9,  10.30),
('ARA PNEUMOPATHIE', 70, 5,  16.83),
('AMOXIVAL 40', 90, 7,  48.39),
('AMFLEE 50', 75, 8,  6.43),
('ABCEDYL PA', 95, 10,  13.11),
('AEROSOL BIOALLETHRINE', 100, 10,  31.32),
('AMIDERM', 125, 11,  11.00),
('ALARM', 145, 15,  21.34);

INSERT INTO Veterinaire (idVeterinaire, signature) VALUES 
((SELECT idPersonne FROM Personne WHERE Personne.nom = "Veterinaire"), "Signature Veterinaire");