package com.jandrevl.familycomms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class UsersListActivity extends AppCompatActivity implements RecycleViewAdapter.OnItemClickListener {

    ParseUser currentUser;
    Intent intent;
    boolean doubleBackToExitPressedOnce = false;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<FamCommUser> famCommUserList = new ArrayList<>();

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

        populateFamCommUserList();
        Log.i("famCommUserList", famCommUserList.toString());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecycleViewAdapter(famCommUserList, this, this);
        recyclerView.setAdapter(mAdapter);




    }

    private void populateFamCommUserList() {
        famCommUserList.clear();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
        query.whereNotEqualTo("username", currentUser.getUsername());
        List<ParseObject> queryUsersList = new ArrayList<>();
        try {
            queryUsersList = query.find();
        } catch (ParseException e) {
            Log.i("Result of parseQuery", e.getMessage());
        }
        for(ParseObject parseUser : queryUsersList) {
            FamCommUser famCommUser = new FamCommUser(parseUser.getString("username"));
            famCommUserList.add(famCommUser);
        }
    }

    public void changeUser(View view) {
        ParseUser.logOut();
        Intent i=new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }


    @Override
    public void onItemClick(int position) {
        // Here is where I'll be writing the code to follow to the conversation Activity
        Log.i("User clicked", famCommUserList.get(position).getUsername());

    }
}