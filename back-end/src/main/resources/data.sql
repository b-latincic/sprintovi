

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');


INSERT INTO sprint (id, ime, ukupno_bodova) VALUES (1, 'Sprint 1', 40);
INSERT INTO sprint (id, ime, ukupno_bodova) VALUES (2, 'Sprint 2', 30); 


INSERT INTO stanje (id, ime) VALUES (1, 'NOV'); 
INSERT INTO stanje (id, ime) VALUES (2, 'U TOKU'); 
INSERT INTO stanje (id, ime) VALUES (3, 'ZAVRŠENO'); 


INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (1, 'Brisanje', 'Mile', 10, 1, 1);
INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (2, 'Update', 'Mitar', 15, 1, 2); 
INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (3, 'Organizacija', 'Mara', 20, 2, 3); 
INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (4, 'Finalizacija', 'Mira', 10, 2, 3); 
INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (5, 'Review', 'Pera', 10, 1, 1);  
INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (6, 'Revizija', 'Mara', 12, 2, 1);  
INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (7, 'Zatvaranje', 'Mile', 8, 1, 1);  
