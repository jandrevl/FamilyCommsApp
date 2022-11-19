package com.jandrevl.familycomms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SigninActivity extends AppCompatActivity {

    EditText newUsernameEditText;
    EditText newPasswordEditText;
    EditText passwordConfirmEditText;
    TextView passwordRules;

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



    }

    public void createUser(View view) {
        Log.i("Create User Button", "Clicked");
        String newUsername = newUsernameEditText.getText().toString();
        String newPassword = newPasswordEditText.getText().toString();
        String passwordConfirm = passwordConfirmEditText.getText().toString();


    }
}