package com.example.readdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.*;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;
import org.jetbrains.annotations.NotNull;
import java.lang.*;
import androidx.annotation.StringDef;
import com.robotemi.sdk.listeners.*;
public class yes extends AppCompatActivity {
    Robot robot = Robot.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yes);

        setTitle("주문");
        Button yes2 = (Button) findViewById(R.id.yes2);
        Button yes3 = (Button) findViewById(R.id.yes3);
        yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), listview1.class);
                startActivity(intent);

            }
        });
        yes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                robot.goTo("home");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
