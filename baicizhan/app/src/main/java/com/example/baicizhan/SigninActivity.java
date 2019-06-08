package com.example.baicizhan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.database.Cursor;

public class SigninActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private Cursor c_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        dbHelper=new DBHelper(this);
    }

    public void btn_start_signin_onclick(View view) {
        EditText etId = findViewById(R.id.et_signin_id);
        EditText etEmail = findViewById(R.id.et_signin_email);
        EditText etPassword = findViewById(R.id.et_signin_password);


        c_db=dbHelper.query("user");
        c_db=SearchUserFromNameid(etId.getText().toString(),c_db);
        String email="error";
        String password="error";
        if(c_db!=null)
        {
            int email_index=c_db.getColumnIndex("email");
            int password_index=c_db.getColumnIndex("password");
            email=c_db.getString(email_index);
            password=c_db.getString(password_index);
        }

        Intent intent = new Intent();
        intent.putExtra("id",etId.getText().toString());
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        setResult(0,intent);
        finish();
    }

    private Cursor SearchUserFromNameid(String Nameid,Cursor c)
    {
        c.moveToFirst();
        String nameid_;
        while(!c.isAfterLast())
        {
            int NameId_index=c.getColumnIndex("nameid");
            nameid_ =c.getString(NameId_index);
            if(nameid_.equals(Nameid))
                break;
            else
                c.moveToNext();
        }
        if(c.isAfterLast())
            return null;
        else
            return c;
    }

}
