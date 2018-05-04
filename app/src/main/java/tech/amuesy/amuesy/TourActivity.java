package tech.amuesy.amuesy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TourActivity extends AppCompatActivity {
    TextView instructionView;

//    ArrayList<Item> tour = //todo:how do I get the tour?
    private Item currentItem;
    private int itemNum;

    //get user's info:
    SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
    final String profile = sharedPref.getString("profile_info", "Adult");
    final String level = sharedPref.getString("level_info", "Intermediate"); //todo: I don't use that yet

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        Button hitmeBtn = findViewById(R.id.hitmeBtn);
        hitmeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = currentItem.presentItem(profile);
            }
        });
    }

    public void setInstructionView(){
        instructionView = (TextView)findViewById(R.id.instructionsView);
        instructionView.setText(currentItem.presentItem(profile));
    }
}
