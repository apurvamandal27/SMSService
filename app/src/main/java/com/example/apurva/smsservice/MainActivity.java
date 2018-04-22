package com.example.apurva.smsservice;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num,msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num=findViewById(R.id.no);
        msg=findViewById(R.id.msg);
        send=findViewById(R.id.send);



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
            return;
        }

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=num.getText().toString();
                String sms=msg.getText().toString();

                //to get default sms services

                SmsManager smsManager=SmsManager.getDefault();

                smsManager.sendTextMessage(to,null,sms,null,null);




                num.setText("");
                msg.setText("");
                Toast.makeText(MainActivity.this, "Your SMS is sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
