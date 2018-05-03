package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent startIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(startIntent);
            }


        });





        if ((getIntent().hasExtra("tech.amuesy.amuesy.profile")||(getIntent().hasExtra("tech.amuesy.amuesy.level"))||
                (getIntent().hasExtra("tech.amuesy.amuesy.hours")))){
            TextView tv = (TextView) findViewById(R.id.textViewMain);

            String profile_info = getIntent().getExtras().getString("tech.amuesy.amuesy.profile");
            String level_info = getIntent().getExtras().getString("tech.amuesy.amuesy.level");
            int hours_info = getIntent().getExtras().getInt("tech.amuesy.amuesy.hours");

            tv.setText(profile_info+","+level_info+","+hours_info);
        }


    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
