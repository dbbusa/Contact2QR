package in.ac.rku.contact2qr;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Objects;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        setRequestedOrientation This method is used to set rotation statically
//          -- If App required Portrait mode then pass ActivityInfo.SCREEN_ORIENTATION_PORTRAIT as parameter
//          -- If App required Landscape mode then pass ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE as parameter
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//        Window class will return the current window of the screen
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//      window.setStatusBarColor will take int as parameter, and used to set the color for status bar
//        -- ContextCompat.getColor() this method will take a 2 parameter which is current reference and source of color variable
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));
//        similarly setNavigationBarColor will take the int as parameter and will set the color of navigation bar which is different from device to device
        window.setNavigationBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));

//      Toolbar is the class which is used to create custom toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        inflateMenu method of Toolbar class is used to inflate menu.xml in toolbar
        toolbar.inflateMenu(R.menu.menu);
//        setOnMenuItemClickListener will trigger when any item of the menu is selected
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.about:
//                        There are two types of intent 1) implicit  2) explicit
//                        Please Refer this link to know more about intent https://www.geeksforgeeks.org/android-implicit-and-explicit-intents-with-examples/
                        startActivity(new Intent(getApplicationContext(),AboutUs.class));
                        return true;
                    case R.id.contact:
                        startActivity(new Intent(getApplicationContext(),ContactUs.class));
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
}