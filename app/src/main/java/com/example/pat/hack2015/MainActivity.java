package com.example.pat.hack2015;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void joinChat(View view){
        String username;
        EditText editText = (EditText)findViewById(R.id.editText);
        username = editText.getText().toString();
        startActivity(new Intent(this, ChatActivity.class));


    }

}
