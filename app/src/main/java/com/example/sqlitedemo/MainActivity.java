package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLHelper sqlHelper;
    List<Account> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlHelper = new SQLHelper(this);
        list = sqlHelper.getAllAccount();
        Log.d("test", "onCreate: "+list.size());
    }
}