package com.jandrevl.familycomms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser user = ParseUser.getCurrentUser();

        if (user != null) {
            Log.i("Current user is", user.getUsername());
            Intent intent = new Intent(this, UsersListActivity.class);
            startActivity(intent);
        } else {
            Log.i("User is", "null");
        }
    }

    public void signin(View view) {
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
    }
}