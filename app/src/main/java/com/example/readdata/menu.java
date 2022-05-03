package com.example.readdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        setTitle("무엇을 도와드릴까요?");
        Button menu1 = (Button) findViewById(R.id.button1);
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), listview1.class);
                startActivity(intent);
            }
        });

        Button menu2 = (Button) findViewById(R.id.button2);
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), listview2.class);
                startActivity(intent);
            }
        });

        Button Call = (Button)findViewById(R.id.button3);
        Call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                
                Intent intent = new Intent(getApplicationContext(), call.class);
                startActivity(intent);
            }
        });

    }

    public void menu2(View view) {
    }

    public void menu1(View view) {
    }

    public void call(View view) {
    }
}