package com.jandrevl.familycomms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    TextView loggedinUserTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loggedinUserTextView = findViewById(R.id.loggedinUserTextView);

        // Delete this line before production
//        ParseUser.logOut();

        ParseUser user = ParseUser.getCurrentUser();

        if (user != null) {
            Log.i("Current user is", user.getUsername());
            loggedinUserTextView.setText("Utilizador ativo: " + user.getUsername());
            Intent intent = new Intent(this, UsersListActivity.class);
            startActivity(intent);
        } else {
            Log.i("User is", "null");
            loggedinUserTextView.setText("Nenhum utilizador ativo");
        }
    }


    public void signin(View view) {
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
    }

    public void login(View view) {

        ProgressBar loginProgressBar = findViewById(R.id.loginProgressBar);
        loginProgressBar.setVisibility(View.VISIBLE);

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e == null) {
                    Intent intent = new Intent(getApplicationContext(), UsersListActivity.class);
                    loginProgressBar.setVisibility(View.INVISIBLE);
                    startActivity(intent);
//                    finish();
                } else {
                    loginProgressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}