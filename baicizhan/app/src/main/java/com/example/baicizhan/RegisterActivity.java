package com.example.baicizhan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void btn_sumbit_register_onclick(View view) {
        EditText etId = findViewById(R.id.et_reg_id);
        EditText etEmail = findViewById(R.id.et_reg_email);
        EditText etPassword = findViewById(R.id.et_reg_password);
        Intent intent = new Intent();
        intent.putExtra("id",etId.getText().toString());
        intent.putExtra("email",etEmail.getText().toString());
        intent.putExtra("password",etPassword.getText().toString());
        setResult(0,intent);
        finish();
    }
}
