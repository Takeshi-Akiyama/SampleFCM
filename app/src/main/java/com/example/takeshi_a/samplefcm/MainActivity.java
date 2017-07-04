package com.example.takeshi_a.samplefcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationData notificationData = new NotificationData();
        ArrayList<NotificationData> arraylist = new ArrayList<>();


        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                //Log.d(TAG, "Key: " + key + " Value: " + value);

                // 通知データクラスに一つずつ格納
                NotificationData vnotifications = new NotificationData();
                vnotifications.setKey(key);
                vnotifications.setValue(value.toString());

                // 一度にきた通知データをまとめる
                arraylist.add(vnotifications);
            }

            // 格納した通知データを確認する
            for(NotificationData n : arraylist){
                Log.d(TAG, "Key: " + n.getKey() + " Value:" + n.getValue());
            }

            // ListViewのインスタンスを生成
            ListView listview = (ListView)findViewById(R.id.listView);

            // BaseAdapter を継承したadapterのインスタンスを生成
            MyBaseAdapter mybaseadapter = new MyBaseAdapter(MainActivity.this);

            mybaseadapter.setNotificationDatas(arraylist);
            // ListViewにadapterをセット
            listview.setAdapter(mybaseadapter);

        }
    }

}
