/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class AgentOsiguranja implements Serializable, OpstiDomenskiObjekat {

    private int agentID;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private String strucnaSprema;

    public AgentOsiguranja(int agentID, String ime, String prezime, String username, String password, String strucnaSprema) {
        this.agentID = agentID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.strucnaSprema = strucnaSprema;
    }

    public AgentOsiguranja() {
    }

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(String strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String vratiVrAtributa() {
        return agentID + ", '" + ime + "', '" + prezime + "', '" + username+"', '"+password+"', '"+strucnaSprema+"'";
    }

    @Override
    public String postaviVrAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "agentosiguranja";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "Username like '"+username+"' and Password like '"+password+"'";
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
        agentID = rs.getInt("AgentID");
        ime = rs.getString("Ime");
        prezime = rs.getString("Prezime");
        password = rs.getString("Password");
        username = rs.getString("Username");
        strucnaSprema = rs.getString("StrucnaSprema");
    }

    @Override
    public String vratiNazivPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new AgentOsiguranja();
        
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
