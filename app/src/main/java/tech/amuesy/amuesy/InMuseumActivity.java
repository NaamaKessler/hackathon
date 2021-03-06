package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InMuseumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_museum);

        //if(getIntent().hasExtra("tech.amuesy.amuesy.musName")){
            final String musName = getIntent().getExtras().getString("tech.amuesy.amuesy.musName");
            TextView tv = (TextView) findViewById(R.id.Title);
            tv.setText(musName+"'s Museum");
        //}



        Button createtourActBtn = findViewById(R.id.createtourActBtn);
        createtourActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),TourCreatorActivity.class);
                startActivity(startIntent);

            }
        });

        Button musInfoActBtn = findViewById(R.id.musInfoActBtn);
        musInfoActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start1Intent = new Intent(getApplicationContext(),MusInfoActivity.class);
                start1Intent.putExtra("tech.amuesy.amuesy.musName",musName);
                startActivity(start1Intent);
            }
        });

        Button musmapActBtn = findViewById(R.id.musmapActBtn);
        musmapActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),MusMapActivity.class);
                startIntent.putExtra("tech.amuesy.amuesy.musName",musName);
                startActivity(startIntent);
            }
        });


    }
}
