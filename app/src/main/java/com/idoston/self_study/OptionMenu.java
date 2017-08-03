package com.idoston.self_study;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class OptionMenu extends AppCompatActivity {

    ImageView imageView;
    ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        imageView = (ImageView)findViewById(R.id.image_view);
        imageView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if(actionMode != null){
                            return false;
                        } else {
                            actionMode = OptionMenu.this.startActionMode(callback);
                            return true;
                        }

                        //return false;
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
            Toast.makeText(OptionMenu.this, "Sorry, there is no any option for setting!!!", Toast.LENGTH_LONG).show();
            return true;
        }
        switch(id){
            case R.id.id_about_us:
                Toast.makeText(OptionMenu.this, "I am Junior Android Developer!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_contact_us:
                Toast.makeText(OptionMenu.this, "If you want to cantact me, please write email to doston2509@gmail.com!!!",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_search:
                Toast.makeText(OptionMenu.this, "Sorry, there is no any option for search!!!", Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.my_menus, menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode Mode, Menu menu) {

            Mode.setTitle("Lion is king of animal world!!!");
           return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

            if(menuItem.getItemId() == R.id.id_delete){
                Toast.makeText(OptionMenu.this, "Do you really want to delete the image?", Toast.LENGTH_LONG).show();
                return true;
            } else if ( menuItem.getItemId() == R.id.id_share){
                Toast.makeText(OptionMenu.this, "Do you really want to share the image?", Toast.LENGTH_LONG).show();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode Mode) {

            Mode = null;
        }
    };

}
