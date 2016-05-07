CREATE TABLE Platnosci (ID int(10) NOT NULL AUTO_INCREMENT, PRIMARY KEY (ID));
CREATE TABLE Producenci (ID int(10) NOT NULL AUTO_INCREMENT, Nazwa varchar(255), PRIMARY KEY (ID));
CREATE TABLE Produkt (ID int(10) NOT NULL AUTO_INCREMENT, `Typ produktuID` int(10) NOT NULL, ProducentID int(10) NOT NULL, Nazwa varchar(255), Cena double, Opis varchar(255), PRIMARY KEY (ID));
CREATE TABLE Role (ID int(10) NOT NULL AUTO_INCREMENT, PRIMARY KEY (ID));
CREATE TABLE TypyProduktu (ID int(10) NOT NULL AUTO_INCREMENT, Nazwa varchar(255), PRIMARY KEY (ID));
CREATE TABLE Uzytkownicy (ID int(10) NOT NULL AUTO_INCREMENT, RolaID int(10) NOT NULL, Imie varchar(255), Nazwisko varchar(255), PESEL int(10), NIP int(10), NumerTelefonu int(10), Email varchar(255), Ulica varchar(255), NrBudynku int(10), NrLokalu int(10), Miasto varchar(255), KodPocztowy varchar(255), PRIMARY KEY (ID));
CREATE TABLE Wysylki (ID int(10) NOT NULL AUTO_INCREMENT, POCZTA int(10), KURIER int(10), ODBIOR_OSOBISTY int(10), PRIMARY KEY (ID));
CREATE TABLE ZamawianeProdukty (ID int(10) NOT NULL AUTO_INCREMENT, Liczba int(10), ProduktID int(10) NOT NULL, ZamowienieID int(10) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Zamowienia (ID int(10) NOT NULL AUTO_INCREMENT, WysylkaID int(10) NOT NULL, PlatnoscID int(10) NOT NULL, UzytkownikID int(10) NOT NULL, Data int(10), PRIMARY KEY (ID));
ALTER TABLE Zamowienia ADD INDEX ma (PlatnoscID), ADD CONSTRAINT ma FOREIGN KEY (PlatnoscID) REFERENCES Platnosci (ID);
ALTER TABLE Zamowienia ADD INDEX ma2 (WysylkaID), ADD CONSTRAINT ma2 FOREIGN KEY (WysylkaID) REFERENCES Wysylki (ID);
ALTER TABLE Uzytkownicy ADD INDEX ma3 (RolaID), ADD CONSTRAINT ma3 FOREIGN KEY (RolaID) REFERENCES Role (ID);
ALTER TABLE Produkt ADD INDEX produkuje (ProducentID), ADD CONSTRAINT produkuje FOREIGN KEY (ProducentID) REFERENCES Producenci (ID);
ALTER TABLE Produkt ADD INDEX sa (`Typ produktuID`), ADD CONSTRAINT sa FOREIGN KEY (`Typ produktuID`) REFERENCES TypyProduktu (ID);
ALTER TABLE ZamawianeProdukty ADD INDEX `sa ` (ProduktID), ADD CONSTRAINT `sa ` FOREIGN KEY (ProduktID) REFERENCES Produkt (ID);
ALTER TABLE Zamowienia ADD INDEX sklada (UzytkownikID), ADD CONSTRAINT sklada FOREIGN KEY (UzytkownikID) REFERENCES Uzytkownicy (ID);
ALTER TABLE ZamawianeProdukty ADD INDEX zawiera (ZamowienieID), ADD CONSTRAINT zawiera FOREIGN KEY (ZamowienieID) REFERENCES Zamowienia (ID);

