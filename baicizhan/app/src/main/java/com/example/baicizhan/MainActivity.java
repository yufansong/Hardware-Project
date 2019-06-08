package com.example.baicizhan;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView tvStatus;
    private TextView tvId;
    private TextView tvEmail;

    private  static final int REQUEST_REGISTER_CODE=0;
    private  static final int REQUEST_SIGNIN_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = findViewById(R.id.tv_stutas);
        tvEmail = findViewById(R.id.tv_email);
        tvId = findViewById(R.id.tv_id);
    }

    public void btn_start_signin_onclick(View view) {
        Intent intent = new Intent(this,SigninActivity.class);
        startActivityForResult(intent,REQUEST_SIGNIN_CODE);
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
        switch(requestCode)
        {
            case REQUEST_REGISTER_CODE:
                tvStatus.setText("注册成功");
                tvId.setText("ID"+intent.getStringExtra("id"));
                tvEmail.setText("Email"+intent.getStringExtra("email"));
                break;
            case  REQUEST_SIGNIN_CODE:
                tvStatus.setText("登陆成功");
                tvId.setText("您好"+intent.getStringExtra("id"));
                tvEmail.setText("");
                break;
        }
        Intent intent2 = new Intent(this,PersonalActivity.class);
        startActivityForResult(intent2,REQUEST_REGISTER_CODE);
    }
}
