package com.example.popcorn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUser=(Button)findViewById(R.id.btn_user);
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到user页面
                Intent intent=new Intent(MainActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
