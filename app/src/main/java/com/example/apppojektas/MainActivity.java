package com.example.apppojektas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener{

//Spinners
    private CustomSpinner spinner_colors_A;
    private CustomSpinner spinner_colors_B;
    private CustomSpinner spinner_colors_C;
    private CustomSpinner spinner_colors_D;
    private CustomSpinner spinner_colors_E;
    private CustomSpinner spinner_colors_PPM;

//Adapters
    private ColorAdapter adapterABC;
    private ColorAdapter adapterD;
    private ColorAdapter adapterE;
    private ColorAdapter adapterPPM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    //Select A color
        spinner_colors_A = findViewById(R.id.spinner_colors_A);

        spinner_colors_A.setSpinnerEventsListener(this);

        adapterABC = new ColorAdapter(MainActivity.this, Data.getColorListABC());
        spinner_colors_A.setAdapter(adapterABC);


    //Select B color
        spinner_colors_B = findViewById(R.id.spinner_colors_B);

        spinner_colors_B.setSpinnerEventsListener(this);


        spinner_colors_B.setAdapter(adapterABC);


    //Select C color
        spinner_colors_C = findViewById(R.id.spinner_colors_C);

        spinner_colors_C.setSpinnerEventsListener(this);

        spinner_colors_C.setAdapter(adapterABC);


    //Select D color
        spinner_colors_D = findViewById(R.id.spinner_colors_D);

        spinner_colors_D.setSpinnerEventsListener(this);

        adapterD = new ColorAdapter(MainActivity.this, Data.getColorListD());
        spinner_colors_D.setAdapter(adapterD);


    //Select E color
        spinner_colors_E = findViewById(R.id.spinner_colors_E);

        spinner_colors_E.setSpinnerEventsListener(this);

        adapterE = new ColorAdapter(MainActivity.this, Data.getColorListE());
        spinner_colors_E.setAdapter(adapterE);


    //Select PPM color
        spinner_colors_PPM = findViewById(R.id.spinner_colors_PPM);

        spinner_colors_PPM.setSpinnerEventsListener(this);

        adapterPPM = new ColorAdapter(MainActivity.this, Data.getColorListPPM());
        spinner_colors_PPM.setAdapter(adapterPPM);


    }

    @Override
    public void onPopupWindowOpened(Spinner spinner) {

    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {

    }
}