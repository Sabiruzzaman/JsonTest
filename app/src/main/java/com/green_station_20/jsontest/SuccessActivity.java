package com.green_station_20.jsontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    TextView msg,name,ins,deg,mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        msg = findViewById(R.id.messageId);
        name = findViewById(R.id.nameId);
        ins = findViewById(R.id.instituteId);
        deg = findViewById(R.id.designationId);
        mob = findViewById(R.id.mobileId);

        String msgvalue = getIntent().getStringExtra("m");
        String nvalue = getIntent().getStringExtra("n");
        String insvalue = getIntent().getStringExtra("i");
        String degvalue = getIntent().getStringExtra("d");
        String mobvalue = getIntent().getStringExtra("m_b");

        msg.setText(msgvalue);
        name.setText(nvalue);
        ins.setText(insvalue);
        deg.setText(degvalue);
        mob.setText(mobvalue);
    }
}