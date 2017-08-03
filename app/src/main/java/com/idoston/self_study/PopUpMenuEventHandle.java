package com.idoston.self_study;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by doston on 7/26/17.
 */

public class PopUpMenuEventHandle implements PopupMenu.OnMenuItemClickListener{

    Context context;
    public PopUpMenuEventHandle(Context context){
        this.context = context;
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if(item.getItemId() == R.id.id_admin){
            Toast.makeText(context, "Logged in as ADMIN!!!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.id_user){
            Toast.makeText(context, "Logged in as USER!!!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.id_guest){
            Toast.makeText(context, "Logged in as GUEST!!!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.id_others){
            Toast.makeText(context, "Logged in as OTHERS!!!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
