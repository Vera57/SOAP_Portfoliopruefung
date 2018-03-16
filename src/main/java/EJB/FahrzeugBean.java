
package EJB;

import JPA.Fahrzeug;
import javax.ejb.Stateless;

/**
 *
 * @author JU_FI
 */
@Stateless
public class FahrzeugBean extends EntityBean<Fahrzeug, Long> {
    
    public FahrzeugBean(){
        super(Fahrzeug.class);
    }
}
