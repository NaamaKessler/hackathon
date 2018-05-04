package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MusInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mus_info);

        // get museum's name
        final String musName = getIntent().getExtras().getString("tech.amuesy.amuesy.musName");
        TextView tv = (TextView) findViewById(R.id.Title);
        tv.setText(musName+"'s Museum Info");


        Button infoBackBtn = findViewById(R.id.infoBackBtn);

        infoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent startIntent = new Intent(getApplicationContext(),InMuseumActivity.class);
                startIntent.putExtra("tech.amuesy.amuesy.musName",musName);
                startActivity(startIntent);
            }
        });
    }
}
