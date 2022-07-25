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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Polisa implements Serializable, OpstiDomenskiObjekat {

    private int polisaID;
    private Klijent klijent;
    private BigDecimal povrsinaStana;
    private BigDecimal vrednostPoKvM;
    private BigDecimal gradjevinskaVrednost;
    private BigDecimal ukupnaPremija;
    private Date datumOD;
    private Date datumDO;
    private AgentOsiguranja agentOsiguranja;
    private List<StavkaPolise> stavkePolise;

    public Polisa() {
        stavkePolise = new ArrayList<>();
    }

    public Polisa(int polisaID, Klijent klijent, BigDecimal povrsinaStana, BigDecimal vrednostPoKvM, BigDecimal gradjevinskaVrednost, BigDecimal ukupnaPremija, Date datumOD, Date datumDO, AgentOsiguranja agentOsiguranja, List<StavkaPolise> lista) {

        stavkePolise = lista;
        this.polisaID = polisaID;
        this.klijent = klijent;
        this.povrsinaStana = povrsinaStana;
        this.vrednostPoKvM = vrednostPoKvM;
        this.gradjevinskaVrednost = gradjevinskaVrednost;
        this.ukupnaPremija = ukupnaPremija;
        this.datumOD = datumOD;
        this.datumDO = datumDO;
        this.agentOsiguranja = agentOsiguranja;
    }

    public AgentOsiguranja getAgentOsiguranja() {
        return agentOsiguranja;
    }

    public void setAgentOsiguranja(AgentOsiguranja agentOsiguranja) {
        this.agentOsiguranja = agentOsiguranja;
    }

    public int getPolisaID() {
        return polisaID;
    }

    public void setPolisaID(int polisaID) {
        this.polisaID = polisaID;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public BigDecimal getPovrsinaStana() {
        return povrsinaStana;
    }

    public void setPovrsinaStana(BigDecimal povrsinaStana) {
        this.povrsinaStana = povrsinaStana;
    }

    public BigDecimal getVrednostPoKvM() {
        return vrednostPoKvM;
    }

    public void setVrednostPoKvM(BigDecimal vrednostPoKvM) {
        this.vrednostPoKvM = vrednostPoKvM;
    }

    public BigDecimal getGradjevinskaVrednost() {
        return gradjevinskaVrednost;
    }

    public void setGradjevinskaVrednost(BigDecimal gradjevinskaVrednost) {
        this.gradjevinskaVrednost = gradjevinskaVrednost;
    }

    public BigDecimal getUkupnaPremija() {
        return ukupnaPremija;
    }

    public void setUkupnaPremija(BigDecimal ukupnaPremija) {
        this.ukupnaPremija = ukupnaPremija;
    }

    public Date getDatumOD() {
        return datumOD;
    }

    public void setDatumOD(Date datumOD) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = datumOD;
        datumOD = java.sql.Date.valueOf(sm.format(dDatum));
        this.datumOD = datumOD;
    }

    public Date getDatumDO() {
        return datumDO;
    }

    public void setDatumDO(Date datumDO) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = datumDO;
        datumDO = java.sql.Date.valueOf(sm.format(dDatum));
        this.datumDO = datumDO;
    }

    public List<StavkaPolise> getStavkePolise() {
        return stavkePolise;
    }

    public void setStavkePolise(List<StavkaPolise> stavkePolise) {
        this.stavkePolise = stavkePolise;
    }

    @Override
    public String vratiVrAtributa() {
        return polisaID + ", " +klijent.getId() + ", " + povrsinaStana + ", " + vrednostPoKvM + ", " + gradjevinskaVrednost + ", " + ukupnaPremija + ", '" + datumOD + "', '" + datumDO + "', " + agentOsiguranja.getAgentID();
    }

    @Override
    public String postaviVrAtributa() {
        return "KlijentID = " + klijent.getId()  + ", PovrsinaStana = " + povrsinaStana + ", VrednostPoKvM = " + vrednostPoKvM + ", GradjevinskaVrednost = " + gradjevinskaVrednost + ", UkupnaPremija = " + ukupnaPremija + ", DatumOd = '" + datumOD + "', DatumDo = '" + datumDO + "', AgentID = " + agentOsiguranja.getAgentID();
    }

    @Override
    public String vratiImeKlase() {
        return "polisa";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "PolisaID = " + polisaID;
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
        polisaID = rs.getInt("PolisaID");
        //klijent = rs.getString("Klijent");
        Klijent k = new Klijent(); k.setId(rs.getInt("KlijentID"));
        klijent = k;
        povrsinaStana = rs.getBigDecimal("PovrsinaStana");
        vrednostPoKvM = rs.getBigDecimal("VrednostPoKvM");
        gradjevinskaVrednost = rs.getBigDecimal("GradjevinskaVrednost");
        ukupnaPremija = rs.getBigDecimal("UkupnaPremija");
        
        datumDO = new Date(rs.getDate("DatumDo").getTime());
        datumOD = new Date(rs.getDate("DatumOd").getTime());
        agentOsiguranja = new AgentOsiguranja();
        agentOsiguranja.setAgentID(rs.getInt("AgentID"));
    }

    @Override
    public String vratiNazivPK() {
        return "PolisaID";
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new Polisa();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        //return "Klijent like '" + klijent + "%'";
        return "KlijentID = "+klijent.getId();
    }

    @Override
    public OpstiDomenskiObjekat vratiSlabObjekat() {
        StavkaPolise stavkaPolise = new StavkaPolise();
        stavkaPolise.setPolisa(this);
        return stavkaPolise;
    }

    @Override
    public List<OpstiDomenskiObjekat> slabiObjekti() {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        for (StavkaPolise s : stavkePolise) {
            OpstiDomenskiObjekat o = s;
            lista.add(o);
        }
        return lista;
    }

    @Override
    public void setId(Object id) {
        polisaID = (int) id;
    }

    @Override
    public String toString() {
        return polisaID + " " + klijent.getImePrezime() + " " + povrsinaStana + " " + vrednostPoKvM + " " + gradjevinskaVrednost + " " + ukupnaPremija + " " + datumDO + " " + datumOD + " ";
    }

    @Override
    public void postaviSlabeObjekte(List<OpstiDomenskiObjekat> slabi) {
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : slabi) {
            stavkePolise.add((StavkaPolise) opstiDomenskiObjekat);
        }
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancuSlabogObjekta() {

        StavkaPolise s = new StavkaPolise();
        s.setPolisa(this);
        return s;
    }

    @Override
    public Object getID() {
        return polisaID;
    }

}
