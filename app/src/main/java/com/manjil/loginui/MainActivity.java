package com.manjil.loginui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etUserName,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSignIn = findViewById(R.id.btSignIn);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPassword.getText().toString().matches("") || etUserName.getText().toString().matches(""))
                    openInvalidDialog();
                else
                    openLoginActivity();
            }
        });
    }
    public void openLoginActivity(){
        Intent openContactActivity = new Intent(MainActivity.this, ContactOpenActivity.class);
        startActivity(openContactActivity);
    }

    public void openInvalidDialog(){
        InvalidDialog invalidDialog = new InvalidDialog();
        invalidDialog.show(getSupportFragmentManager(), "invalid dialog");
    }
}