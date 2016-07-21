package com.proyecto.roger.mascotas.ResApi.Model;

import com.proyecto.roger.mascotas.ResApi.ConstantesRestApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Roger on 20/07/2016.
 */
public interface EndPoints {

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenId(@Field("token") String token, @Field("idusuario") String usuario);

}
