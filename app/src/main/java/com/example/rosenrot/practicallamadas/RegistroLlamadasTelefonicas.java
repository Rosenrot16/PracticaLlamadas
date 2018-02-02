package com.example.rosenrot.practicallamadas;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

/**
 * Created by Rosenrot on 01/02/2018.
 */

public class RegistroLlamadasTelefonicas extends ReceptorLlamadasTelefonicas {

    @Override
    protected void onIncomingCallStarted(Context context, String numero, Date inicio) {
    }

    @Override
    protected void onOutgoingCallStarted(Context context, String numero, Date inicio) {
    }

    @Override
    protected void onIncomingCallEnded(Context context, String numero, Date inicio, Date fin) {
        Log.v("xyz", "Llamada entrante " + numero + " " + inicio.toString() + " - " + fin.toString());

        Intent intent = new Intent(context, ServicioRegistroLlamadasTelefonicas.class);
        intent.putExtra("tipo", "entrante");
        intent.putExtra("numero", numero);
        intent.putExtra("inicio", inicio.getTime());
        intent.putExtra("fin", fin.getTime());

        context.startService(intent);
    }

    @Override
    protected void onOutgoingCallEnded(Context context, String numero, Date inicio, Date fin) {
        Log.v("xyz", "Llamada saliente " + numero + " " + inicio.toString() + " - " + fin.toString());

        Intent intent = new Intent(context, ServicioRegistroLlamadasTelefonicas.class);
        intent.putExtra("tipo", "saliente");
        intent.putExtra("numero", numero);
        intent.putExtra("inicio", inicio.getTime());
        intent.putExtra("fin", fin.getTime());

        context.startService(intent);
    }

    @Override
    protected void onMissedCall(Context context, String numero, Date inicio) {
        Log.v("xyz", "Llamada perdida " + numero + " " + inicio.toString());

        Intent intent = new Intent(context, ServicioRegistroLlamadasTelefonicas.class);
        intent.putExtra("tipo", "perdida");
        intent.putExtra("numero", numero);
        intent.putExtra("inicio", inicio.getTime());
        intent.putExtra("fin", inicio.getTime());

        context.startService(intent);
    }
}
