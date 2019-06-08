package com.example.baicizhan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class BookActivity extends AppCompatActivity {

    private  static final int REQUEST_MEMORY_CODE = 0;
    private  static final int REQUEST_BOOK_CODE = 1;
    private  static final int REQUEST_ERROR_COLLECT_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }

    protected  void  select_book()
    {
        Intent intent = new Intent();
        intent.putExtra("id",1);
        setResult(1,intent);//REQUEST_BOOK_CODE
        finish();
    }
}
