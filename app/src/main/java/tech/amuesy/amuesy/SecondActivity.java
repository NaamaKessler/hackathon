package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {


    //Choose Museum Activity

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button firstActivityBtn = findViewById(R.id.firstActBtn);
        Button chooseMusBtn = findViewById(R.id.chooseMusBtn);

        //Continue's Button
        firstActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent start1Intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(start1Intent);
            }
        });




        // Enter Museum Name
        AutoCompleteTextView MusNameTxtp2 = findViewById(R.id.MusNameTxtp2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray((R.array.Museums)));
        MusNameTxtp2.setAdapter(adapter2);
        MusNameTxtp2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                name = parent.getItemAtPosition(position).toString();
            }
        });


       final String musName = MusNameTxtp2.getText().toString();



        //Back's Button
        chooseMusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent startIntent = new Intent(getApplicationContext(), InMuseumActivity.class);
                startIntent.putExtra("tech.amuesy.amuesy.musName", name);
                startActivity(startIntent);
            }
        });


    }
}