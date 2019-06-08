package com.example.baicizhan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void btn_start_signin_onclick(View view) {
        EditText etId = findViewById(R.id.et_signin_id);
        EditText etEmail = findViewById(R.id.et_signin_email);
        EditText etPassword = findViewById(R.id.et_signin_password);
        Intent intent = new Intent();
        intent.putExtra("id",etId.getText().toString());
        intent.putExtra("email",etEmail.getText().toString());
        intent.putExtra("password",etPassword.getText().toString());
        setResult(0,intent);
        finish();
    }
}
