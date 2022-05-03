package com.example.readdata;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;
import org.jetbrains.annotations.NotNull;
import java.lang.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.robotemi.sdk.*;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;
import org.jetbrains.annotations.NotNull;
import java.lang.*;
import androidx.annotation.StringDef;
import com.robotemi.sdk.listeners.*;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
public class guidefinish extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();
    Robot robot = Robot.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_finish);
        Button finish = (Button) findViewById(R.id.finishguidebtn);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robot.goTo("home");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}