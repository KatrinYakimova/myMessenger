package com.trish.mymessenger;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int accType;

    String[] accounts = {"Vkontakte", "Hangouts", "Telegram"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        MyCustomAdapter adapter = new MyCustomAdapter(MainActivity.this,
                R.layout.vk, accounts);
        spinner.setAdapter(adapter);
        spinner.setPromptId(R.string.chooseAcc);
        spinner.setSelection(0, true);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    public class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            // TODO Auto-generated method stub
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.vk, parent, false);
            TextView label = (TextView) row.findViewById(R.id.account);
            label.setText(accounts[position]);

            ImageView icon = (ImageView) row.findViewById(R.id.icon);

            if (accounts[position] == "VKontakte") {
                icon.setImageResource(R.drawable.icon_64x64);
            } else if (accounts[position] == "Hangouts") {
                icon.setImageResource(R.drawable.icn_hangouts_64);
            } else if (accounts[position] == "Telegram") {
                icon.setImageResource(R.drawable.telegram);
            }
            return row;
        }
    }

    public void onAddAccountClick(View view) {
          // accType=spinner.getSelectedItemPosition();
    }
}
