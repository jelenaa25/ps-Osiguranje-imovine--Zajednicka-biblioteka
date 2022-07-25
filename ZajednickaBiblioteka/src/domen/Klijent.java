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
public class Klijent implements Serializable, OpstiDomenskiObjekat{
    private int id;
    private String imePrezime;
    private long JMBG;
    private Mesto mesto;

    public Klijent(int id, String imePrezime, long JMBG, Mesto mesto) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.JMBG = JMBG;
        this.mesto = mesto;
    }

    public Klijent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public long getJMBG() {
        return JMBG;
    }

    public void setJMBG(long JMBG) {
        this.JMBG = JMBG;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return id+" "+imePrezime;
    }
    
        @Override
    public String vratiVrAtributa() {
        return id+ ", " + (imePrezime == null ? null : "'" + imePrezime + "'") + ", " + JMBG+ ", "+mesto.getPtt();
    }

    @Override
    public String postaviVrAtributa() {
        return "ImePrezime = '"+imePrezime+"', JMBG = "+JMBG+", Mesto = "+mesto.getPtt();
    }

    @Override
    public String vratiImeKlase() {
        return "klijent";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "KlijentID = "+id;
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
        id = rs.getInt("KlijentID");
        imePrezime = rs.getString("ImePrezime");
        Mesto m = new Mesto(); m.setPtt(rs.getInt("Mesto"));
        mesto = m;
        JMBG = rs.getLong("JMBG");
    }

    @Override
    public String vratiNazivPK() {
        return "KlijentID";
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new Klijent();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "ImePrezime like '"+imePrezime+"%'";
    }

    @Override
    public void setId(Object id) {
        this.id = (int) id;
    }
}
