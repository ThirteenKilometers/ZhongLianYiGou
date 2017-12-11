package com.lzhs.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_TOP = 1;
    private static final int TYPE_TITLE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new FruitAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int postion) {
                if (postion== FruitAdapter.TYPE_01) {
                    Toast.makeText(MainActivity.this, "点击了类型1" , Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "点击了类型2" , Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initFruit() {
        for (int i = 0; i < 10; i++) {
            Fruit fruit;
            if (i == 5) {
                fruit = new Fruit("苹果" + i, R.drawable.ic_launcher_background, 2);

            } else
                fruit = new Fruit("苹果" + i, R.drawable.ic_launcher_background, 0);
            fruitList.add(fruit);
        }
    }
}
