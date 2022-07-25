/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class Odgovor implements Serializable{
    private TipOdgovora tipOdgovora;
    private Object rezultat;
    private Exception exception;
    
    public Odgovor() {
    }

    public TipOdgovora getTipOdgovora() {
        return tipOdgovora;
    }

    public void setTipOdgovora(TipOdgovora tipOdgovora) {
        this.tipOdgovora = tipOdgovora;
    }

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rez) {
        this.rezultat = rez;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
    
}
