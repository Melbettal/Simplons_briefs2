package com.mobile.basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class InfoActivity extends AppCompatActivity {

    public EditText txtNom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        TextView getNom=(TextView) findViewById(R.id.getNom);
        TextView getEmail=(TextView) findViewById(R.id.getEmail);
        TextView getTel=(TextView) findViewById(R.id.getTel);
        getNom.setText("Nom et prenom : "+getIntent().getExtras().getString("txtNom"));
        getEmail.setText("Email : "+getIntent().getExtras().getString("txtEmail"));
        getTel.setText("Tel : "+getIntent().getExtras().getString("txtTel"));

    }
}