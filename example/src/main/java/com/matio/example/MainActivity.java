package com.matio.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.listview)
    private ListView listView;

    private List<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x.view().inject(this);

        for (int i = 0; i < 20; i++) {
            list.add("" + i);
        }
        listView.setAdapter(new ExampleAdapter(this,list,R.layout.item_listview));


    }
}
