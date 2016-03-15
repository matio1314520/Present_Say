package com.angel.present_say.receiver;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.List;

/**
 * Created by Angel on 2016/2/19.
 */
public class BluetoothReceiver extends BroadcastReceiver {

    private List<BluetoothDevice> devices;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals(BluetoothDevice.ACTION_FOUND)){
            BluetoothDevice device = intent.getParcelableExtra("device");

        }
    }
}
