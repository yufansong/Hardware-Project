package com.example.baicizhan;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.ContentValues;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView tvStatus;
    private TextView tvId;
    private TextView tvEmail;

    private  static final int REQUEST_REGISTER_CODE=0;
    private  static final int REQUEST_SIGNIN_CODE=1;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = findViewById(R.id.tv_stutas);
        tvEmail = findViewById(R.id.tv_email);
        tvId = findViewById(R.id.tv_id);

        dbHelper=new DBHelper(this);
        ContentValues values = new ContentValues();
        values.put("name", "watermelon");
        values.put("meaning", "西瓜");
        values.put("book", "四级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "lemon");
        values.put("meaning", "柠檬");
        values.put("book", "四级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "apple");
        values.put("meaning", "苹果");
        values.put("book", "四级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "banana");
        values.put("meaning", "香蕉");
        values.put("book", "四级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "pear");
        values.put("meaning", "梨");
        values.put("book", "四级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "strawberry");
        values.put("meaning", "草莓");
        values.put("book", "四级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "cherry");
        values.put("meaning", "樱桃");
        values.put("book", "六级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "mango");
        values.put("meaning", "芒果");
        values.put("book", "四级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "peach");
        values.put("meaning", "桃子");
        values.put("book", "六级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "grape");
        values.put("meaning", "葡萄");
        values.put("book", "四级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "papaya");
        values.put("meaning", "木瓜");
        values.put("book", "六级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "blueberry");
        values.put("meaning", "蓝莓");
        values.put("book", "六级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
        values = new ContentValues();
        values.put("name", "pitaya");
        values.put("meaning", "火龙果");
        values.put("book", "六级单词");
        values.put("ifwrong", "0");
        values.put("ifnote", "0");
        dbHelper.insert(values,"word");
    }

    public void btn_start_signin_onclick(View view) {
        Intent intent = new Intent(this,SigninActivity.class);
        startActivityForResult(intent,REQUEST_SIGNIN_CODE);//不知道这里有没有问题
    }


    public void btn_start_register_onclick(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivityForResult(intent,REQUEST_REGISTER_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(intent==null)
        {
            return;
        }
//        requestCode = REQUEST_SIGNIN_CODE_right;
        Intent intent2 = new Intent(this,PersonalActivity.class);
        Intent intent3 = new Intent(this,MainActivity.class);
        if (requestCode == REQUEST_REGISTER_CODE)
        {
            tvStatus.setText("注册成功");
            tvId.setText("ID"+intent.getStringExtra("id"));
            tvEmail.setText("Email"+intent.getStringExtra("email"));
            startActivityForResult(intent2,REQUEST_REGISTER_CODE);
        }
        if(requestCode == REQUEST_SIGNIN_CODE)
        {
            String result = "";
            result = intent.getStringExtra("result");
            System.out.println("Main Result:"+result);
            if(result.equals("right"))
            {
                tvStatus.setText("登陆失败");
                tvId.setText("失败");
                startActivityForResult(intent2,REQUEST_REGISTER_CODE);
                tvEmail.setText("");
            }
            else
            {
                tvStatus.setText("登陆成功");
                tvId.setText("您好"+intent.getStringExtra("id"));
                startActivityForResult(intent3,REQUEST_REGISTER_CODE);
                tvEmail.setText("");
            }
        }
    }
}
