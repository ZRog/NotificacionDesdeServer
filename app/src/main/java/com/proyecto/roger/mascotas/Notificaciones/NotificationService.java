package com.proyecto.roger.mascotas.Notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.proyecto.roger.mascotas.MainActivity;
import com.proyecto.roger.mascotas.R;

/**
 * Created by Roger on 19/07/2016.
 */
public class NotificationService extends FirebaseMessagingService {

    public static final String TAG = "FIREBASE";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"From: " + remoteMessage.getFrom());
        Log.d(TAG,"Notification Message Body: " + remoteMessage.getNotification().getBody());

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_ONE_SHOT);
        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_casa)
                .setContentTitle("Notificacion")
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificacion.build());
    }
}
