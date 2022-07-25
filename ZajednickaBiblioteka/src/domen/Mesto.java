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
public class Mesto implements Serializable, OpstiDomenskiObjekat {

    private int ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getPtt() {
        return ptt;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    @Override
    public String vratiVrAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "mesto";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
        ptt = rs.getInt("PTT");
        naziv = rs.getString("Naziv");
    }

    @Override
    public String vratiNazivPK() {
        return "PTT";
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new Mesto();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
