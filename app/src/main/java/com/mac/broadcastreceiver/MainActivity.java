package com.mac.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mac.broadcastreceiver.Constatnts.BroadcastConstants;
import com.mac.broadcastreceiver.broadcast.MyBroadcastReceiver;

public class MainActivity extends AppCompatActivity {

//    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();

    TextView messageTxt;

    private MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            if(BroadcastConstants.APP_BROADCAST_ACTION_SEND.equals(intent.getAction())){
                Toast.makeText(context, "Received in receiver App from sender app", Toast.LENGTH_SHORT).show();
                messageTxt.setText(intent.getStringExtra(BroadcastConstants.APP_BROADCAST_ACTION_EXTRANS_DATA));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageTxt = findViewById(R.id.messageTxt);

        IntentFilter intentFilter = new IntentFilter(BroadcastConstants.APP_BROADCAST_ACTION_SEND);
        registerReceiver(myBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }
}
