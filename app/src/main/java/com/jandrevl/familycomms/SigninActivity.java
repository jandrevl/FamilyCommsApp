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

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SigninActivity extends AppCompatActivity {

    EditText newUsernameEditText;
    EditText newPasswordEditText;
    EditText passwordConfirmEditText;
    TextView passwordRules;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        setTitle("Criar novo Utilizador");

        passwordRules = findViewById(R.id.passwordRulesTextView);
        passwordRules.setVisibility(View.INVISIBLE);
        newUsernameEditText = findViewById(R.id.newUserEditText);
        newPasswordEditText = findViewById(R.id.newPasswordEditText);
        passwordConfirmEditText = findViewById(R.id.newPasswordConfirmEditText);
        progressBar = findViewById(R.id.progressBar);



    }

    public void createUser(View view) {
        String newUsername = newUsernameEditText.getText().toString();
        String newPassword = newPasswordEditText.getText().toString();
        String passwordConfirm = passwordConfirmEditText.getText().toString();

        if(newUsername.length() < 4) {
            Toast.makeText(this, "Username tem de ter no mínimo 4 caracteres", Toast.LENGTH_LONG).show();
            return;
        }

        if(newPassword.length() < 6) {
            Toast.makeText(this, "PASSWORD tem de ter no MÍNIMO 6 CARACTERES", Toast.LENGTH_LONG).show();
            newPasswordEditText.setText("");
            return;
        }

        if(!newPassword.equals(passwordConfirm)) {
            Toast.makeText(this, "PASSWORDS NÃO CONDIZEM", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        ParseUser newUser = new ParseUser();
        newUser.setUsername(newUsername);
        newUser.setPassword(newPassword);
        newUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    Toast.makeText(SigninActivity.this, "Novo Utilizador CRIADO COM SUCESSO!!", Toast.LENGTH_LONG).show();
                    try {
                        ParseUser.logIn(newUsername, newPassword);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    progressBar.setVisibility(View.INVISIBLE);
                    Log.i("Logged User", ParseUser.getCurrentUser().getUsername());
                    Intent intent = new Intent(getApplicationContext(), UsersListActivity.class);
                    startActivity(intent);
//                    finish();

                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Log.i("New User not created", e.getMessage());
                    Toast.makeText(SigninActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });


        Log.i("Create New User", "Finished");
    }
}