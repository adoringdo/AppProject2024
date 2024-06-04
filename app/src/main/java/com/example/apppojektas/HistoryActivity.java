package com.example.apppojektas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private PowerSetManager powerSetManager;
    private LinearLayout powerSetContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        powerSetManager = new PowerSetManager(this);
        powerSetContainer = findViewById(R.id.historyContainer);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        displayPowerSets();
    }

    private void displayPowerSets() {
        powerSetContainer.removeAllViews();
        List<PowerSet> powerSets = powerSetManager.getAllPowerSets();

        for (PowerSet powerSet : powerSets) {
            View powerSetView = getLayoutInflater().inflate(R.layout.power_set_item, null);
            TextView nameTextView = powerSetView.findViewById(R.id.nameTextView);
            TextView powerTextView = powerSetView.findViewById(R.id.powerTextView);
            TextView dateTextView = powerSetView.findViewById(R.id.dateTextView);
            LinearLayout colorsContainer = powerSetView.findViewById(R.id.colorsContainer);
            Button deleteButton = powerSetView.findViewById(R.id.deleteButton);

            nameTextView.setText(powerSet.getName());
            powerTextView.setText(powerSet.getPower());
            dateTextView.setText(powerSet.getDate());

            for (String color : powerSet.getColors()) {
                View colorView = new View(this);
                colorView.setBackgroundColor(android.graphics.Color.parseColor(color.trim()));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        getResources().getDimensionPixelSize(R.dimen.color_box_width), // Set the width of the color box
                        getResources().getDimensionPixelSize(R.dimen.color_box_height) // Set the height of the color box
                );
                params.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.color_box_margin)); // Set the margin
                colorView.setLayoutParams(params); // Set the layout parameters
                colorsContainer.addView(colorView);
            }

            deleteButton.setOnClickListener(v -> {
                powerSetManager.deletePowerSet(powerSet.getName());
                displayPowerSets();
            });

            powerSetContainer.addView(powerSetView);
        }
    }
}