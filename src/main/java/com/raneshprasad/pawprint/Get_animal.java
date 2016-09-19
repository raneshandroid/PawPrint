package com.raneshprasad.pawprint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Get_animal extends AppCompatActivity {
    EditText name;
    EditText ani_description;
    EditText address;
    Button post_btn;
    String name_str;
    String des_str;
    String add_str;
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_animal);
        name = (EditText) findViewById(R.id.editText_name);
        ani_description = (EditText) findViewById(R.id.editText_description);
        address = (EditText) findViewById(R.id.editText_address);
        post_btn = (Button) findViewById(R.id.button_post);
        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_str = name.getText().toString();
                des_str = ani_description.getText().toString();
                add_str = address.getText().toString();
                myRef.push().setValue(name_str);
                myRef.child(name_str).push().setValue(des_str);
                myRef.child(name_str).push().setValue(add_str);
                Toast.makeText(getApplicationContext(), "Your request has been posted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
