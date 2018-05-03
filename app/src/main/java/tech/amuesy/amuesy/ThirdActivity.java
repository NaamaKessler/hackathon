package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity  {

    int hours;
    String profile;
    String level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Profile Spinner - need to save answer from user
        Spinner ProfileSpinner = (Spinner) findViewById(R.id.ProfileSpinner);
        ArrayAdapter<String> adapter3_1 = new ArrayAdapter<String>(ThirdActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray((R.array.Profiles)));
        adapter3_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ProfileSpinner.setAdapter(adapter3_1);
        ProfileSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                profile = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        // Level Spinner - need to save answer from user
        Spinner LevelSpinner = (Spinner) findViewById(R.id.LevelSpinner);
        ArrayAdapter<String> adapter3_2 = new ArrayAdapter<String>(ThirdActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray((R.array.Levels)));
        adapter3_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LevelSpinner.setAdapter(adapter3_2);
        LevelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                level = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        //seek Bar
        SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
        final TextView tv = (TextView) findViewById(R.id.HoursTxt);

        sb.setMax(12);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                hours=progress;
                tv.setText(progress + " Hours");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                hours=seekBar.getProgress();
                tv.setText(seekBar.getProgress() + " Hours");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                hours=seekBar.getProgress();
                tv.setText(seekBar.getProgress() + " Hours");
            }
        });


        Button okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);

                // Send back informations
                startIntent.putExtra("tech.amuesy.amuesy.profile",profile);
                startIntent.putExtra("tech.amuesy.amuesy.level",level);
                startIntent.putExtra("tech.amuesy.amuesy.hours",hours);

                startActivity(startIntent);
            }


        });


    }


    private class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String selected = parent.getItemAtPosition(pos).toString();
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }
}

