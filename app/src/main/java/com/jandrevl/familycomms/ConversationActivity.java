package com.jandrevl.familycomms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversationActivity extends AppCompatActivity {

    List<Message> messages = new ArrayList<>();
    String user;
    String receiverUser;
    String messageId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        if(ParseUser.getCurrentUser() == null) {
            finish();
        }

        user = ParseUser.getCurrentUser().getUsername();
        Intent intent = getIntent();
        receiverUser = intent.getStringExtra("receiverUser");
        setTitle("Conversa com " + receiverUser);
        messageId = createMessageId(user, receiverUser);


    }

    private String createMessageId(String user, String receiverUser) {
        String[] messageIdArray = new String[]{user, receiverUser};
        Arrays.sort(messageIdArray);
        String messageId = messageIdArray[0] + "+" + messageIdArray[1];
        return messageId;
    }


}