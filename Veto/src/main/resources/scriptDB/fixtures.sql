INSERT INTO Personne (idVille, nom, prenom, dateNaissance, adresse, mail, telephone) VALUES
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'QUERRE', 'Clément', DATE("1999-12-23"), '45 Route de Employe1 34530 Mutch', 'cquerre.test@email.com', '06.01.01.01.01'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'BOURY', 'Elie', DATE("1999-12-23"), '45 Route de Employe2 34530 Mutch', 'eboury.test@email.com', '06.01.01.01.02'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'MORAX', 'Dorian', DATE("1999-12-23"), '45 Route de Employe3 34530 Mutch', 'dmorax.test@email.com', '06.01.01.01.03'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'POTIN', 'Mateo', DATE("1999-12-23"), '45 Route de Employe3 34530 Mutch', 'mpotin.test@email.com', '06.01.01.01.03'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'VINCENT', 'Bastien', DATE("1999-12-23"), '45 Route de Employe3 34530 Mutch', 'bvincent.test@email.com', '06.01.01.01.03'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'RAYNAL', 'Maxime', DATE("1999-12-23"), '45 Route de Employe3 34530 Mutch', 'mraynal.test@email.com', '06.01.01.01.03'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'ARAGON', 'Nathan', DATE("1999-12-23"), '45 Route de Employe3 34530 Mutch', 'nagaron.test@email.com', '06.01.01.01.03'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'NISLA', 'Client1', DATE("1999-12-23"), '45 Route de Client1 34530 Mutch', 'cli1.test@email.com', '06.01.01.02.01'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Libourne'), 'RIVE', 'Client2', DATE("1999-12-23"), '45 Route de Client2 34530 Mutch', 'cli2.test@email.com', '06.01.01.02.02'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Gradignan'), 'PASO', 'Client3', DATE("1999-12-23"), '45 Route de Client3 34530 Mutch', 'cli3.test@email.com', '06.01.01.02.03'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'VALICE', 'Client4', DATE("1999-12-23"), '45 Route de Client4 34530 Mutch', 'cli4.test@email.com', '06.01.01.02.04'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Ozan'), 'BACRE', 'Client5', DATE("1999-12-23"), '45 Route de Client5 34530 Mutch', 'cli5.test@email.com', '06.01.01.02.05'),
((SELECT id FROM Ville WHERE Ville.ville_nom_reel = 'Gradignan'), 'MAUX', 'Annie', DATE("1999-12-23"), '45 Route de Veto 34530 Mutch', 'vet.test@email.com', '06.34.35.36.37');

INSERT INTO Employe (id, login, motDePasse, dateDebutContrat, salaire) VALUES
((SELECT id FROM Personne WHERE Personne.nom = 'QUERRE'), 'cquerre', 'test', DATE("2015-10-23"), 2340.35),
((SELECT id FROM Personne WHERE Personne.nom = 'BOURY'), 'eboury', 'test', DATE("2004-12-10"), 15000.34),
((SELECT id FROM Personne WHERE Personne.nom = 'MORAX'), 'dmorax', 'test', DATE("2013-01-3") , null),
((SELECT id FROM Personne WHERE Personne.nom = 'POTIN'), 'mpotin', 'test', DATE("2013-01-3") , null),
((SELECT id FROM Personne WHERE Personne.nom = 'VINCENT'), 'bvincent', 'test', DATE("2013-01-3") , null),
((SELECT id FROM Personne WHERE Personne.nom = 'RAYNAL'), 'mraynal', 'test', DATE("2013-01-3") , null),
((SELECT id FROM Personne WHERE Personne.nom = 'ARAGON'), 'naragon', 'test', DATE("2013-01-3") , null),
((SELECT id FROM Personne WHERE Personne.nom = 'MAUX'), 'amaux', 'test', DATE("2013-01-3") , null);

INSERT INTO Client (id) VALUES
((SELECT id FROM Personne WHERE Personne.nom = "NISLA")),
((SELECT id FROM Personne WHERE Personne.nom = "RIVE")),
((SELECT id FROM Personne WHERE Personne.nom = "PASO")),
((SELECT id FROM Personne WHERE Personne.nom = "VALICE")),
((SELECT id FROM Personne WHERE Personne.nom = "BACRE"));

