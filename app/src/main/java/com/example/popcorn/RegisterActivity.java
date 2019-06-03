package com.example.popcorn;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper = new DBHelper(this, "BookKeeping.db", null, 1);
        initView();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String username = String.valueOf(etUsername.getText().toString());
                String password = String.valueOf(etPassword.getText().toString());
                String confirmpassword = String.valueOf(etConfirmPassword.getText().toString());

                if (confirmpassword.equals(password)) {
                    if (DBUtil.addUser(username, password)) {
                        Toast.makeText(RegisterActivity.this, "register successfully", Toast.LENGTH_SHORT).show();
                        {
                            Intent intent = new Intent(RegisterActivity.this, UserActivity.class);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "register failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "兩次輸入的密碼不一致", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirmpassword);
        btnRegister = findViewById(R.id.btn_register_user);
    }

}



