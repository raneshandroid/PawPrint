package com.raneshprasad.pawprint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Give_animal extends AppCompatActivity {
    ListView l;
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    ArrayList<String> names = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_animal);
        l = (ListView) findViewById(R.id.listView);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count = 0;
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        count++;
                        Log.d("name", postSnapshot.getValue().toString());
                        if(count % 2 != 0) {
                            names.add(postSnapshot.getValue().toString());
                        }
                        Log.d("number", count + "");
                    }
                    Log.d("length", names.size() + "");
                Log.d("final", names.get(0));

                    addToList(names);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void addToList(ArrayList<String> a){
        ArrayAdapter<String> aAdap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, a);
        l.setAdapter(aAdap);

    }
}
