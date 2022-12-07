package com.manjil.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactOpenActivity extends AppCompatActivity {
    Button btContact,btCall;

    public View.OnClickListener btContactOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openContact();
        }
    };

    public View.OnClickListener btCallOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openDialer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_open);

        btContact = findViewById(R.id.btOpenContact);
        btCall = findViewById(R.id.btCall);

        btContact.setOnClickListener(btContactOnClickListener);
        btCall.setOnClickListener(btCallOnClickListener);
    }

    public void openContact(){
//        create intent for opening contacts
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivity(intent);
    }

    public void openDialer(){
//        create intent for opening dialer
        Intent intent = new Intent(Intent.ACTION_DIAL);

//        setting phone number as data for intent
        intent.setData(Uri.parse("tel:" + "9874"));
        startActivity(intent);
    }
}