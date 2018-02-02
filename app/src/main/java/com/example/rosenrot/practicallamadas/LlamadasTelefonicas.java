package com.example.rosenrot.practicallamadas;

import java.util.Date;

/**
 * Created by Rosenrot on 01/02/2018.
 */

public class LlamadasTelefonicas {

    private String tipo, numero;
    private Date inicio, fin;

    public LlamadasTelefonicas(String tipo, String numero, Date inicio, Date fin) {
        this.tipo = tipo;
        this.numero = numero;
        this.inicio = inicio;
        this.fin = fin;
    }

}
