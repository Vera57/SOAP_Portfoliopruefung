/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import JPA.Fahrzeug;
import JPA.Kunde;
import JPA.Leihvertrag;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class LeihvertragBean extends EntityBean <Leihvertrag, Long> {
    
    public LeihvertragBean () {
        super(Leihvertrag.class);
    }
    
    public List <Leihvertrag> findByKundenId (Kunde kunde) {
        return this.em.createQuery("SELECT l FROM Leihvertrag l WHERE l.kunde = :kunde ORDER BY l.startDatum")
                .setParameter("kunde", kunde)
                .getResultList();
    }
    
    public List<Leihvertrag> findLeihvertragKonflikt (Fahrzeug fahrzeug, Date startDatum, Date endeDatum) {
        return this.em.createQuery( "SELECT l FROM Leihvertrag l"
                                    + " WHERE l.fahrzeug = :fahrzeug AND "
                                            + "( l.startDatum <= :startDatum AND "
                                            + "l.endeDatum >= :startDatum"
                                        + ") OR ("
                                            + "l.startDatum <= :endeDatum AND "
                                            + "l.endeDatum >= :endeDatum"
                                        + ") OR ("
                                            + "l.startDatum >= :startDatum AND "
                                            + "l.endeDatum <= :endeDatum)")
                .setParameter("startDatum", startDatum)
                .setParameter("endeDatum", endeDatum)
                .setParameter("fahrzeug", fahrzeug.getId())
                .getResultList();
    }
    
    public Leihvertrag saveNewLeihvertrag (Leihvertrag leihvertrag,Fahrzeug fahrzeug, Date startDatum, Date endeDatum){ 
        Leihvertrag r =null;
        if (this.findLeihvertragKonflikt(fahrzeug, startDatum, endeDatum).isEmpty()) {
                em.persist(leihvertrag);
                r = em.merge(leihvertrag);
        }
        return r;
    }    
}
