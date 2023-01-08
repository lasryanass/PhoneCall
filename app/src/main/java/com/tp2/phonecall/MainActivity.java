package com.tp2.phonecall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.app.ActivityCompat;
public class MainActivity extends AppCompatActivity {
    private Button bouton;
    private EditText phoneNumber;
    public final static int MY_PERMISSION_REQUEST_PHONE_CALL = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bouton = findViewById(R.id.button);
        phoneNumber = findViewById(R.id.phoneNumber);
        bouton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                Intent callIntent = new Intent(Intent.ACTION_DIAL);
//                callIntent.setData(Uri.parse("tel:00212616449925"));
                callIntent.setData(Uri.parse("tel:"+ phoneNumber.getText().toString()));
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {   //return;
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSION_REQUEST_PHONE_CALL);
                }
                else{
                    startActivity(callIntent);
                }
            }
        });
    }
}