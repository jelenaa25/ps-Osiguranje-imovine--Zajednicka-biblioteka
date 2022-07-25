/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public interface OpstiDomenskiObjekat {
    String vratiVrAtributa();
    String postaviVrAtributa();
    String vratiImeKlase();
    String vratiUslovZaNadjiSlog();
    void napuni(ResultSet rs) throws SQLException;
    String vratiNazivPK();
    public OpstiDomenskiObjekat kreirajInstancu();
    public String vratiUslovZaNadjiSlogove();
    public default OpstiDomenskiObjekat vratiSlabObjekat(){return null;};
    public default List<OpstiDomenskiObjekat> slabiObjekti(){return null;};
    public default void postaviSlabeObjekte(List<OpstiDomenskiObjekat> slabi){};
    public void setId(Object id);
    public default Object getID(){return null;};
    public default OpstiDomenskiObjekat kreirajInstancuSlabogObjekta(){return null;};
    public default OpstiDomenskiObjekat vratiInstancuNadKlase(){return null;};
}
