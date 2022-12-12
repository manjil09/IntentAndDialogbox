package com.manjil.loginui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etUserName,etPassword;

    public View.OnClickListener btSignInOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (etPassword.getText().toString().matches("") || etUserName.getText().toString().matches(""))
                openInvalidDialog();
            else
                openLoginActivity();
        }
    };

    public View.OnClickListener btFbOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openFbDialog();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSignIn = findViewById(R.id.btSignIn);
        Button btFbLogin = findViewById(R.id.btFbLogin);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        btSignIn.setOnClickListener(btSignInOnClickListener);
        btFbLogin.setOnClickListener(btFbOnClickListener);
    }
    public void openLoginActivity(){
        Intent openContactActivity = new Intent(MainActivity.this, ContactOpenActivity.class);
        openContactActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(openContactActivity);
    }

    public void openInvalidDialog(){
        InvalidDialog invalidDialog = new InvalidDialog();
        invalidDialog.show(getSupportFragmentManager(), "invalid dialog");
    }

    public void openFbDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View customLayout = getLayoutInflater().inflate(R.layout.custom_layout,null);

        builder.setView(customLayout)
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        etUserName.setText("facebook");
                        etPassword.setText("facebook");
                    }
                });

        builder.show();
    }
}