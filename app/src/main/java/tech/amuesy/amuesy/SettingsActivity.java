package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button profileActBtn = findViewById(R.id.profileActBtn);

        profileActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent start1Intent = new Intent(getApplicationContext(),ThirdActivity.class);
                startActivity(start1Intent);
            }
        });

    }
}
