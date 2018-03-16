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
    private String KundenId = "";
    
    @ManyToOne
    private String FahrzeugId = "";
    
    @Temporal(TemporalType.DATE)
    private Date startDatum = new Date();
    
    @Temporal(TemporalType.DATE)
    private Date endeDatum = new Date(); 
    
//<editor-fold defaultstate="collapsed" desc="Konstruktor">
    public Leihvertrag () {
    }
    
    public Leihvertrag (String KundenId, String FahrzeugId, Date startDatum, Date endeDatum){
        this.KundenId = KundenId;
        this.FahrzeugId = FahrzeugId;
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
    
    public String getKundenId() {
        return KundenId;
    }
    
    public void setKundenId(String KundenId) {
        this.KundenId = KundenId;
    }
    
    public String getFahrzeugId() {
        return FahrzeugId;
    }
    
    public void setFahrzeugId(String FahrzeugId) {
        this.FahrzeugId = FahrzeugId;
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
