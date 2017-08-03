package com.idoston.self_study;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class TakeCamera extends AppCompatActivity {

    public static final int REQUEST_CAPTURE = 1;
    private ImageView result_photo;
    private Button take_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_camera);

        result_photo = (ImageView)findViewById(R.id.showImage);
        take_photo = (Button)findViewById(R.id.takePicture);

        if(!hasCamera()){
            take_photo.setEnabled(false);
        }


        //To add icon to actionBar

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayUseLogoEnabled(true);
        myActionBar.setDisplayShowHomeEnabled(true);
        myActionBar.setLogo(R.drawable.ic_phone_android_black_24dp);

        //To enable "add up button in actionBar" 'back button'
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }
    public void launchCamera(View view){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAPTURE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_CAPTURE && resultCode == RESULT_OK){

            Bundle extra = data.getExtras();
            Bitmap photo = (Bitmap) extra.get("data");
            result_photo.setImageBitmap(photo);
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
            Toast.makeText(TakeCamera.this, "Sorry, there is no any option for setting!!!", Toast.LENGTH_LONG).show();
            return true;
        }
        switch(id){
            case R.id.id_about_us:
                Toast.makeText(TakeCamera.this, "I am Junior Android Developer!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_contact_us:
                Toast.makeText(TakeCamera.this, "If you want to cantact me, please write email to doston2509@gmail.com!!!",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_search:
                Toast.makeText(TakeCamera.this, "Sorry, there is no any option for search!!!", Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
