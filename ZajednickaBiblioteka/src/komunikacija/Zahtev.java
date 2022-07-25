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
public class Zahtev implements Serializable{
    private int operacija;
    private Object argument;

    public Zahtev(int operacija, Object argument) {
        this.operacija = operacija;
        this.argument = argument;
    }

    public Object getArgument() {
        return argument;
    }

    public int getOperacija() {
        return operacija;
    }
}
