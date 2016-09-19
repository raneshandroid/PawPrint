package com.raneshprasad.pawprint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by anubhaprasad on 8/5/16.
 */
public class Adapter extends ArrayAdapter<String>{
    int[] imgs = {};
    String[] names = {};
    Context c;
    LayoutInflater inflater;
    public Adapter(Context context, String[] names, int[] imgs){
        super(context, R.layout.custom, names);
        this.c = context;
        this.names = names;

        this.imgs = imgs;
    }

    public class ViewHolder{
        TextView nameTV;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom, null);
        }
        final ViewHolder holder = new ViewHolder();
        holder.nameTV = (TextView) convertView.findViewById(R.id.textView_nameTV);
        holder.img = (ImageView) convertView.findViewById(R.id.imageView);
        holder.img.setImageResource(imgs[position]);
        holder.nameTV.setText(names[position]);
        return convertView;
    }
}
