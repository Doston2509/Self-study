package com.idoston.self_study;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by doston on 7/25/17.
 */

public class CheckBoxing extends AppCompatActivity {

    ArrayList<String> selection = new ArrayList<String>();
    TextView result;
    CheckBox java, cpp, js, php;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        result = (TextView)findViewById(R.id.showResult);

        java = (CheckBox)findViewById(R.id.program_java);
        cpp = (CheckBox)findViewById(R.id.program_cpp);
        js = (CheckBox)findViewById(R.id.program_js);
        php = (CheckBox)findViewById(R.id.program_php);

        //To add icon to actionBar

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayUseLogoEnabled(true);
        myActionBar.setDisplayShowHomeEnabled(true);
        myActionBar.setLogo(R.drawable.ic_phone_android_black_24dp);

        //To enable "add up button in actionBar" 'back button'
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void finalSelection(View view){

        selection.add("Java " + java.isChecked());
        selection.add("C++ " + cpp.isChecked());
        selection.add("JavaScript " + js.isChecked());
        selection.add("PHP " + php.isChecked());
        String show = "";
        for(int i=0; i<selection.size(); i++){
            show = show + selection.get(i) + "\n";
        }
        result.setText(show);
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
            Toast.makeText(CheckBoxing.this, "Sorry, there is no any option for setting!!!", Toast.LENGTH_LONG).show();
            return true;
        }
        switch(id){
            case R.id.id_about_us:
                Toast.makeText(CheckBoxing.this, "I am Junior Android Developer!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_contact_us:
                Toast.makeText(CheckBoxing.this, "If you want to cantact me, please write email to doston2509@gmail.com!!!",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_search:
                Toast.makeText(CheckBoxing.this, "Sorry, there is no any option for search!!!", Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
