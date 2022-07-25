/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Korisnik
 */
public class PredmetOsiguranja implements Serializable, OpstiDomenskiObjekat{
    private int predmetID;
    private String naziv;
    private String napomena;
    public PredmetOsiguranja() {
    }

    public PredmetOsiguranja(int predmetID, String naziv, String napomena) {
        this.predmetID = predmetID;
        this.naziv = naziv;
        this.napomena = napomena;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getNapomena() {
        return napomena;
    }
    

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(int predmetID) {
        this.predmetID = predmetID;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiVrAtributa() {
        return predmetID+", '"+naziv+"', '"+napomena+"'";
    }

    @Override
    public String postaviVrAtributa() {
        return "PredmetID = "+predmetID+", Naziv = '"+naziv+"', Napomena = '"+napomena+"'";
    }

    @Override
    public String vratiImeKlase() {
        return "PredmetOsiguranja";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return null;
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
        naziv = rs.getString("Naziv");
        predmetID = rs.getInt("PredmetID");
        napomena = rs.getString("Napomena");
    }

    @Override
    public String vratiNazivPK() {
        return "PredmetID";
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new PredmetOsiguranja();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Object id) {
        predmetID = (int) id;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
    
}