INSERT INTO Log (idEmploye, action) VALUES 
((SELECT id FROM Employe WHERE Employe.login = 'cquerre'), "New Client"),
((SELECT id FROM Employe WHERE Employe.login = 'cquerre'), "New Race"),
((SELECT id FROM Employe WHERE Employe.login = 'eboury'), "Remove Client"),
((SELECT id FROM Employe WHERE Employe.login = 'cquerre'), "Remove Produit"),
((SELECT id FROM Employe WHERE Employe.login = 'dmorax'), "Edit Produit"),
((SELECT id FROM Employe WHERE Employe.login = 'dmorax'), "New Produit"),
((SELECT id FROM Employe WHERE Employe.login = 'eboury'), "New Client"),
((SELECT id FROM Employe WHERE Employe.login = 'eboury'), "New Race"),
((SELECT id FROM Employe WHERE Employe.login = 'cquerre'), "New Espece"),
((SELECT id FROM Employe WHERE Employe.login = 'cquerre'), "New Race"),
((SELECT id FROM Employe WHERE Employe.login = 'cquerre'), "Remove Ordonnance");

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
((SELECT id FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster hybride');

INSERT INTO Animal (idRace, idClient, nom, dateNaissance, sexe) VALUES
((SELECT id FROM Race WHERE Race.nom = 'Japonais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "NISLA"), 'PamPam', DATE("2007-10-23"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Golden retriever'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "NISLA"), 'Capucine', DATE("2007-10-13"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Golden retriever'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "NISLA"), 'Aristide', DATE("2007-10-4"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "NISLA"), 'Barney', DATE("2007-10-5"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "NISLA"), 'Chanel', DATE("2007-10-10"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Golden retriever'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "RIVE"), 'Dolph', DATE("2007-2-1"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Japonais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "RIVE"), 'Fripouille', DATE("2007-2-5"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "PASO"), 'Noisette', DATE("2007-3-1"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "PASO"), 'Ducros', DATE("2007-3-2"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Baladi'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "PASO"), 'Diego', DATE("2007-3-3"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Japonais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "PASO"), 'Ed', DATE("2007-3-4"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "PASO"), 'Earl', DATE("2007-3-5"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "PASO"), 'Dolf', DATE("2007-3-6"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "PASO"), 'Boris', DATE("2007-3-7"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "PASO"), 'Barney', DATE("2007-3-8"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "VALICE"), 'Alex', DATE("2007-4-1"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Balinais'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "VALICE"), 'Choupette', DATE("2007-4-5"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "VALICE"), 'PamPam', DATE("2007-4-4"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "VALICE"), 'Houmou', DATE("2007-4-13"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Baladi'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "BACRE"), 'Bounty', DATE("2007-5-5"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "BACRE"), 'Noisette', DATE("2007-5-13"), 'F'),
((SELECT id FROM Race WHERE Race.nom = 'Hamster hybride'), (SELECT C.id FROM Client C INNER JOIN Personne P ON P.id = C.id WHERE P.nom = "BACRE"), 'Gerbille', DATE("2007-5-24"), 'F');

INSERT INTO Produit (nom, refProduit, quantiteEnStock, quantiteMinimum, prix, peremption, dateAcquisition) VALUES
('ABCEDYL PA', 'KIVZEUFH', 350, 20,  9.62, '2019-9-12', '2018-10-25'),
('ACTI-TETRA I', 'HJSDGF34', 200, 10,  41.23, '2019-11-28', '2018-2-13'),
('AMPHOPRIM', 'J234DF', 50, 5,  5.30, '2019-6-8', '2018-5-26'),
('AMPICOLINE', 'KJHEFREZ73', 75, 8,  14.20, '2019-12-12', '2018-5-2'),
('ALUSPRAY', 'NJZEF7', 100, 10,  12.45, '2020-2-12', '2018-11-14'),
('ALFABEDYL', '82364BDS', 230, 20,  19.99, '2019-11-17', '2018-4-29'),
('AMPIDEXALONE', 'HGDSF6SD', 350, 30,  31.34, '2020-1-3', '2018-10-12'),
('ACETAL','JHDGF678ES', 130, 10,  9.80, '2019-7-15', '2018-3-21'),
('AD-JECT', 'KJHZAER86',160, 10,  34.98, '2019-9-12', '2018-10-25'),
('ACTILIVER I', 'LKZ342Q',380, 30,  84.00, '2019-9-12', '2018-10-25'),
('AZIUM', 'JSHDG8',90, 9,  10.30, '2019-9-12', '2018-10-25'),
('ARA PNEUMOPATHIE','KSFZAR', 70, 5,  16.83, '2020-2-12', '2018-3-21'),
('AMOXIVAL 40','QSFEAF', 90, 7,  48.39, '2019-11-28', '2018-10-25'),
('AMFLEE 50', 'SDSGEZ',75, 8,  6.43, '2019-9-12', '2018-10-25'),
('ABCEDYL PA','EZFSDFDSF', 95, 10,  13.11, '2019-9-12', '2018-10-25'),
('AEROSOL BIOALLETHRINE','EZFECA', 100, 10,  31.32, '2019-9-12', '2018-5-26'),
('AMIDERM','EZFCAAS', 125, 11,  11.00, '2019-11-17', '2018-10-25'),
('ALARM','VGAEIUOAF', 145, 15,  21.34, '2019-9-12', '2018-5-2');


INSERT INTO Veterinaire (id, signature) VALUES
((SELECT id FROM Personne P WHERE P.nom = "MAUX"), "Signature MAUX");

INSERT INTO Ordonnance (Ordonnance.idAnimal, Ordonnance.idVeterinaire, dateOrdonnance) VALUES
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Hamster hybride'
		AND P.nom = 'BACRE' 
		AND P.prenom = 'Client5' 
		AND A.nom = 'Noisette'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE()),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Baladi'
		AND P.nom = 'PASO' 
		AND P.prenom = 'Client3' 
		AND A.nom = 'Diego'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE()),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Hamster hybride'
		AND P.nom = 'BACRE' 
		AND P.prenom = 'Client5' 
		AND A.nom = 'Gerbille'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE()),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Japonais'
		AND P.nom = 'NISLA' 
		AND P.prenom = 'Client1' 
		AND A.nom = 'PamPam'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE()),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Golden retriever'
		AND P.nom = 'RIVE' 
		AND P.prenom = 'Client2' 
		AND A.nom = 'Dolph'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE()),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Hamster hybride'
		AND P.nom = 'VALICE' 
		AND P.prenom = 'Client4' 
		AND A.nom = 'PamPam'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE()),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Balinais'
		AND P.nom = 'PASO' 
		AND P.prenom = 'Client3' 
		AND A.nom = 'Ducros'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE()),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Hamster hybride'
		AND P.nom = 'BACRE' 
		AND P.prenom = 'Client5' 
		AND A.nom = 'Noisette'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE()),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Balinais'
		AND P.nom = 'VALICE' 
		AND P.prenom = 'Client4' 
		AND A.nom = 'Alex'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE()),
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient 
		INNER JOIN Personne P ON P.id = C.id 
		WHERE R.nom = 'Balinais'
		AND P.nom = 'VALICE' 
		AND P.prenom = 'Client4' 
		AND A.nom = 'Choupette'), 
(SELECT V.id FROM Veterinaire V
		INNER JOIN Personne P ON P.id = V.id
		WHERE P.nom = 'MAUX' 
		AND P.prenom = 'Annie'), 
CURDATE());

INSERT INTO Traitement (idAnimal, maladie, soin, dateDebut, dateFin) VALUES
((SELECT A.id FROM Animal A
		INNER JOIN Race R ON R.id = A.idRace
		INNER JOIN Client C ON C.id = A.idClient
		INNER JOIN Personne P ON P.id = C.id
		WHERE R.nom = 'Balinais'
		AND P.nom = 'VALICE'
		AND P.prenom = 'Client4'
		AND A.nom = 'Choupette'), "Patte Cassée", "Plâtre", CURDATE(), null);