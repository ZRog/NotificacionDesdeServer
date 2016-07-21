package com.proyecto.roger.mascotas.Notificaciones;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Roger on 20/07/2016.
 */
public class NotificacionIdTokenService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }

    private static final String TAG = "FIREBASE_TOKEN";
    private void enviarTokenRegistro(String token){
        Log.d(TAG,token);
    }
}
