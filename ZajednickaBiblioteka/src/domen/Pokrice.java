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
public class Pokrice implements Serializable, OpstiDomenskiObjekat{
    private int pokriceID;
    private String naziv;
    private String napomena;
    public Pokrice() {
    }

    public Pokrice(int pokriceID, String naziv, String napomena) {
        this.pokriceID = pokriceID;
        this.naziv = naziv;
        this.napomena = napomena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNapomena() {
        return napomena;
    }

    public int getPokriceID() {
        return pokriceID;
    }

    public void setPokriceID(int pokriceID) {
        this.pokriceID = pokriceID;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiVrAtributa() {
        return pokriceID+", '"+naziv+"', '"+napomena+"'";
    }

    @Override
    public String postaviVrAtributa() {
        return "PokriceID = "+pokriceID+", Naziv = '"+naziv+"', Napomena = '"+napomena+"'";
    }

    @Override
    public String vratiImeKlase() {
        return "pokrice";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "PokriceID = "+pokriceID;
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
        pokriceID = rs.getInt("PokriceID");
        naziv = rs.getString("Naziv");
        napomena = rs.getString("Napomena");
    }

    @Override
    public String vratiNazivPK() {
        return "PokriceID";
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new Pokrice();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "Naziv like '"+naziv+"%'"; //promeni!!!!!!!!
    }

    @Override
    public void setId(Object id) {
        pokriceID = (int) id;
    }
    
}
