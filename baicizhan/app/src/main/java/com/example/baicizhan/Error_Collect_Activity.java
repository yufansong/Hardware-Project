package com.example.baicizhan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Error_Collect_Activity extends AppCompatActivity {
    private ListView mylistview;
    private ArrayAdapter<String> myAddapter;
    private String[] words = {"word1","word2","word3","word4","word5","word6"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error__collect_);

        mylistview = findViewById(R.id.mylistview);
        myAddapter = new ArrayAdapter<String>(Error_Collect_Activity.this,android.R.layout.simple_list_item_1,words);
        mylistview.setAdapter(myAddapter);
    }
}
