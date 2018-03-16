/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import JPA.Fahrzeug;
import JPA.Kunde;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.Holder;


public class Main {
    
    private final AutoVerleihWebservice ws;
    private final BufferedReader fromKeyboard; 
    
    
    public static void main(String[] args) throws IOException, DatatypeConfigurationException {
        // Damit wir nicht so viele static-Methoden haben, erzeugen wir
        // hier erstmal ein Objekt und übergeben ihm die Kontrolle.
        Main main = new Main();
        main.runMainMenu();
    }
    
    public Main() {
        // Webservice-Stub erzeugen
        tvglobal = new TVGlobal();
        this.ws = tvglobal.getTVGlobalSoapWebservicePort();

        // Datenstrom zum Einlesen von Tastatureingaben erzeugen
        this.fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
    }
    
     public void runMainMenu() throws IOException, DatatypeConfigurationException {
        System.out.println("Car Sharing");
        System.out.println();

        boolean quit = false;

        while (!quit) {
            System.out.println("=========");
            System.out.println("Hauptmenü");
            System.out.println("=========");
            System.out.println();
            System.out.println("  [K] Kunde anlegen");
            System.out.println("  [F] Fahrzeug nalegen");
            System.out.println("  [A] Fahrzeug ausleihen");
            System.out.println("  [L] Leihverträge auflisten");
            System.out.println("  [E] Ende");
            System.out.println();

            System.out.print("Deine Auswahl: ");
            String command = this.fromKeyboard.readLine();
            System.out.println();

            switch (command.toUpperCase()) {
                case "K":
                    this.kundeAnlegen();
                    break;
                case "F":
                    this.fahrzeugAnlegen();
                    break;
                case "A":
                    this.fahrzeugAusleihen();
                    break;
                case "L":
                    this.leihvertraegeAuflisten();
                    break;
                case "E":
                    quit = true;
                    break;
                default:
                    System.out.println("Sorry, ich habe dich nicht verstanden …");
                    System.out.println();
            }
        }
    }

     public void kundeAnlegen()throws IOException, DatatypeConfigurationException{
        System.out.println("================");
        System.out.println("Kunde anlegen");
        System.out.println("================");
        System.out.println();
        
        //Daten des Benutzers abfragen
        
        System.out.print("Vorname  : ");
        String vorname = this.fromKeyboard.readLine();
        
        System.out.print("Nachname : ");
        String nachname = this.fromKeyboard.readLine();
        
        System.out.print("Straße  : ");
        String strasse = this.fromKeyboard.readLine();
        
        System.out.print("Hausnummer  : ");
        String hausnummer = this.fromKeyboard.readLine();
        
        System.out.print("Postleizahl  : ");
        String plz = this.fromKeyboard.readLine();
        
        System.out.print("Ort  : ");
        String ort = this.fromKeyboard.readLine();
        
        System.out.print("Land  : ");
        String land = this.fromKeyboard.readLine();
        
        //Webservice aufrufen
        Kunde kunde = new Kunde();
        kunde.setVorname(vorname);
        kunde.setNachname(nachname);
        kunde.setStrasse(strasse);
        kunde.setHausnummer(hausnummer);
        kunde.setPlz(plz);
        kunde.setOrt(ort);
        kunde.setLand(land);
        
        Holder<Kunde> hKunde = new Holder<>(kunde);
        ws.kundeRegistrieren(kunde);
        
        System.out.println("Kunde mit der ID " + hKunde.value.getId()+"wurde angelegt.");
     }
     
     public void fahrzeugAnlegen() throws IOException, DatatypeConfigurationException{
        
        System.out.println("================");
        System.out.println("Fahrzeug anlegen");
        System.out.println("================");
        System.out.println();   
       
        //Daten des Fahrzeugs eingeben
        
        System.out.print("Vorname  : ");
        String hersteller = this.fromKeyboard.readLine();
        
        System.out.print("Modell : ");
        String modell = this.fromKeyboard.readLine();
        
        System.out.print("Baujahr  : ");
        String baujahr = this.fromKeyboard.readLine();
        
        Fahrzeug fahrzeug = new Fahrzeug();
        fahrzeug.setHersteller(hersteller);
        fahrzeug.setModell(modell);
        fahrzeug.setBaujahr(baujahr);
        
        Holder<Fahrzeug> hFahrzeug = new Holder<>(fahrzeug);
        ws.fahrzeugAnlegen(fahrzeug);
        
        System.out.println("Fahrzeug mit der ID " + hFahrzeug.value.getId()+"wurde angelegt.");
        
        
     }
     
     public void fahrzeugAusleihen() throws IOException, DatatypeConfigurationException{
        System.out.println("================");
        System.out.println("Fahrzeug ausleihen");
        System.out.println("================");
        System.out.println();   
        System.out.println("Folgende Fahrzeuge stehen zur Verfügung:"); 
        
        List<Fahrzeug> fahrzeug = this.ws.findAllFahrzeuge();
        System.out.println(fahrzeug.value.getHersteller() + ", ");
     }
     
     public void leihvertraegeAuflisten() throws IOException, DatatypeConfigurationException{
         
     }
     
     
}



