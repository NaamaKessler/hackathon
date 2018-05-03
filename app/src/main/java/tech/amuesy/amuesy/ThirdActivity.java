package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ThirdActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Spinner ProfileSpinner = (Spinner) findViewById(R.id.ProfileSpinner);
        ArrayAdapter<String> adapter3_1 = new ArrayAdapter<String>(ThirdActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray((R.array.Profiles)));
        adapter3_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ProfileSpinner.setAdapter(adapter3_1);


        Spinner LevelSpinner = (Spinner) findViewById(R.id.LevelSpinner);
        ArrayAdapter<String> adapter3_2 = new ArrayAdapter<String>(ThirdActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray((R.array.Levels)));
        adapter3_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LevelSpinner.setAdapter(adapter3_2);


        Button okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }


        });




    }

    //comment

}
