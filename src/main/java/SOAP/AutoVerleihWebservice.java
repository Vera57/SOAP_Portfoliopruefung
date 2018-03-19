/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import EJB.FahrzeugBean;
import EJB.KundeBean;
import EJB.LeihvertragBean;
import JPA.Fahrzeug;
import JPA.Kunde;
import JPA.Leihvertrag;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@Stateless
@WebService
public class AutoVerleihWebservice {
    
    @EJB 
    FahrzeugBean fahrzeugBean; 
    
    @EJB
    KundeBean kundeBean; 
    
    @EJB
    LeihvertragBean leihvertragBean;
    
    public AutoVerleihWebservice (){
    }
    
    @WebMethod
    @WebResult(name="kundeRegistrieren")
    public Kunde kundeRegistrieren (Kunde kunde){
        return this.kundeBean.saveNew(kunde);
    }
    
    @WebMethod
    @WebResult(name="fahrzeugAnlegen")
    public Fahrzeug fahrzeugAnlegen (Fahrzeug fahrzeug) {
        return this.fahrzeugBean.saveNew(fahrzeug);
    }
    
    @WebMethod
    @WebResult(name="saveNewLeihvertrag")
    public Leihvertrag saveNewLeihvertrag (@WebParam(name = "leihvertrag") Leihvertrag leihvertrag, 
                                           @WebParam(name = "fahrzeug") Fahrzeug fahrzeug,
                                           @WebParam(name = "startDatum") Date startDatum,
                                           @WebParam(name = "endeDatum") Date endeDatum){
        return this.leihvertragBean.saveNewLeihvertrag(leihvertrag, fahrzeug, startDatum, endeDatum );
    }
    
    @WebMethod
    @WebResult(name="fahrzeugeList")
    public List<Fahrzeug> findAllFahrzeuge () {
        return this.fahrzeugBean.findAll();
    }
    
    @WebMethod
    @WebResult(name="leihvertraegeList")
    public List<Leihvertrag> findByKundenId (@WebParam(name = "KundenId") String KundenId) {
        return this.leihvertragBean.findByKundenId(KundenId);
    }
    
    
    
}
