package com.raneshprasad.pawprint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindAni extends AppCompatActivity {
    Button get_ani_btn;
    Button give_ani_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_ani);
        get_ani_btn = (Button) findViewById(R.id.button_getani);
        give_ani_btn = (Button) findViewById(R.id.button_giveani);
        give_ani_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Get_animal.class);
                startActivity(i);
            }
        });

        get_ani_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Give_animal.class);
                startActivity(i);
            }
        });

    }
}
