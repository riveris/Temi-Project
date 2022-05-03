package com.example.readdata;

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

public class MainActivity extends AppCompatActivity implements OnGoToLocationStatusChangedListener{
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();
    Robot robot = Robot.getInstance();
    int flag = 1;
    @Override
    public void onStart() {
        super.onStart();
        robot.addOnGoToLocationStatusChangedListener(this);
    }
    @Override
    public void onStop() {
        super.onStop();
        robot.addOnGoToLocationStatusChangedListener(this);
    }
    @Override
    public void onGoToLocationStatusChanged(@NotNull String location, String status, int descriptionID, @NotNull String description) {
        switch (status) {
            case OnGoToLocationStatusChangedListener.START:
                robot.speak(TtsRequest.create(location +"으로 이동합니다", false));
                break;

            case OnGoToLocationStatusChangedListener.COMPLETE:
                robot.speak(TtsRequest.create(location + "도착했습니다", false));
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView distanceText = (TextView)findViewById(R.id.textDistance);
        firebaseDatabase.getReference("apin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object myText = snapshot.getValue();
                if(myText.toString()=="4") {
                    distanceText.setText("101호 안내 요청입니다.");
                    robot.speak(TtsRequest.create("101호 안내 요청입니다",true));
                    robot.goTo("elevator"); //원래는 엘리베이터
                    Intent intent = new Intent(getApplicationContext(), guide.class);
                    intent.putExtra("방번호", "101");
                    startActivity(intent);

                }
                else if(myText.toString()=="1") {
                    distanceText.setText(myText.toString()+"번 방 호출입니다.");
                    robot.speak(TtsRequest.create("1번방 호출입니다",true));
                    robot.goTo("101");
                    Intent intent = new Intent(getApplicationContext(), menu.class);
                    startActivity(intent);
                }
                /*
                else if(myText.toString()=="2") {
                    distanceText.setText(myText.toString()+"번 방 호출입니다.");
                    robot.speak(TtsRequest.create("2번방 호출입니다",true));
                    Intent intent = new Intent(getApplicationContext(),menu.class);
                    startActivity(intent);
                    robot.goTo("home base");
                    onGoToLocationStatusChanged("home base","completed",1,"");
                }
                 */
                Log.d("tag", "room number is " + myText);
                databaseReference.child("apin").setValue(0);
                //distanceText.setText("hello");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("tag", "Failed to read value.", error.toException());
            }
        });

//엘베 앞으로 감, 요청했니? 기다림, 사람이 오면 요청ㅇ버튼 클릭, goTo, 도착완료, 버튼, 홈베이스
    }


}
