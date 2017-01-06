package com.hadrami.oumar.safewoman;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SettingsActivity extends AppCompatActivity {

    ArrayList<MobileNumber> mobileNumbers;
    ListView mobileNumbersListView ;
    ImageButton addMobileNumber;
    EditText mobileEditText;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mobileNumbers = new ArrayList<MobileNumber>();
        mobileNumbersListView = (ListView)findViewById(R.id.mobile_number_listview);
        addMobileNumber = (ImageButton)findViewById(R.id.add_mobile);

        mobileNumbers.add(new MobileNumber("4757852547"));
        mobileNumbers.add(new MobileNumber("5887445859"));



        MobileNumberAdapter mobileNumberAdapter = new MobileNumberAdapter(getApplicationContext(),mobileNumbers);
        mobileNumbersListView.setAdapter(mobileNumberAdapter);



    }













    public static class MobileNumberAdapter extends ArrayAdapter<MobileNumber> {


        public MobileNumberAdapter(Context context, ArrayList<MobileNumber> mobileNumbers) {
            super(context, 0, mobileNumbers);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.mobile_item, parent, false);
            }

            MobileNumber mobileNumber = getItem(position);
            TextView itemName = (TextView) listItemView.findViewById(R.id.mobile_textview);
            itemName.setText(mobileNumber.getMobileNumber());

            ImageButton itemDelete = (ImageButton) listItemView.findViewById(R.id.add_or_delete);
            return listItemView;
        }
    }
}
