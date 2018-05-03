package tech.amuesy.amuesy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        AutoCompleteTextView MusNameTxt = findViewById(R.id.MusNameTxt);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Museum_list);
        MusNameTxt.setAdapter(adapter);
    }

    private static String[] Museum_list = new String[]{"Mus1","Haifa","TLV","Jerusalem","Paris","London"};
}
