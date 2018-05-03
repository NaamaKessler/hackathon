package tech.amuesy.amuesy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ThirdActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Spinner ProfileSpinner = (Spinner) findViewById(R.id.ProfileSpinner);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(ThirdActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray((R.array.Profiles)));
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ProfileSpinner.setAdapter(adapter3);

    }

    //comment

}
