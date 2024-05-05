package com.example.apppojektas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

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

        //Label A select
        Spinner spinnerLabelA=findViewById(R.id.labelASelect);
        ArrayAdapter<CharSequence>adapterABC=ArrayAdapter.createFromResource(this, R.array.labelABC_list, R.layout.spinner_layout_style);
        adapterABC.setDropDownViewResource(R.layout.spinner_dropdown_style);
        spinnerLabelA.setAdapter(adapterABC);

        //Label B select
        Spinner spinnerLabelB=findViewById(R.id.labelBSelect);
        //ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.labelABC_list, android.R.layout.simple_spinner_item);
        adapterABC.setDropDownViewResource(R.layout.spinner_dropdown_style);
        spinnerLabelB.setAdapter(adapterABC);

        //Label C select
        Spinner spinnerLabelC=findViewById(R.id.labelCSelect);
        //ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.labelABC_list, android.R.layout.simple_spinner_item);
        adapterABC.setDropDownViewResource(R.layout.spinner_dropdown_style);
        spinnerLabelC.setAdapter(adapterABC);

        //Label D select
        Spinner spinnerLabelD=findViewById(R.id.labelDSelect);
        ArrayAdapter<CharSequence>adapterD=ArrayAdapter.createFromResource(this, R.array.labelD_list, R.layout.spinner_layout_style);
        adapterD.setDropDownViewResource(R.layout.spinner_dropdown_style);
        spinnerLabelD.setAdapter(adapterD);

        //Label E select
        Spinner spinnerLabelE=findViewById(R.id.labelESelect);
        ArrayAdapter<CharSequence>adapterE=ArrayAdapter.createFromResource(this, R.array.labelE_list, R.layout.spinner_layout_style);
        adapterE.setDropDownViewResource(R.layout.spinner_dropdown_style);
        spinnerLabelE.setAdapter(adapterE);

        //Label PPM select
        Spinner spinnerLabelPpm=findViewById(R.id.labelPpmSelect);
        ArrayAdapter<CharSequence>adapterPpm=ArrayAdapter.createFromResource(this, R.array.labelPpm_list, R.layout.spinner_layout_style);
        adapterPpm.setDropDownViewResource(R.layout.spinner_dropdown_style);
        spinnerLabelPpm.setAdapter(adapterPpm);


    }
}