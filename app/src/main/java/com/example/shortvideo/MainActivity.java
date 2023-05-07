package com.example.shortvideo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.shortvideo.admin.AdminMainActivity;
public class MainActivity extends AppCompatActivity {
    private static final String USER_NAME = "123";
    private static final String PASSWORD = "123";
    private static final String ADMIN_NAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        // 登录按钮
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (username.equals(USER_NAME) && password.equals(PASSWORD)) {
                    startActivity(new Intent(MainActivity.this, ShortVideoListActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // 注册按钮
        Button btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
        // 管理员登录按钮
        Button btnAdminLogin = findViewById(R.id.btn_admin_login);
        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (username.equals(ADMIN_NAME) && password.equals(ADMIN_PASSWORD)) {
                    startActivity(new Intent(MainActivity.this, AdminMainActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "管理员用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
