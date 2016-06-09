//package com.example.root.cinemacity;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.inputmethod.EditorInfo;
//import android.widget.AutoCompleteTextView;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import org.w3c.dom.Text;
//
//import models.Users;
//
///**
// * Created by root on 08.06.16.
// */
//public class UserMainActivity extends AppCompatActivity {
//    Users user;
//    TextView label;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        user = (Users) getIntent().getSerializableExtra("User");
//        label = (TextView) findViewById(R.id.label);
//        label.setText(user.getName());
//
//    }
//}
