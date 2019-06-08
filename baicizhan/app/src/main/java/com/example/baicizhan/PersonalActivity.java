package com.example.baicizhan;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PersonalActivity extends AppCompatActivity {

    private  static final int REQUEST_MEMORY_CODE = 0;
    private  static final int REQUEST_BOOK_CODE = 1;
    private  static final int REQUEST_ERROR_COLLECT_CODE = 2;
    private  static final int book_num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
    }

    public void btn_per_start_mem(View view) {
        Intent intent = new Intent(this,MemoryActivity.class);
        startActivityForResult(intent,REQUEST_MEMORY_CODE);
    }

    public void btn_per_start_book(View view) {
        Intent intent = new Intent(this,BookActivity.class);
        startActivityForResult(intent,REQUEST_BOOK_CODE);
    }

    public void btn_per_start_error(View view) {
        Intent intent = new Intent(this,Error_Collect_Activity.class);
        startActivityForResult(intent,REQUEST_ERROR_COLLECT_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(intent==null)
        {
            return;
        }
//        switch(requestCode)
//        {
//            case REQUEST_BOOK_CODE:
//                tvStatus.setText("注册成功");
//                tvId.setText("ID"+intent.getStringExtra("id"));
//                tvEmail.setText("Email"+intent.getStringExtra("email"));
//                break;
//        }
    }
}
