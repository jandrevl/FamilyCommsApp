package com.jandrevl.familycomms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        setTitle("Criar novo Utilizador");
    }
}