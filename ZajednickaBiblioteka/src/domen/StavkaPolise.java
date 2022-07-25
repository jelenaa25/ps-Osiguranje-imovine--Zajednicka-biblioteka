/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Korisnik
 */
public class StavkaPolise implements Serializable, OpstiDomenskiObjekat{
    private Polisa polisa;
    private int rb;
    private PredmetOsiguranja predmetOsiguranja;
    private Pokrice pokrice;
    private BigDecimal sumaOsiguranja;
    private int procenatAmortizacije;
    private BigDecimal premija;

    public StavkaPolise() {
    }

    
    public StavkaPolise(Polisa polisa, int rb, PredmetOsiguranja predmetOsiguranja, Pokrice pokrice, BigDecimal sumaOsiguranja, int procenatAmortizacije, BigDecimal premija) {
        this.polisa = polisa;
        this.rb = rb;
        this.predmetOsiguranja = predmetOsiguranja;
        this.pokrice = pokrice;
        this.sumaOsiguranja = sumaOsiguranja;
        this.procenatAmortizacije = procenatAmortizacije;
        this.premija = premija;
    }

    public BigDecimal getPremija() {
        return premija;
    }

    public void setPremija(BigDecimal premija) {
        this.premija = premija;
    }

    public Polisa getPolisa() {
        return polisa;
    }

    public void setPolisa(Polisa polisa) {
        this.polisa = polisa;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public PredmetOsiguranja getPredmetOsiguranja() {
        return predmetOsiguranja;
    }

    public void setPredmetOsiguranja(PredmetOsiguranja predmetOsiguranja) {
        this.predmetOsiguranja = predmetOsiguranja;
    }

    public Pokrice getPokrice() {
        return pokrice;
    }

    public void setPokrice(Pokrice pokrice) {
        this.pokrice = pokrice;
    }

    public BigDecimal getSumaOsiguranja() {
        return sumaOsiguranja;
    }

    public void setSumaOsiguranja(BigDecimal sumaOsiguranja) {
        this.sumaOsiguranja = sumaOsiguranja;
    }

    public int getProcenatAmortizacije() {
        return procenatAmortizacije;
    }

    public void setProcenatAmortizacije(int procenatAmortizacije) {
        this.procenatAmortizacije = procenatAmortizacije;
    }

    @Override
    public String vratiVrAtributa() {
        return (polisa == null ? null : polisa.getPolisaID())+", "+rb+", "+predmetOsiguranja.getPredmetID()+", "+pokrice.getPokriceID()+", "+sumaOsiguranja+", "+procenatAmortizacije+", "+premija;
    }

    @Override
    public String postaviVrAtributa() {
        return "PolisaID = "+(polisa == null ? null : polisa.getPolisaID())+", "+"RB = "+rb+", PredmetID = "+predmetOsiguranja.getPredmetID()+", PokriceID = "+pokrice.getPokriceID()+", SumaOsiguranja = "+sumaOsiguranja+", ProcenatAmortizacije = "+procenatAmortizacije+", Premija = "+premija;
    }

    @Override
    public String vratiImeKlase() {
        return "stavkapolise";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "PolisaID = " + polisa.getPolisaID();
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
    //    polisa.setPolisaID(rs.getInt("PolisaID"));
        polisa = new Polisa(); polisa.setPolisaID(rs.getInt("PolisaID"));
        rb = rs.getInt("RB");
        PredmetOsiguranja pr = new PredmetOsiguranja(); pr.setPredmetID(rs.getInt("PredmetID"));
        predmetOsiguranja = pr;
        Pokrice pok = new Pokrice(); pok.setPokriceID(rs.getInt("PokriceID"));
        pokrice = pok;
        sumaOsiguranja = rs.getBigDecimal("SumaOsiguranja");
        procenatAmortizacije = rs.getInt("ProcenatAmortizacije");
        premija = rs.getBigDecimal("Premija");
    }

    @Override
    public String vratiNazivPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        StavkaPolise s = new StavkaPolise();
        s.setPokrice(pokrice);
        return s;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "PolisaID = "+polisa.getPolisaID();
    }

    @Override
    public OpstiDomenskiObjekat vratiSlabObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Object getID() {
        return polisa.getPolisaID();
    }
 
    @Override
    public void setId(Object id) {
        rb  = (int) id;
    }

    @Override
    public OpstiDomenskiObjekat vratiInstancuNadKlase() {
        return polisa;
    }
    
    
    
}
