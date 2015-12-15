package com.example.tringapps.list_json;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Contact_details extends AppCompatActivity {
    private Contacts contacts;
    private TextView id,name,email,address,gender,mobile,home,office;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Bundle bundle=getIntent().getExtras();
        contacts=(Contacts )bundle .getSerializable("object");
        id=(TextView )findViewById(R.id.idtext);
        name=(TextView )findViewById(R.id.nametext );
        email=(TextView )findViewById(R.id.emailtext );
        gender=(TextView )findViewById(R.id.gendertext);
        address=(TextView )findViewById(R.id.addresstext);
        mobile=(TextView )findViewById(R.id.mobiletext);
        home =(TextView )findViewById(R.id.hometext );
        office =(TextView )findViewById(R.id.officetext );
        id.setText(contacts.getId());
        name .setText(contacts.getName());
        email .setText(contacts .getEmail() );
        gender .setText(contacts .getGender() );
        address .setText(contacts .getAddress() );
        mobile .setText(contacts .getMobile() );
        office .setText(contacts .getOffice() );
        home.setText(contacts .getHome() );

    }

}
