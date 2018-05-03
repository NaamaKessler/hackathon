package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class TourCreatorActivity extends AppCompatActivity {


    int hours;

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


        Button NextBtn = findViewById(R.id.NextBtn);
        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),MainActivity.class);
                startIntent.putExtra("tech.amuesy.amuesy.hours",hours);

                startActivity(startIntent);
            }
        });



    }
}
