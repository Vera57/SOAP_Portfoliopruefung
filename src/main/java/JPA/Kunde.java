/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 *
 * @author Vera
 */
@Entity
public class Kunde implements Serializable{
     @Id
    @GeneratedValue(generator="kunde_ids")
    @TableGenerator(name="kunde_ids", initialValue=0, allocationSize=50)
    private long id=0L;
     
     private String vorname;
     private String nachname;
     private String strasse;
     private String hausnummer;
     private String plz;
     private String ort;
     private String land;
     
     //<editor-fold defaultstate="collapsed" desc="Konstruktor">
     public Kunde(){
     }
     public Kunde(String vorname,String nachname, String strasse, String hausnummer,String plz, String ort, String land){
         this.vorname=vorname;
         this.nachname=nachname;
         this.strasse=strasse;
         this.hausnummer=hausnummer;
         this.plz=plz;
         this.ort=ort;
         this.land=land;
     }
     public Kunde(String vorname, String nachname){
         this.vorname=vorname;
         this.nachname=nachname;
     }
//</editor-fold>

     //<editor-fold defaultstate="collapsed" desc="Getter und Setter">
     public long getId() {
         return id;
     }
     
     public void setId(long id) {
         this.id = id;
     }
     
     public String getVorname() {
         return vorname;
     }
     
     public void setVorname(String vorname) {
         this.vorname = vorname;
     }
     
     public String getNachname() {
         return nachname;
     }
     
     public void setNachname(String nachname) {
         this.nachname = nachname;
     }
     
     public String getStrasse() {
         return strasse;
     }
     
     public void setStrasse(String strasse) {
         this.strasse = strasse;
     }
     
     public String getHausnummer() {
         return hausnummer;
     }
     
     public void setHausnummer(String hausnummer) {
         this.hausnummer = hausnummer;
     }
     
     public String getPlz() {
         return plz;
     }
     
     public void setPlz(String plz) {
         this.plz = plz;
     }
     
     public String getOrt() {
         return ort;
     }
     
     public void setOrt(String ort) {
         this.ort = ort;
     }
     
     public String getLand() {
         return land;
     }
     
     public void setLand(String land) {
         this.land = land;
     }
//</editor-fold>
     
     
    
}
