package com.example.takeshi_a.samplefcm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by takeshi-a on 2017/07/04.
 */

public class MyBaseAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<NotificationData> notificationDatas;

    public MyBaseAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setNotificationDatas(ArrayList<NotificationData> notificationDatas) {
        this.notificationDatas = notificationDatas;
    }

    @Override
    public int getCount() {
        //return notificationDatas.size();
        return (notificationDatas == null) ? 0 : notificationDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return notificationDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.notificationdatarow,parent,false);

        ((TextView)convertView.findViewById(R.id.key)).setText(notificationDatas.get(position).getKey());
        ((TextView)convertView.findViewById(R.id.value)).setText(String.valueOf(notificationDatas.get(position).getValue()));

        return convertView;
    }
}