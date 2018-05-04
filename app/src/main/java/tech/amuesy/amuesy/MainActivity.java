package tech.amuesy.amuesy;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isServicesOK()){
            init();
        }

        Button chooseActBtn = findViewById(R.id.chooseActBtn);
        chooseActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(startIntent);
            }


        });

        Button settingsActBtn = findViewById(R.id.settingsActBtn);
        settingsActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(startIntent);
            }


        });


        // get user's setting:
        if ((getIntent().hasExtra("tech.amuesy.amuesy.profile")||
                (getIntent().hasExtra("tech.amuesy.amuesy.level"))||
                (getIntent().hasExtra("tech.amuesy.amuesy.hours")))){
            TextView tv = (TextView) findViewById(R.id.textViewMain);
            String profile_info = getIntent().getExtras().getString("tech.amuesy.amuesy.profile"); //todo: nullPtrExcept.
            String level_info = getIntent().getExtras().getString("tech.amuesy.amuesy.level");
            int hours_info = getIntent().getExtras().getInt("tech.amuesy.amuesy.hours");
            int box1 = getIntent().getExtras().getInt("tech.amuesy.amuesy.box1");
            int box2 = getIntent().getExtras().getInt("tech.amuesy.amuesy.box2");
            Boolean box3 = getIntent().getExtras().getBoolean("tech.amuesy.amuesy.box3");
            Boolean box4 = getIntent().getExtras().getBoolean("tech.amuesy.amuesy.box4");
            Boolean box5 = getIntent().getExtras().getBoolean("tech.amuesy.amuesy.box5");



            tv.setText(profile_info+","+level_info+","+hours_info+","
                    +box1+","+box2+","+box3+","+box4+","+box5);

            // save user's settings:
            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("duration_info", hours_info);
            editor.putString("level_info", level_info);
            editor.putString("profile_info", profile_info);
            editor.apply();
        }




    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    private void init(){
        Button nearbyActBtn = (Button) findViewById(R.id.nearbyActBtn);
        nearbyActBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity1.class);
                startActivity(intent);
            }
        });
    }


    public boolean isServicesOK(){
        Log.d(TAG,"isServiceOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
          //everything is fine and the user can make map requests
          Log.d(TAG, "isServicesOK: Google Play Services is working");
          return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            //an error occured but we can resolve it
            Log.d(TAG, "isServiceOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
