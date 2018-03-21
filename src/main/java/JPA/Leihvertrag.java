/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Leihvertrag implements Serializable {
    
    @Id
    @GeneratedValue(generator = "leihvertrag_ids")
    @TableGenerator(name = "leihvertrag_ids", initialValue = 0, allocationSize = 50)
    private long id = 0L;
    
    @ManyToOne
    private Kunde kunde;
    
    @ManyToOne
    private Fahrzeug fahrzeug;
    
    @Temporal(TemporalType.DATE)
    private Date startDatum = new Date();
    
    @Temporal(TemporalType.DATE)
    private Date endeDatum = new Date(); 
    
//<editor-fold defaultstate="collapsed" desc="Konstruktor">
    public Leihvertrag () {
    }
    
    public Leihvertrag (Kunde kunde, Fahrzeug fahrzeug, Date startDatum, Date endeDatum){
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.startDatum = startDatum;
        this.endeDatum = endeDatum;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Kunde getKunde() {
        return kunde;
    }
    
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
    
    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }
    
    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }
    
    public Date getStartDatum() {
        return startDatum;
    }
    
    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }
    
    public Date getEndeDatum() {
        return endeDatum;
    }
    
    public void setEndeDatum(Date endeDatum) {
        this.endeDatum = endeDatum;
    }
//</editor-fold>
}
