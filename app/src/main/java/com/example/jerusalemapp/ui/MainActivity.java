package com.example.jerusalemapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jerusalemapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.li_gallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Gallery.class));
            }
        });
        findViewById(R.id.li_vedio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Vedio.class));
            }
        });
        findViewById(R.id.about_jerusalem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AboutJerusalem.class));

            }
        });
        findViewById(R.id.chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                final EditText editText = new EditText(MainActivity.this);
                dialog.setTitle("Enter Your Name");
                dialog.setView(editText);
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editText.getText().toString();
                        if (!TextUtils.isEmpty(name)) {
                            Intent intent = new Intent(getApplicationContext(), ChatRoomActivity.class);
                            intent.putExtra("Name", name);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();

            }
        });
    }
}