package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddContact extends AppCompatActivity {
    Button btnX , btnV;
    private EditText mEdtFullname , mEdtCompany , mEdtTitle , mEdtMobile , mEdtEmail ;
    private TextView mTVCreatedAt;
    private ImageView mlvAvtar;
    private MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);


        db = new MyDatabase(this);
        mEdtFullname = (EditText) findViewById(R.id.etd_fn);
        mEdtCompany = (EditText) findViewById(R.id.edt_com);
        mEdtTitle = (EditText) findViewById(R.id.edt_tit);
        mEdtMobile = (EditText) findViewById(R.id.edt_mo);
        mEdtEmail = (EditText) findViewById(R.id.edt_em);

        mlvAvtar = (ImageView) findViewById(R.id.img_V);
        mTVCreatedAt = (TextView) findViewById(R.id.tv_createdat);
        btnX = (Button) findViewById(R.id.btn_X);
        btnV = (Button) findViewById(R.id.btn_V);

        setOnClick();

    }

    public Contact addContact(){
        Contact newContact = new Contact();
        newContact.setmFullname(mEdtFullname.getText().toString());
        newContact.setmCompany(mEdtCompany.getText().toString());
        newContact.setmTitle(mEdtTitle.getText().toString());
        newContact.setmMobile(mEdtMobile.getText().toString());
        newContact.setmEmail(mEdtEmail.getText().toString());

        String dateInString = new SimpleDateFormat("yyyy-MM-dd",
                Locale.getDefault()).format(new Date());
        newContact.setmCreatedAt(dateInString);
        newContact.setmId(db.addContact(newContact));

        return newContact;
    }


    public void setOnClick(){
        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = addContact();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("RESULT", contact);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
