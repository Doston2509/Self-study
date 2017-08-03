package com.idoston.self_study;

import android.net.wifi.aware.Characteristics;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleAndSwitch extends AppCompatActivity {

    TextView result_text;
    Switch switching;

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_and_switch);

        result_text = (TextView)findViewById(R.id.result_text);
        result_text.setVisibility(View.INVISIBLE);


        switching = (Switch)findViewById(R.id.switch_button);
        switching.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked){
                            result_text.setText("WiFi On!!!");
                            result_text.setVisibility(View.VISIBLE);
                        } else {
                            result_text.setText("WiFi Off!!!");
                            result_text.setVisibility(View.VISIBLE);
                        }
                    }
                }
        );

        //To add icon to actionBar

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayUseLogoEnabled(true);
        myActionBar.setDisplayShowHomeEnabled(true);
        myActionBar.setLogo(R.drawable.ic_phone_android_black_24dp);

        //To enable "add up button in actionBar" 'back button'
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //Spinner
        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.country_names, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                        Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(position) + " selected",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        Toast.makeText(ToggleAndSwitch.this, "Please, select country!!!", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void changeVibrateState(View view){

        boolean check = ((ToggleButton)view).isChecked();
        if(check){
            result_text.setText("Vibrate On!!!");
            result_text.setVisibility(View.VISIBLE);
        } else {
            result_text.setText("Vibrate Off!!");
            result_text.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_action, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(ToggleAndSwitch.this, "Sorry, there is no any option for setting!!!", Toast.LENGTH_LONG).show();
            return true;
        }
        switch(id){
            case R.id.id_about_us:
                Toast.makeText(ToggleAndSwitch.this, "I am Junior Android Developer!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_contact_us:
                Toast.makeText(ToggleAndSwitch.this, "If you want to cantact me, please write email to doston2509@gmail.com!!!",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_search:
                Toast.makeText(ToggleAndSwitch.this, "Sorry, there is no any option for search!!!", Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
