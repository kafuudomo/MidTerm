package com.example.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends AppCompatActivity {
    private EditText etUserName, etPassword;
    private Button btn_Login;
    private TextView tvForgot;
    private CheckBox cbShowPassword;

    String Username = "Larry";
    String Password = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";



    StringBuffer sb = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        findview();

        String inputU = etUserName.getText().toString();
        String inputP = etPassword.getText().toString();

        Login(inputU);
        hashPassword(inputP);
        System.out.println("ABCABC"+sb);

    }

    private void findview(){
        etUserName = findViewById(R.id.UserName);
        etPassword = findViewById(R.id.Password);
        btn_Login = findViewById(R.id.btn_Login);
        tvForgot = findViewById(R.id.ForgotPasswrd);
        cbShowPassword = findViewById(R.id.ShowPassword);
    }

    private void Login(final String inputU){
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (inputU.equals(Username) && sb.equals(Password)){
                    Intent g = new Intent(MainActivity.this,GamesActivity.class);
                    startActivity(g);
                    Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"invalid username or password",Toast.LENGTH_SHORT).show();
                }

            }
        });

        cbShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ForgotActivity.class);
                startActivity(i);
            }
        });

    }

    private String hashPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(password.getBytes());

        byte[] hash = digest.digest();

        for (byte b : hash) {
            sb.append(String.format("%02x", b & 0xff));
        }

        return sb.toString();
    }


}
