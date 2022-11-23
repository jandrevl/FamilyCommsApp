package com.jandrevl.familycomms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.parse.ParseUser;

public class UsersListActivity extends AppCompatActivity {

    ParseUser currentUser;
    Intent intent;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
//            return;
            finishAffinity();

        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

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