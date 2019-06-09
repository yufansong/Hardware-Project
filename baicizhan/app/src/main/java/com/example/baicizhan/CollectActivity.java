package com.example.baicizhan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.database.Cursor;
import android.widget.ListView;

public class CollectActivity extends AppCompatActivity {
    private Cursor c_db;
    private DBHelper dbHelper=new DBHelper(this);
    private ListView mylistview;
    private ArrayAdapter<String> myAddapter;
    int WordNum=0;
    private String[] words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);

        c_db=dbHelper.query("word");
        c_db.moveToFirst();
        while(!c_db.isAfterLast())
        {
            int note_index=c_db.getColumnIndex("ifnote");
            int ifnote=c_db.getInt(note_index);
            if(ifnote==1)
                WordNum++;
            c_db.moveToNext();
        }
        words=new String[WordNum];
        int i=0;
        c_db.moveToFirst();
        while(!c_db.isAfterLast())
        {
            int wrong_index=c_db.getColumnIndex("ifnote");
            int ifnote=c_db.getInt(wrong_index);
            if(ifnote==1)
            {
                int word_index=c_db.getColumnIndex("name");
                int mean_index=c_db.getColumnIndex("meaning");
                String name=String.format("%-20s",c_db.getString(word_index));
                String mean=c_db.getString(mean_index);
                String output=name+mean;
                words[i]=output;
                i++;
            }
            c_db.moveToNext();
        }

        mylistview = findViewById(R.id.mylistview);
        myAddapter = new ArrayAdapter<String>(CollectActivity.this,android.R.layout.simple_list_item_1,words);
        mylistview.setAdapter(myAddapter);
    }
}
