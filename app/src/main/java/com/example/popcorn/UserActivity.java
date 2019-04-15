package com.example.popcorn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etUserName;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnLogin= findViewById(R.id.btn_login);
        etUserName= findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                if("manyuet".equals(username) && "123456".equals(password)) {
                    Toast.makeText(UserActivity.this, "login successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UserActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        etUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("edittext",s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
