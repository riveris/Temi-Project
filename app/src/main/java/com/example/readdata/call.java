package com.example.readdata;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;

public class call extends AppCompatActivity {

    Robot robot = Robot.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        robot.speak(TtsRequest.create("담당자에게 연결합니다.",true));
        robot.startTelepresence(robot.getAdminInfo().getName(), robot.getAdminInfo().getUserId());
    }

}
