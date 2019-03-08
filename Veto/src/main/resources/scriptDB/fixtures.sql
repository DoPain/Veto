/*INSERT INTO Personne (idVille, nom, prenom, dateNaissance, adresse, mail, telephone) VALUES
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestE1', 'Employe1', DATE("1999-12-23"), '45 Route de Employe1 34530 Mutch', 'emp1.test@email.com', '06.01.01.01.01'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestE2', 'Employe2', DATE("1999-12-23"), '45 Route de Employe2 34530 Mutch', 'emp2.test@email.com', '06.01.01.01.02'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestE3', 'Employe3', DATE("1999-12-23"), '45 Route de Employe3 34530 Mutch', 'emp3.test@email.com', '06.01.01.01.03'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestC1', 'Client1', DATE("1999-12-23"), '45 Route de Client1 34530 Mutch', 'cli1.test@email.com', '06.01.01.02.01'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Libourne'), 'TestC2', 'Client2', DATE("1999-12-23"), '45 Route de Client2 34530 Mutch', 'cli2.test@email.com', '06.01.01.02.02'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Gradignan'), 'TestC3', 'Client3', DATE("1999-12-23"), '45 Route de Client3 34530 Mutch', 'cli3.test@email.com', '06.01.01.02.03'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestC4', 'Client4', DATE("1999-12-23"), '45 Route de Client4 34530 Mutch', 'cli4.test@email.com', '06.01.01.02.04'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'TestC5', 'Client5', DATE("1999-12-23"), '45 Route de Client5 34530 Mutch', 'cli5.test@email.com', '06.01.01.02.05'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Gradignan'), 'Veterinaire', 'Madame', DATE("1999-12-23"), '45 Route de Veto 34530 Mutch', 'vet.test@email.com', '06.34.35.36.37');

INSERT INTO Employe (id, login, motDePasse, dateDebutContrat, salaire) VALUES
((SELECT id FROM Personne WHERE Personne.nom = 'TestE1'), 'empTest1', 'test', DATE("2015-10-23"), 2340.35),
((SELECT id FROM Personne WHERE Personne.nom = 'TestE2'), 'empTest2', 'test', DATE("2004-12-10"), 15000.34),
((SELECT id FROM Personne WHERE Personne.nom = 'TestE3'), 'empTest3', 'test', DATE("2013-01-3") , null);

INSERT INTO Client (id) VALUES
((SELECT id FROM Personne WHERE Personne.nom = "TestC1")),
((SELECT id FROM Personne WHERE Personne.nom = "TestC2")),
((SELECT id FROM Personne WHERE Personne.nom = "TestC3")),
((SELECT id FROM Personne WHERE Personne.nom = "TestC4")),
((SELECT id FROM Personne WHERE Personne.nom = "TestC5"));

INSERT INTO Log (idEmploye, action) VALUES 
((SELECT id FROM Employe WHERE Employe.login = 'empTest1'), "New Client"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest1'), "New Race"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest2'), "Remove Client"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest1'), "Remove Produit"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest3'), "Edit Produit"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest3'), "New Produit"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest2'), "New Client"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest2'), "New Race"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest1'), "New Espece"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest1'), "New Race"),
((SELECT id FROM Employe WHERE Employe.login = 'empTest1'), "Remove Ordonnance");

INSERT INTO Espece (nom) VALUES 
('Lapin'), 
('Chat'),
('Cheval'), 
('Chien'), 
('Serpent'), 
('Hamster');

INSERT INTO Race (idEspece, nom) VALUES 
((SELECT id FROM Espece WHERE Espece.nom = 'Lapin'),'Alaska'),
((SELECT id FROM Espece WHERE Espece.nom = 'Lapin'),'Blanc danois'),
((SELECT id FROM Espece WHERE Espece.nom = 'Lapin'),'Grand Russe'),
((SELECT id FROM Espece WHERE Espece.nom = 'Lapin'),'Japonais'),
((SELECT id FROM Espece WHERE Espece.nom = 'Chat'),'Abyssin'),
((SELECT id FROM Espece WHERE Espece.nom = 'Chat'),'American curl'),
((SELECT id FROM Espece WHERE Espece.nom = 'Chat'),'Anatoli'),
((SELECT id FROM Espece WHERE Espece.nom = 'Chat'),'Balinais'),
((SELECT id FROM Espece WHERE Espece.nom = 'Cheval'),'Appaloosa'),
((SELECT id FROM Espece WHERE Espece.nom = 'Cheval'),'Bachkir'),
((SELECT id FROM Espece WHERE Espece.nom = 'Cheval'),'Baladi'),
((SELECT id FROM Espece WHERE Espece.nom = 'Cheval'),'Edelbluthaflinger'),
((SELECT id FROM Espece WHERE Espece.nom = 'Chien'),'Berger allemand'),
((SELECT id FROM Espece WHERE Espece.nom = 'Chien'),'Berger belge'),
((SELECT id FROM Espece WHERE Espece.nom = 'Chien'),'Border Terrier'),
((SELECT id FROM Espece WHERE Espece.nom = 'Chien'),'Golden retriever'),
((SELECT id FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster de Syrie'),
((SELECT id FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster d\'Europe'),
((SELECT id FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster de Campbell'),
((SELECT id FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster hybride');*/

