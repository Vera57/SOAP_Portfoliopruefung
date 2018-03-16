
package JPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 *
 * @author JU_FI
 */
@Entity
public class Fahrzeug implements Serializable {

   
    
    @Id
    @GeneratedValue(generator = "fahrzeug_ids")
    @TableGenerator(name = "fahrzeug_ids", initialValue = 0, allocationSize = 50)
    private long id;

    private String hersteller = "";
    private String modell = "";
    private String baujahr = ""; 

    //<editor-fold defaultstate="collapsed" desc="Konstruktor">
    public Fahrzeug(){
        
    }
    
    public Fahrzeug(String hersteller, String modell, String baujahr){
        this.hersteller = hersteller;
        this.modell = modell;
        this.baujahr = baujahr;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getHersteller() {
        return hersteller;
    }
    
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    
    public String getModell() {
        return modell;
    }
    
    public void setModell(String modell) {
        this.modell = modell;
    }
    
    public String getBaujahr() {
        return baujahr;
    }
    
    public void setBaujahr(String baujahr) {
        this.baujahr = baujahr;
    }
//</editor-fold>
    
    
    
    
    
    
    
}
