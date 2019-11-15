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
    private EditText etUserName, etPassword;
    private Button btn_Login;
    private TextView tvForgot;
    private CheckBox cbShowPassword;

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
        etUserName = findViewById(R.id.UserName);
        etPassword = findViewById(R.id.Password);
        btn_Login = findViewById(R.id.btn_Login);
        tvForgot = findViewById(R.id.ForgotPasswrd);
        cbShowPassword = findViewById(R.id.ShowPassword);
    }

    private void Login(){
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputU = etUserName.getText().toString();
                String inputP = SHA(etPassword.getText().toString());


                if (inputU.equals(Username) && inputP.equals(Password)){
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
//http://www.pratikbutani.com/2016/01/android-json-parsing-using-okhttp-example-with-custom-view-imageview-textview/