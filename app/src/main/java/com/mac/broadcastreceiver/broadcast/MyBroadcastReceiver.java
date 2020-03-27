package com.mac.broadcastreceiver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.mac.broadcastreceiver.Constatnts.BroadcastConstants;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(BroadcastConstants.APP_BROADCAST_ACTION_SEND.equals(intent.getAction())){
            Toast.makeText(context, "Received in receiver App from sender app", Toast.LENGTH_SHORT).show();
        }
    }
}
