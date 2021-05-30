package com.example.jerusalemapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jerusalemapp.R;
import com.example.jerusalemapp.adapter.ImageAdapter;
import com.example.jerusalemapp.model.Data;
import com.example.jerusalemapp.model.Image;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class AboutJerusalem extends AppCompatActivity {
    private DatabaseReference mDatabaseRef;
    Data data;
    TextView titel,text,titelone,textone,titlethree,titlemalamone,titlemalamtow,titlemalamthree,textmalmone,textmalmthree,textmalamtow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_jerusalem);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("about");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Data data = dataSnapshot.getValue(Data.class);
                titel =findViewById(R.id.titel);
                titel.setText(data.getTitel());

                text =findViewById(R.id.text);
                text.setText(data.getText());

                titelone =findViewById(R.id.titelone);
                titelone.setText(data.getTitelone());

                textone =findViewById(R.id.textone);
                textone.setText(data.getTextone());

                titlethree =findViewById(R.id.titlethree);
                titlethree.setText(data.getTitelthree());

                titlemalamone =findViewById(R.id.titelmalamone);
                titlemalamone.setText(data.getTitelmalamone());

                titlemalamtow =findViewById(R.id.titelmalamtow);
                titlemalamtow.setText(data.getTitelmalamtow());

                titlemalamthree =findViewById(R.id.titelmalamthree);
                titlemalamthree.setText(data.getTitelmalamthree());


                textmalmone =findViewById(R.id.textmalamone);
                textmalmone.setText(data.getTextmalamone());

                textmalamtow =findViewById(R.id.textmalamtow);
                textmalamtow.setText(data.getTextmalamtow());

                textmalmthree =findViewById(R.id.textmalamthree);
                textmalmthree.setText(data.getTextmalamthree());




            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    }
