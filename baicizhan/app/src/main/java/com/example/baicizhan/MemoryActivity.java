package com.example.baicizhan;

import android.database.CursorIndexOutOfBoundsException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.database.Cursor;
import android.content.ContentValues;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MemoryActivity extends AppCompatActivity {

    private Cursor c_db;
    private DBHelper dbHelper=new DBHelper(this);
//    private TextView TxtvWord=(TextView)findViewById(R.id.tv_mem_word);
//    private TextView TxtvClct=(TextView)findViewById(R.id.tv_mem_collect);
//    private Button BtnMenWd1=(Button)findViewById(R.id.btn_mem_word1);
//    private Button BtnMenWd2=(Button)findViewById(R.id.btn_mem_word2);
//    private Button BtnMenWd3=(Button)findViewById(R.id.btn_mem_word3);
//    private Button BtnMenWd4=(Button)findViewById(R.id.btn_mem_word4);
    private TextView TxtvWord;
    private TextView TxtvClct;
    private Button BtnMenWd1;
    private Button BtnMenWd2;
    private Button BtnMenWd3;
    private Button BtnMenWd4;
    private Button BtnNext;
    private Spinner Spn_book;
    private String TrueMean="ERROR";
    private Button TrueBtn;
    private String wordnow;

    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        c_db=dbHelper.query("word");
        c_db.moveToFirst();
        SetInterface(c_db);

        spinner1 = (Spinner) findViewById(R.id.spi_choose);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MemoryActivity.this, android.R.layout.simple_spinner_item,getData()
                );
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MemoryActivity.this,
                        String.valueOf( parent.getItemIdAtPosition(position)),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private List<String> getData(){
        List<String> dataList = new ArrayList<String>();
        dataList.add("四级单词");
        dataList.add("六级单词");
        return dataList;
    }
    //选择单词1
    public void btn_mem_select_onclick1(View view) {
        BtnMenWd1=(Button)findViewById(R.id.btn_mem_word1);
        if(BtnMenWd1.getText().toString().equals(TrueMean))
        {//Right
            BtnMenWd1.setBackgroundColor(Color.parseColor("#00F260"));
        }
        else
        {//Wrong
            BtnMenWd1.setBackgroundColor(Color.parseColor("#b20a2c"));
            TrueBtn.setBackgroundColor(Color.parseColor("#00F260"));

            Cursor c=SearchWordFromWord(wordnow,c_db,0);
            int id_index=c.getColumnIndex("id");
            int word_index=c.getColumnIndex("name");
            int mean_index=c.getColumnIndex("meaning");
            int book_index=c.getColumnIndex("book");
            int ifwrong_index=c.getColumnIndex("ifwrong");
            int ifnote_index=c.getColumnIndex("ifnote");

            int id=c.getInt(id_index);
            String WordName=c.getString(word_index);
            String WordMean=c.getString(mean_index);
            String book=c.getString(book_index);
            int ifnote=c.getInt(ifnote_index);
            ContentValues values = new ContentValues();
            values.put("name", WordName);
            values.put("meaning", WordMean);
            values.put("book", book);
            values.put("ifwrong", 1);
            values.put("ifnote", ifnote);
            dbHelper.update(values,"id=?",new String[]{String.valueOf(id)},"word");
        }
    }

    //选择单词2
    public void btn_mem_select_onclick2(View view) {
        BtnMenWd2=(Button)findViewById(R.id.btn_mem_word2);
        if(BtnMenWd2.getText().toString().equals(TrueMean))
        {//Right
            BtnMenWd2.setBackgroundColor(Color.parseColor("#00F260"));
        }
        else {//Wrong
            BtnMenWd2.setBackgroundColor(Color.parseColor("#b20a2c"));
            TrueBtn.setBackgroundColor(Color.parseColor("#00F260"));

            Cursor c=SearchWordFromWord(wordnow,c_db,0);
            int id_index=c.getColumnIndex("id");
            int word_index=c.getColumnIndex("name");
            int mean_index=c.getColumnIndex("meaning");
            int book_index=c.getColumnIndex("book");
            int ifwrong_index=c.getColumnIndex("ifwrong");
            int ifnote_index=c.getColumnIndex("ifnote");

            int id=c.getInt(id_index);
            String WordName=c.getString(word_index);
            String WordMean=c.getString(mean_index);
            String book=c.getString(book_index);
            int ifnote=c.getInt(ifnote_index);
            ContentValues values = new ContentValues();
            values.put("name", WordName);
            values.put("meaning", WordMean);
            values.put("book", book);
            values.put("ifwrong", 1);
            values.put("ifnote", ifnote);
            dbHelper.update(values,"id=?",new String[]{String.valueOf(id)},"word");
        }
    }

    //选择单词3
    public void btn_mem_select_onclick3(View view) {
        BtnMenWd3=(Button)findViewById(R.id.btn_mem_word3);
        if(BtnMenWd3.getText().toString().equals(TrueMean))
        {//Right
            BtnMenWd3.setBackgroundColor(Color.parseColor("#00F260"));
        }
        else {//Wrong
            BtnMenWd3.setBackgroundColor(Color.parseColor("#b20a2c"));
            TrueBtn.setBackgroundColor(Color.parseColor("#00F260"));

            Cursor c=SearchWordFromWord(wordnow,c_db,0);
            int id_index=c.getColumnIndex("id");
            int word_index=c.getColumnIndex("name");
            int mean_index=c.getColumnIndex("meaning");
            int book_index=c.getColumnIndex("book");
            int ifwrong_index=c.getColumnIndex("ifwrong");
            int ifnote_index=c.getColumnIndex("ifnote");

            int id=c.getInt(id_index);
            String WordName=c.getString(word_index);
            String WordMean=c.getString(mean_index);
            String book=c.getString(book_index);
            int ifnote=c.getInt(ifnote_index);
            ContentValues values = new ContentValues();
            values.put("name", WordName);
            values.put("meaning", WordMean);
            values.put("book", book);
            values.put("ifwrong", 1);
            values.put("ifnote", ifnote);
            dbHelper.update(values,"id=?",new String[]{String.valueOf(id)},"word");
        }
    }

    //选择单词4
    public void btn_mem_select_onclick4(View view) {
        BtnMenWd4=(Button)findViewById(R.id.btn_mem_word4);
        if(BtnMenWd4.getText().toString().equals(TrueMean))
        {//Right
            BtnMenWd4.setBackgroundColor(Color.parseColor("#00F260"));
        }
        else {//Wrong
            BtnMenWd4.setBackgroundColor(Color.parseColor("#b20a2c"));
            TrueBtn.setBackgroundColor(Color.parseColor("#00F260"));

            Cursor c=SearchWordFromWord(wordnow,c_db,0);
            int id_index=c.getColumnIndex("id");
            int word_index=c.getColumnIndex("name");
            int mean_index=c.getColumnIndex("meaning");
            int book_index=c.getColumnIndex("book");
            int ifwrong_index=c.getColumnIndex("ifwrong");
            int ifnote_index=c.getColumnIndex("ifnote");

            int id=c.getInt(id_index);
            String WordName=c.getString(word_index);
            String WordMean=c.getString(mean_index);
            String book=c.getString(book_index);
            int ifnote=c.getInt(ifnote_index);
            ContentValues values = new ContentValues();
            values.put("name", WordName);
            values.put("meaning", WordMean);
            values.put("book", book);
            values.put("ifwrong", 1);
            values.put("ifnote", ifnote);
            dbHelper.update(values,"id=?",new String[]{String.valueOf(id)},"word");
        }
    }

    //收藏触发
    public void btn_mem_collect_onclick(View view) {
        TxtvClct=(TextView)findViewById(R.id.tv_mem_collect);
        TxtvWord=(TextView)findViewById(R.id.tv_mem_word);
        TxtvClct.setText("已收藏");
        TxtvWord.setTextColor(Color.parseColor("#fc4a1a"));
        Cursor c=SearchWordFromWord(wordnow,c_db,0);
        int id_index=c.getColumnIndex("id");
        int word_index=c.getColumnIndex("name");
        int mean_index=c.getColumnIndex("meaning");
        int book_index=c.getColumnIndex("book");
        int ifwrong_index=c.getColumnIndex("ifwrong");
        int ifnote_index=c.getColumnIndex("ifnote");

        int id=c.getInt(id_index);
        String WordName=c.getString(word_index);
        String WordMean=c.getString(mean_index);
        String book=c.getString(book_index);
        int ifwrong=c.getInt(ifwrong_index);
        ContentValues values = new ContentValues();
        values.put("name", WordName);
        values.put("meaning", WordMean);
        values.put("book", book);
        values.put("ifwrong", ifwrong);
        values.put("ifnote", 1);
        dbHelper.update(values,"id=?",new String[]{String.valueOf(id)},"word");
    }

    private Cursor SearchWordFromWord(String word,Cursor c,int bias)
    {
        c.moveToFirst();
        String word_;
        while(!c.isAfterLast())
        {
            int word_index=c.getColumnIndex("name");
            word_=c.getString(word_index);
            if(word_.equals(word))
                break;
            else
                c.moveToNext();
        }
        if(c.isAfterLast())
            return null;
        for(int i=0;i<bias;i++)
        {
            c.moveToNext();
            if(c.isAfterLast())
                c.moveToFirst();
        }
        if(c.isAfterLast())
            return null;
        else
            return c;
    }

    private Cursor SearchWordNextFromBook(String book,Cursor c,String word)
    {
        String book_;
        c.moveToFirst();
        boolean find_id=false;
        while(!c.isAfterLast())
        {
            if(!find_id)
            {
                int word_index=c.getColumnIndex("name");
                String word_=c.getString(word_index);
                if(word_.equals(word))
                    find_id=true;
            }
            else
            {
                int book_index=c.getColumnIndex("book");
                book_=c.getString(book_index);
                if(book_.equals(book))
                    break;
            }
            c.moveToNext();
        }
        if(c.isAfterLast())
        {
            c.moveToFirst();
            return c;
        }
        else
            return c;
    }

    private void SetInterface(Cursor c)
    {
        TxtvWord=(TextView)findViewById(R.id.tv_mem_word);
        TxtvClct=(TextView)findViewById(R.id.tv_mem_collect);
        BtnMenWd1=(Button)findViewById(R.id.btn_mem_word1);
        BtnMenWd2=(Button)findViewById(R.id.btn_mem_word2);
        BtnMenWd3=(Button)findViewById(R.id.btn_mem_word3);
        BtnMenWd4=(Button)findViewById(R.id.btn_mem_word4);

        int word_index=c.getColumnIndex("name");
        int mean_index=c.getColumnIndex("meaning");
        int book_index=c.getColumnIndex("book");
        int ifwrong_index=c.getColumnIndex("ifwrong");
        int ifnote_index=c.getColumnIndex("ifnote");

        String WordName=c.getString(word_index);
        String WordMean=c.getString(mean_index);
        int ifnote=c.getInt(ifnote_index);
        TxtvWord.setText(WordName);
        if(ifnote==1)
        {
            TxtvClct.setText("已收藏");
            TxtvWord.setTextColor(Color.parseColor("#fc4a1a"));
        }
        else
        {
            TxtvClct.setText("未收藏");
            TxtvWord.setTextColor(Color.parseColor("#737373"));
        }
        int trueloc=(int)(1+Math.random()*(4-1+1));

        Cursor c_wrong=SearchWordFromWord(WordName,c,1);
        int mean_wrong_index=c_wrong.getColumnIndex("meaning");
        String wrong_mean1=c_wrong.getString(mean_wrong_index);
        c_wrong=SearchWordFromWord(WordName,c,2);
        mean_wrong_index=c_wrong.getColumnIndex("meaning");
        String wrong_mean2=c_wrong.getString(mean_wrong_index);
        c_wrong=SearchWordFromWord(WordName,c,3);
        mean_wrong_index=c_wrong.getColumnIndex("meaning");
        String wrong_mean3=c_wrong.getString(mean_wrong_index);

        switch (trueloc){
            case 1:
                BtnMenWd1.setText(WordMean);
                BtnMenWd2.setText(wrong_mean1);
                BtnMenWd3.setText(wrong_mean2);
                BtnMenWd4.setText(wrong_mean3);
                TrueBtn=BtnMenWd1;
                break;
            case 2:
                BtnMenWd2.setText(WordMean);
                BtnMenWd1.setText(wrong_mean1);
                BtnMenWd3.setText(wrong_mean2);
                BtnMenWd4.setText(wrong_mean3);
                TrueBtn=BtnMenWd2;
                break;
            case 3:
                BtnMenWd3.setText(WordMean);
                BtnMenWd2.setText(wrong_mean1);
                BtnMenWd1.setText(wrong_mean2);
                BtnMenWd4.setText(wrong_mean3);
                TrueBtn=BtnMenWd3;
                break;
            default:
                BtnMenWd4.setText(WordMean);
                BtnMenWd2.setText(wrong_mean1);
                BtnMenWd3.setText(wrong_mean2);
                BtnMenWd1.setText(wrong_mean3);
                TrueBtn=BtnMenWd4;
        }

        wordnow=WordName;
        TrueMean=WordMean;


        BtnMenWd1.setBackgroundColor(Color.parseColor("#00DDFF"));

        BtnMenWd2.setBackgroundColor(Color.parseColor("#00DDFF"));

        BtnMenWd3.setBackgroundColor(Color.parseColor("#00DDFF"));

        BtnMenWd4.setBackgroundColor(Color.parseColor("#00DDFF"));
    }

    public void btn_next_onclick(View view)
    {
        TxtvWord=(TextView)findViewById(R.id.tv_mem_word);
        String word=TxtvWord.getText().toString();
        Spn_book=(Spinner)findViewById(R.id.spi_choose);
        String book=Spn_book.getSelectedItem().toString();
//        System.out.println(book);
        Cursor c=SearchWordNextFromBook(book,c_db,word);
        SetInterface(c);
    }

    public void spn_onclick(View view)
    {
        c_db.moveToFirst();
        while(!c_db.isAfterLast())
        {
            Spn_book=(Spinner)findViewById(R.id.spi_choose);
            String book_=Spn_book.getSelectedItem().toString();
            int book_index=c_db.getColumnIndex("book");
            String book=c_db.getString(book_index);
            if(book.equals(book_))
                break;
            else
                c_db.moveToNext();
        }
        SetInterface(c_db);
    }
}
