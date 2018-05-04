package tech.amuesy.amuesy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class TourActivity extends AppCompatActivity {
    TextView instructionView;

    // get tour from prev activity:
    Bundle bdl = getIntent().getExtras();
    ArrayList<Item> tour = bdl.getParcelableArrayList("tech.amuesy.amuesy.tour");
    private int itemsTotal = tour.size();
    private Item currentItem = tour.get(0);
    private int currentItemIdx = 0;

    //get user's info:
    SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
    final String profile = sharedPref.getString("profile_info", "Adult");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        //if that's the first item, upload instructions:
        instructionView = (TextView)findViewById(R.id.instructionsView);
        instructionView.setText(currentItem.getLocation());

        // "Hit Me" button:
        Button hitmeBtn = findViewById(R.id.hitmeBtn);
        hitmeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instructionView.setText(currentItem.presentItem(profile));
            }
        });

        // nextBtn button:
        Button next = findViewById(R.id.nextBtn);
        hitmeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentItemIdx < itemsTotal)
                {
                    currentItemIdx++;
                    currentItem = tour.get(currentItemIdx);
                    //Set new instructions:
                    instructionView.setText(currentItem.getLocation());
                    // increase progress bar:
                    ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
                    progressBar.incrementProgressBy(1);
                }
                else
                {
                    instructionView.setText("Congratulations, You've completed the tour!");
                }
            }
        });
    }
}
