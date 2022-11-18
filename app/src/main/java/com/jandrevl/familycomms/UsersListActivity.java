package com.jandrevl.familycomms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.parse.ParseUser;

public class UsersListActivity extends AppCompatActivity {

    ParseUser currentUser;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        intent = getIntent();


        currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            setTitle("Olá " + currentUser.getUsername());
        } else {
            // show the signup or login screen
            Toast.makeText(this, "Sem sessão iniciada", Toast.LENGTH_SHORT).show();
        }


    }
}