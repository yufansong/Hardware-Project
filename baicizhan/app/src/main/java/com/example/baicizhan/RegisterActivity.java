package com.example.baicizhan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.ContentValues;

public class RegisterActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper=new DBHelper(this);
    }

    public void btn_sumbit_register_onclick(View view) {
        EditText etId = findViewById(R.id.et_reg_id);
        EditText etEmail = findViewById(R.id.et_reg_email);
        EditText etPassword = findViewById(R.id.et_reg_password);
        Intent intent = new Intent();
        intent.putExtra("id",etId.getText().toString());
        intent.putExtra("email",etEmail.getText().toString());
        intent.putExtra("password",etPassword.getText().toString());
        ContentValues values = new ContentValues();
        values.put("nameid", etId.getText().toString());
        values.put("email", etEmail.getText().toString());
        values.put("password", etPassword.getText().toString());
        dbHelper.insert(values,"user");
        setResult(0,intent);
        finish();
    }
}
