INSERT INTO `givemeacar_management_system`.`cars` (`agency`, `etat`, `availability`, `kilometrage`, `marque`, `model`) 
    VALUES ('Nantes', 'Prête', 1, 0, 'Ford', 'Focus'),
           ('Nantes', 'Prête', 1, 0, 'Fiat', 'Punto'),
           ('Nantes', 'Prête', 1, 0, 'Toyota', 'Yaris'),
           ('Nantes', 'Prête', 1, 0, 'Audi', 'A4');


INSERT INTO `givemeacar_management_system`.`clients` (`adress`, `city`, `email`, `firstname`, `lastname`, `phone`) 
    VALUES ('16 bis Quai Henri Barbus', 'Nantes', 'yannick.lajdecki@gmail.com', 'yannick', 'lajdecki', '0621364561'),
           ('45 rue du Vietnam', 'Nantes', 'john@rambo.org', 'john', 'rambo', '0612553548'),
           ('87 rue de l\'asile', 'Nantes', 'sarha.conor@gmail.com', 'sarha', 'conor', '0621364565'),
           ('18 rue du grand-écart', 'Nantes', 'jcvd@yahoo.com', 'jean-claude', 'vandame', '0621565487');

INSERT INTO `givemeacar_management_system`.`contracts` (`date`, `car_id`, `client_id`) 
    VALUES ('2021-01-01 14\"15\'22', '1', '4'),
           ('2021-01-15 12\"32\'12', '2', '1'),
           ('2021-02-21 13\"45\'11', '3', '2'),
           ('2021-02-25 11\"41\'18', '4', '3');
