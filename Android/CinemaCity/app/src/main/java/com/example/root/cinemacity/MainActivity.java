package com.example.root.cinemacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private Button btnSingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnSingIn = (Button) findViewById(R.id.btnSingIn);
        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void login(){
        Intent intentMain = new Intent(MainActivity.this,
                LoginActivity.class);
      //  intentMain.putExtra("user", user);
        MainActivity.this.startActivity(intentMain);
    }

    public void register(){
        Intent intentMain = new Intent(MainActivity.this,
                RegisterActivity.class);
        //  intentMain.putExtra("user", user);
        MainActivity.this.startActivity(intentMain);
    }
}
