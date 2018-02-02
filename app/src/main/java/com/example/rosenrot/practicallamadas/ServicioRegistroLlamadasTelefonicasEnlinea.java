package com.example.rosenrot.practicallamadas;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Rosenrot on 01/02/2018.
 */

public interface ServicioRegistroLlamadasTelefonicasEnlinea {

    @POST("llamadaTelefonica")
    Call<Void> add(@Body LlamadasTelefonicas llamadasTelefonicas);
}
