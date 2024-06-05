package com.example.apppojektas;

import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
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

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        displayPowerSets();
    }

    private void displayPowerSets() {
        powerSetContainer.removeAllViews();
        List<PowerSet> powerSets = powerSetManager.getAllPowerSets();
        // Reverse the list to display the newest sets on top
        Collections.reverse(powerSets);

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

                // Create the color drawable
                ColorDrawable colorDrawable = new ColorDrawable(android.graphics.Color.parseColor(color.trim()));

                // Create the border drawable
                ShapeDrawable borderDrawable = new ShapeDrawable(new RectShape());
                borderDrawable.getPaint().setColor(android.graphics.Color.BLACK);
                borderDrawable.getPaint().setStyle(Paint.Style.STROKE);
                borderDrawable.getPaint().setStrokeWidth(4); // Set the border width

                // Create a LayerDrawable that combines both drawables
                Drawable[] layers = {colorDrawable, borderDrawable};
                LayerDrawable layerDrawable = new LayerDrawable(layers);
                // Adjust the border padding to fit within the view bounds
                layerDrawable.setLayerInset(1, 0, 0, 0, 0);

                // Set the LayerDrawable as the background of the colorView
                colorView.setBackground(layerDrawable);

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
    }}
