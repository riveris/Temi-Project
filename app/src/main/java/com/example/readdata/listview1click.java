package com.example.readdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class listview1click extends AppCompatActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview1click);

        setTitle("주문");
        Button yes1 = (Button) findViewById(R.id.yes1);
        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), yes.class);
                startActivity(intent);
            }
        });

        Button no1 = (Button) findViewById(R.id.no1);
        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), listview1.class);
                startActivity(intent);

            }
        });
    }
}
