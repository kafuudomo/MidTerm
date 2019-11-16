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


public class MainActivity extends AppCompatActivity {
    private EditText entUserName, entPassword;
    private Button btnLogin;


    String Username = "Larry";
    String Password = SHA("ABCABC");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        findview();
        Login();
    }

    private void findview(){
        entUserName = findViewById(R.id.UserName);
        entPassword = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btn_Login);

    }

    private void Login(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputU = entUserName.getText().toString();
                String inputP = SHA(entPassword.getText().toString());


                if (inputU.equals(Username) && inputP.equals(Password)){
                    Intent g = new Intent(MainActivity.this,GamesActivity.class);
                    startActivity(g);
                    Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"invalid username or password",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    private String SHA(String x){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(x.getBytes());

            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest){
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


}
