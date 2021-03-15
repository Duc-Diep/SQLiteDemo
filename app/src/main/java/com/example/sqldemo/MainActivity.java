package com.example.sqldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String SHARE_PRE_NAME = "Account";
    EditText edtUsername,edtPassWord;
    Button btnSubmit,btnRead;
    CheckBox chkBox;
    SQLHelper sqlHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sqlHelper = new SQLHelper(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkBox.isChecked()){
                    SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PRE_NAME,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", String.valueOf(edtUsername.getText()));
                    editor.putString("password", String.valueOf(edtPassWord.getText()));
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Lưu thành công!!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PRE_NAME,MODE_PRIVATE);
                String username =sharedPreferences.getString("username","null");
                String password = sharedPreferences.getString("password","null");
                Toast.makeText(MainActivity.this, username+","+password, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AnhXa() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassWord = findViewById(R.id.edtPassWord);
        btnSubmit = findViewById(R.id.btnSubmit);
        chkBox = findViewById(R.id.chkBox);
        btnRead = findViewById(R.id.btnRead);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PRE_NAME,MODE_PRIVATE);
        String username =sharedPreferences.getString("username","null");
        String password = sharedPreferences.getString("password","null");
        edtUsername.setText(username);
        edtPassWord.setText(password);
    }
}