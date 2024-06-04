package com.example.apppojektas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener {


    // Adapters
    private ColorAdapter adapterABC;
    private ColorAdapter adapterD;
    private ColorAdapter adapterE;
    private ColorAdapter adapterPPM;
    private Button calculateButton;
    private TextView powerText;
    private RadioGroup radio;

    private int labelA;
    private int labelB;
    private int labelC;
    private int labelD;
    private int radioIndex;
    private int labelE;
    private int labelPPM;

    // Rings on img

    ChangeRingColor setAllRingColors = new ChangeRingColor();

    private PowerSetManager powerSetManager;

    public void setRadioIndex(int index) {
        this.radioIndex = index;
    }

    public int getRadioIndex() {
        return radioIndex;
    }

    public int getLabelE() {
        return labelE;
    }

    public void setLabelE(int labelE) {
        this.labelE = labelE;
    }

    public int getLabelD() {
        return labelD;
    }

    public void setLabelD(int labelD) {
        this.labelD = labelD;
    }

    public int getLabelPPM() {
        return labelPPM;
    }

    public void setLabelPPM(int labelPPM) {
        this.labelPPM = labelPPM;
    }

    public int getLabelA() {
        return labelA;
    }

    public void setLabelA(int labelA) {
        this.labelA = labelA;
    }

    public int getLabelB() {
        return labelB;
    }

    public void setLabelB(int labelB) {
        this.labelB = labelB;
    }

    public int getLabelC() {
        return labelC;
    }

    public void setLabelC(int labelC) {
        this.labelC = labelC;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        powerSetManager = new PowerSetManager(this);


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button historyButton = findViewById(R.id.historyBtn);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        calculateButton = findViewById(R.id.calculateBtn);
        radio = findViewById(R.id.radioGroup);


        View ringA = findViewById(R.id.ringA);
        View ringB = findViewById(R.id.ringB);
        View ringC = findViewById(R.id.ringC);
        View ringD = findViewById(R.id.ringD);
        View ringE = findViewById(R.id.ringE);
        View ringPPM = findViewById(R.id.ringPPM);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getRadioIndex() == 0) {
                    CalculateOhms resistor = new CalculateOhms(getLabelA(), getLabelB(), getLabelD(), getLabelE());
                    String result = resistor.calculateFourRings();
                    powerText = findViewById(R.id.powerText);
                    powerText.setText(result);
                } else if (getRadioIndex() == 1) {
                    CalculateOhms resistor = new CalculateOhms(getLabelA(), getLabelB(), getLabelC(), getLabelD(), getLabelE());
                    String result = resistor.calculateFiveRings();
                    powerText = findViewById(R.id.powerText);
                    powerText.setText(result);
                } else if (getRadioIndex() == 2) {
                    CalculateOhms resistor = new CalculateOhms(getLabelA(), getLabelB(), getLabelC(), getLabelD(), getLabelE(), getLabelPPM());
                    String result = resistor.calculateSixRings();
                    powerText = findViewById(R.id.powerText);
                    powerText.setText(result);
                }

                // Add the code to add a power set
                String power = powerText.getText().toString();
                String name = generateUniqueName();
                String date = getCurrentDateTime();
                List<String> colors = new ArrayList<>();

                if (findViewById(R.id.ringA).getVisibility() == View.VISIBLE) {
                    colors.add("#" + Integer.toHexString(((ColorDrawable) ringA.getBackground()).getColor()).substring(2));
                }
                if (findViewById(R.id.ringB).getVisibility() == View.VISIBLE) {
                    colors.add("#" + Integer.toHexString(((ColorDrawable) ringB.getBackground()).getColor()).substring(2));
                }
                if (findViewById(R.id.ringC).getVisibility() == View.VISIBLE) {
                    colors.add("#" + Integer.toHexString(((ColorDrawable) ringC.getBackground()).getColor()).substring(2));
                }
                if (findViewById(R.id.ringD).getVisibility() == View.VISIBLE) {
                    colors.add("#" + Integer.toHexString(((ColorDrawable) ringD.getBackground()).getColor()).substring(2));
                }
                if (findViewById(R.id.ringE).getVisibility() == View.VISIBLE) {
                    colors.add("#" + Integer.toHexString(((ColorDrawable) ringE.getBackground()).getColor()).substring(2));
                }
                if (findViewById(R.id.ringPPM).getVisibility() == View.VISIBLE) {
                    colors.add("#" + Integer.toHexString(((ColorDrawable) ringPPM.getBackground()).getColor()).substring(2));
                }


                PowerSet powerSet = new PowerSet(name, power, date, colors);
                powerSetManager.savePowerSet(powerSet);
                Toast.makeText(MainActivity.this, "Power set added successfully!", Toast.LENGTH_SHORT).show();


            }
        });


    historyButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, HistoryActivity.class));

        }
    });



        // Radio button functionality
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // Layout names to change visibility
            final LinearLayout linearLayoutA = findViewById(R.id.selectALayout);
            final LinearLayout linearLayoutB = findViewById(R.id.selectBLayout);
            final LinearLayout linearLayoutC = findViewById(R.id.selectCLayout);
            final LinearLayout linearLayoutD = findViewById(R.id.selectDLayout);
            final LinearLayout linearLayoutE = findViewById(R.id.selectELayout);
            final LinearLayout linearLayoutPPM = findViewById(R.id.selectPPMLayout);

            // Change layout visibility depending on selected radio button
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radio.findViewById(checkedId);
                int index = radio.indexOfChild(radioButton);
                if (index == 0) {
                    linearLayoutA.setVisibility(View.VISIBLE);
                    linearLayoutB.setVisibility(View.VISIBLE);
                    linearLayoutC.setVisibility(View.GONE);
                    linearLayoutD.setVisibility(View.VISIBLE);
                    linearLayoutE.setVisibility(View.VISIBLE);
                    linearLayoutPPM.setVisibility(View.GONE);
                    ringC.setVisibility(View.INVISIBLE);
                    ringPPM.setVisibility(View.INVISIBLE);
                    setRadioIndex(index);
                } else if (index == 1) {
                    linearLayoutA.setVisibility(View.VISIBLE);
                    linearLayoutB.setVisibility(View.VISIBLE);
                    linearLayoutC.setVisibility(View.VISIBLE);
                    linearLayoutD.setVisibility(View.VISIBLE);
                    linearLayoutE.setVisibility(View.VISIBLE);
                    linearLayoutPPM.setVisibility(View.GONE);
                    ringC.setVisibility(View.VISIBLE);
                    ringPPM.setVisibility(View.INVISIBLE);
                    setRadioIndex(index);
                } else if (index == 2) {
                    linearLayoutA.setVisibility(View.VISIBLE);
                    linearLayoutB.setVisibility(View.VISIBLE);
                    linearLayoutC.setVisibility(View.VISIBLE);
                    linearLayoutD.setVisibility(View.VISIBLE);
                    linearLayoutE.setVisibility(View.VISIBLE);
                    linearLayoutPPM.setVisibility(View.VISIBLE);
                    ringC.setVisibility(View.VISIBLE);
                    ringPPM.setVisibility(View.VISIBLE);
                    setRadioIndex(index);
                }
            }
        });

        // Select A color
        CustomSpinner spinner_colors_A = findViewById(R.id.spinner_colors_A);
        spinner_colors_A.setSpinnerEventsListener(this);
        adapterABC = new ColorAdapter(MainActivity.this, Data.getColorListABC());
        spinner_colors_A.setAdapter(adapterABC);




        spinner_colors_A.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Colors colors = new Colors();
                Log.d("MainActivity", "on item clicked: " + adapterABC.getItem(position));
                setLabelA(adapterABC.getItem(position));
                setAllRingColors.ChangeRingABCColor(getLabelA(), ringA);
                Log.d("indexIS", "index: " + getLabelA());
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Select B color
        CustomSpinner spinner_colors_B = findViewById(R.id.spinner_colors_B);
        spinner_colors_B.setSpinnerEventsListener(this);
        spinner_colors_B.setAdapter(adapterABC);
        spinner_colors_B.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "on item clicked: " + adapterABC.getItem(position));
                setLabelB(adapterABC.getItem(position));
                setAllRingColors.ChangeRingABCColor(getLabelB(), ringB);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Select C color
        CustomSpinner spinner_colors_C = findViewById(R.id.spinner_colors_C);
        spinner_colors_C.setSpinnerEventsListener(this);
        spinner_colors_C.setAdapter(adapterABC);
        spinner_colors_C.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "on item clicked: " + adapterABC.getItem(position));
                setLabelC(adapterABC.getItem(position));
                setAllRingColors.ChangeRingABCColor(getLabelC(), ringC);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Select D color
        CustomSpinner spinner_colors_D = findViewById(R.id.spinner_colors_D);
        spinner_colors_D.setSpinnerEventsListener(this);
        adapterD = new ColorAdapter(MainActivity.this, Data.getColorListD());
        spinner_colors_D.setAdapter(adapterD);
        spinner_colors_D.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "on item clicked: " + adapterD.getItem(position));
                setLabelD(adapterD.getItem(position));
                setAllRingColors.ChangeRingDColor(getLabelD(), ringD);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Select E color
        CustomSpinner spinner_colors_E = findViewById(R.id.spinner_colors_E);
        spinner_colors_E.setSpinnerEventsListener(this);
        adapterE = new ColorAdapter(MainActivity.this, Data.getColorListE());
        spinner_colors_E.setAdapter(adapterE);
        spinner_colors_E.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "on item clicked: " + adapterE.getItem(position));
                setLabelE(adapterE.getItem(position));
                setAllRingColors.ChangeRingEColor(getLabelE(), ringE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Select PPM color
        CustomSpinner spinner_colors_PPM = findViewById(R.id.spinner_colors_PPM);
        spinner_colors_PPM.setSpinnerEventsListener(this);
        adapterPPM = new ColorAdapter(MainActivity.this, Data.getColorListPPM());
        spinner_colors_PPM.setAdapter(adapterPPM);
        spinner_colors_PPM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "on item clicked: " + adapterPPM.getItem(position));
                setLabelPPM(adapterPPM.getItem(position));
                setAllRingColors.ChangeRingPPMColor(getLabelPPM(), ringPPM);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Ring color change functionality



    }


    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    private String generateUniqueName() {
        return "PowerSet_" + System.currentTimeMillis(); // Using current timestamp as a unique identifier
    }


    @Override
    public void onPopupWindowOpened(Spinner spinner) {

    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {

    }
}
