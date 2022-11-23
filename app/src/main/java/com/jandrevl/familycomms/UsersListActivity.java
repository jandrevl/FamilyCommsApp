package com.jandrevl.familycomms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class UsersListActivity extends AppCompatActivity {

    ParseUser currentUser;
    Intent intent;
    boolean doubleBackToExitPressedOnce = false;
    ArrayList<String> usersList;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
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

        usersList = new ArrayList<String>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
        query.whereNotEqualTo("username", currentUser.getUsername());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseUsers, ParseException e) {
                if(e == null) {
                    for(ParseObject parseUser : parseUsers) {
                        Log.i("User", parseUser.getString("username"));
                        usersList.add(parseUser.getString("username"));
                    }
                    Log.i("Users List", usersList.toString());
                } else {
                    e.printStackTrace();
                }
            }
        });



    }

    public void changeUser(View view) {
        ParseUser.logOut();
        Intent i=new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }


}