package cn.zgy.commonutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vise.log.ViseLog;

import cn.zgy.utils.assist.Network;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("TGA", Network.isConnected(this) + "");
    }
}
