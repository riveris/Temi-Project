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
public class guide extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();
    Robot robot = Robot.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guidelayout);

        Intent intent = getIntent();
        String room = intent.getStringExtra("방번호");

        TextView guideText = (TextView)findViewById(R.id.guidetext);
        guideText.setText( room + "호 안내를 요청하셨나요?.");
        Button yes = (Button) findViewById(R.id.btn_yes);
        Button no = (Button) findViewById(R.id.btn_no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robot.speak(TtsRequest.create("101호로 안내합니다",true));
                robot.goTo("101");
                Intent intent2 = new Intent(getApplicationContext(), guidefinish.class);
                startActivity(intent2);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}