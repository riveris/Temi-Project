package com.example.readdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class listview1 extends AppCompatActivity {
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


        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aw),
                "맥주", "100원") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.cz),
                "치킨", "100원") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dd),
                "와인", "100원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.eqd),
                "떡볶이", "100원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.tw),
                "소주", "100원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.vw),
                "피자", "100원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.wq),
                "족발", "100원") ;

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), listview1click.class);
                startActivity(intent);
            }
        });

    }

}
