/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Leihvertrag;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class LeihvertragBean extends EntityBean <Leihvertrag, Long> {
    
    public LeihvertragBean () {
        super(Leihvertrag.class);
    }
    
    public List <Leihvertrag> findByKundenId (String KundenId) {
        return this.em.createQuery("SELECT l FROM Leihvertrag l WHERE l.KundenId = :KundenId ORDER BY l.startDatum")
                .setParameter("KundenId", KundenId)
                .getResultList();
    }
}
