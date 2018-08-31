package com.sorcererxw.intentinterceptor.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.sorcererxw.intentinterceptor.utils.DataUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

public class IntentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String str = intent.getStringExtra("info");
            if (TextUtils.isEmpty(str)) {
                Log.e("日志", "onReceive-空");
                return;
            } else {
                Log.e("日志", "onReceive" + "-" + str);
            }
            DataUtil.write(str);
        } catch (FileNotFoundException e) {
            Log.e("日志write", e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("日志write", e.getMessage());
            e.printStackTrace();
        }
    }
}
