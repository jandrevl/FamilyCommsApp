package com.jandrevl.familycomms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser user = ParseUser.getCurrentUser();
        if (user != null) {
            Intent intent = new Intent(this, UsersListActivity.class);
            startActivity(intent);
        }
    }

    public void signin(View view) {
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
    }
}