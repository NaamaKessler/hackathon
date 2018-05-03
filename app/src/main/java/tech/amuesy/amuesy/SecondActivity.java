package tech.amuesy.amuesy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button firstActivityBtn = findViewById(R.id.firstActBtn);
        Button thirdActivityBtn = findViewById(R.id.thirdActBtn);

        firstActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent start1Intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(start1Intent);
            }
        });

        thirdActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent start2Intent = new Intent(getApplicationContext(),ThirdActivity.class);
                startActivity(start2Intent);
            }
        });

        String[] Museum_list2 = new String[]{"Mus1","Haifa","TLV","Jerusalem","Paris","London"};

        AutoCompleteTextView MusNameTxtp2 = findViewById(R.id.MusNameTxtp2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, Museum_list2);
        MusNameTxtp2.setAdapter(adapter2);




    }
}
