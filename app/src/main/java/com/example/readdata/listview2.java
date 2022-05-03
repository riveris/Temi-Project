package com.example.readdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class listview2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview1);

        setTitle("메뉴");
        ListView listview ;
        listview1adapter adapter;



        // Adapter 생성
        adapter = new listview1adapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), listview1click.class);
                startActivity(intent);
            }
        });

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.tr),
                "수건", "0원") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dgdv),
                "일회용품", "0원") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.tt),
                "생수", "0원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dft),
                "음료수", "0원") ;





    }

}