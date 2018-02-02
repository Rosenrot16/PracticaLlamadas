package com.example.rosenrot.practicallamadas;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rosenrot on 01/02/2018.
 */

public class ServicioRegistroLlamadasTelefonicas extends Service {

    public ServicioRegistroLlamadasTelefonicas() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String tipo = intent.getStringExtra("tipo");
        String numero = intent.getStringExtra("numero");

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));

        Date inicio = new Date();
        inicio.setTime(intent.getLongExtra("inicio", 0));
        Date fin = new Date();
        fin.setTime(intent.getLongExtra("fin", 0));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://practicallamadas-rosenrot17.c9users.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServicioRegistroLlamadasTelefonicasEnlinea servicioEnlinea = retrofit.create(ServicioRegistroLlamadasTelefonicasEnlinea.class);

        Call<Void> llamada = servicioEnlinea.add(new LlamadasTelefonicas(tipo, numero, inicio, fin));

        llamada.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.v("xyz", "Llamada telefónica añadida al registro");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v("xyz", "Error al añadir la llamada telefónica al registro");
            }
        });

        return START_REDELIVER_INTENT;
    }

}
