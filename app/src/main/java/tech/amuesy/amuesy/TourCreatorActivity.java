package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class TourCreatorActivity extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();

    int hours;
    CheckBox t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_creator);



        //seek Bar
        final SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
        final TextView tv = (TextView) findViewById(R.id.HoursTxt);

        sb.setMax(10);

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



        final boolean isChecked_1 = ((CheckBox) findViewById(R.id.checkBox1)).isChecked();
        final boolean isChecked_2 = ((CheckBox) findViewById(R.id.checkBox2)).isChecked();
        final boolean isChecked_3 = ((CheckBox) findViewById(R.id.checkBox3)).isChecked();
        final boolean isChecked_4 = ((CheckBox) findViewById(R.id.checkBox4)).isChecked();
        final boolean isChecked_5 = ((CheckBox) findViewById(R.id.checkBox5)).isChecked();

        Button NextBtn = findViewById(R.id.NextBtn);
        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),TourActivity.class);
                startIntent.putExtra("tech.amuesy.amuesy.hours",hours);

                startIntent.putExtra("tech.amuesy.amuesy.box1",isChecked_1);
                startIntent.putExtra("tech.amuesy.amuesy.box2",isChecked_2);
                startIntent.putExtra("tech.amuesy.amuesy.box3",isChecked_3);
                startIntent.putExtra("tech.amuesy.amuesy.box4",isChecked_4);
                startIntent.putExtra("tech.amuesy.amuesy.box5",isChecked_5);

                startActivity(startIntent);
            }
        });



    }


}