INSERT INTO Animal (idRace, idClient, nom, dateNaissance) VALUES
((SELECT id FROM Race WHERE Race.nom = 'Japonais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC1"), 'PamPam', DATE("2007-10-23")),
((SELECT id FROM Race WHERE Race.nom = 'Golden retriever'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC1"), 'Capucine', DATE("2007-10-13")),
((SELECT id FROM Race WHERE Race.nom = 'Golden retriever'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC1"), 'Aristide', DATE("2007-10-4")),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC1"), 'Barney', DATE("2007-10-5")),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC1"), 'Chanel', DATE("2007-10-10")),
((SELECT id FROM Race WHERE Race.nom = 'Golden retriever'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC2"), 'Dolph', DATE("2007-2-1")),
((SELECT id FROM Race WHERE Race.nom = 'Japonais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC2"), 'Fripouille', DATE("2007-2-5")),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC3"), 'Noisette', DATE("2007-3-1")),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC3"), 'Ducros', DATE("2007-3-2")),
((SELECT id FROM Race WHERE Race.nom = 'Baladi'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC3"), 'Diego', DATE("2007-3-3")),
((SELECT id FROM Race WHERE Race.nom = 'Japonais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC3"), 'Ed', DATE("2007-3-4")),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC3"), 'Earl', DATE("2007-3-5")),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC3"), 'Dolf', DATE("2007-3-6")),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC3"), 'Boris', DATE("2007-3-7")),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC3"), 'Barney', DATE("2007-3-8")),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC4"), 'Alex', DATE("2007-4-1")),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC4"), 'Choupette', DATE("2007-4-5")),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC4"), 'PamPam', DATE("2007-4-4")),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC4"), 'Houmou', DATE("2007-4-13")),
((SELECT id FROM Race WHERE Race.nom = 'Baladi'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC5"), 'Bounty', DATE("2007-5-5")),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC5"), 'Noisette', DATE("2007-5-13")),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "TestC5"), 'Gerbille', DATE("2007-5-24"));

INSERT INTO Produit (nom, quantiteEnStock, quantiteMinimum, prix) VALUES
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

INSERT INTO Veterinaire (id, signature) VALUES
((SELECT id FROM Personne P WHERE P.nom = "Veterinaire"), "Signature Veterinaire");

INSERT INTO Ordonnance (Ordonnance.idAnimal, Ordonnance.idVeterinaire, dateOrdonnance, commentaire) VALUES
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Hamster hybride'
		AND P.nom = 'TestC5' 
		AND P.prenom = 'Client5' 
		AND A.nom = 'Noisette'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance1"),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Baladi'
		AND P.nom = 'TestC3' 
		AND P.prenom = 'Client3' 
		AND A.nom = 'Diego'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance2"),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Hamster hybride'
		AND P.nom = 'TestC5' 
		AND P.prenom = 'Client5' 
		AND A.nom = 'Gerbille'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance3"),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Japonais'
		AND P.nom = 'TestC1' 
		AND P.prenom = 'Client1' 
		AND A.nom = 'PamPam'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance4"),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Golden retriever'
		AND P.nom = 'TestC2' 
		AND P.prenom = 'Client2' 
		AND A.nom = 'Dolph'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance5"),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Hamster hybride'
		AND P.nom = 'TestC4' 
		AND P.prenom = 'Client4' 
		AND A.nom = 'PamPam'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance6"),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Balinais'
		AND P.nom = 'TestC3' 
		AND P.prenom = 'Client3' 
		AND A.nom = 'Ducros'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance7"),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Hamster hybride'
		AND P.nom = 'TestC5' 
		AND P.prenom = 'Client5' 
		AND A.nom = 'Noisette'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance8"),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Balinais'
		AND P.nom = 'TestC4' 
		AND P.prenom = 'Client4' 
		AND A.nom = 'Alex'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance9"),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Balinais'
		AND P.nom = 'TestC4' 
		AND P.prenom = 'Client4' 
		AND A.nom = 'Choupette'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'Veterinaire' 
		AND P.prenom = 'Madame'), 
CURDATE(),
"Ordonnance10");