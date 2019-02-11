INSERT INTO Race (idEspece, nom) VALUES 
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'),'Alaska'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'),'Blanc danois'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'),'Grand Russe'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Lapin'),'Japonais');

INSERT INTO Race (idEspece, nom) VALUES 
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'),'Abyssin'), 
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'),'American curl'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'),'Anatoli'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chat'),'Balinais');

INSERT INTO Race (idEspece, nom) VALUES 
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'),'Appaloosa'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'),'Bachkir'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'),'Baladi'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Cheval'),'Edelbluthaflinger');

INSERT INTO Race (idEspece, nom) VALUES 
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'),'Berger allemand'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'),'Berger belge'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'),'Border Terrier'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Chien'),'Golden retriever');

INSERT INTO Race (idEspece, nom) VALUES 
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster de Syrie'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster d\'Europe'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster de Campbell'),
((SELECT idEspece FROM Espece WHERE Espece.nom = 'Hamster'),'Hamster hybride');

