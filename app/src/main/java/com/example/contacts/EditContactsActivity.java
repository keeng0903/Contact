package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditContactsActivity extends AppCompatActivity {
    Button btnX , btnV;
    private EditText mEdtFullname , mEdtCompany , mEdtTitle , mEdtMobile , mEdtEmail ;
    private TextView mTVCreatedAt;
    private ImageView mlvAvtar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contacts);


        mEdtFullname = (EditText) findViewById(R.id.etd_fn);
        mEdtCompany = (EditText) findViewById(R.id.edt_com);
        mEdtTitle = (EditText) findViewById(R.id.edt_tit);
        mEdtMobile = (EditText) findViewById(R.id.edt_mo);
        mEdtEmail = (EditText) findViewById(R.id.edt_em);

        mlvAvtar = (ImageView) findViewById(R.id.img_V);
        mTVCreatedAt = (TextView) findViewById(R.id.tv_createdat);

        Intent intentData = getIntent();

        Bundle packBundle = intentData.getBundleExtra("My package");

        Contact getContact = (Contact)packBundle.getSerializable("Contact");

        mEdtFullname.setText(getContact.getmFullname());
        mEdtCompany.setText(getContact.getmCompany());
        mEdtTitle.setText(getContact.getmTitle());
        mEdtMobile.setText(getContact.getmMobile());
        mEdtEmail.setText(getContact.getmEmail());
//        mTVCreatedAt.setText(getContact.getmCreatedAt().toString());

    }


}
