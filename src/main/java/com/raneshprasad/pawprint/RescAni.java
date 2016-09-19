package com.raneshprasad.pawprint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class RescAni extends AppCompatActivity {
    ListView lv;

    String[] names = {"Ranesh Prasad", "Ranya Prasad"};
    int[] images = {R.drawable.trophy, R.drawable.phone};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resc_ani);

        lv = (ListView) findViewById(R.id.listView_custom);
        Adapter adapter = new Adapter(this, names, images);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), names[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
