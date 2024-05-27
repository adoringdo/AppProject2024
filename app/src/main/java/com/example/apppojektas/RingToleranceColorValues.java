package com.example.apppojektas;

import java.util.ArrayList;

public class RingToleranceColorValues {
    private static final String SILVER_TOLERANCE = "10%";
    private static final String GOLD_TOLERANCE = "5%";
    private static final String BROWN_TOLERANCE = "1%";
    private static final String RED_TOLERANCE = "2%";
    private static final String GREEN_TOLERANCE = "0.5%";
    private static final String BLUE_TOLERANCE = "0.25%";
    private static final String VIOLET_TOLERANCE = "0.1%";
    private static final String GRAY_TOLERANCE = "0.05%";

    private final ArrayList<String> labelValuesTolerance = new ArrayList<>();

    public RingToleranceColorValues() {
        labelValuesTolerance.add(SILVER_TOLERANCE);
        labelValuesTolerance.add(GOLD_TOLERANCE);
        labelValuesTolerance.add(BROWN_TOLERANCE);
        labelValuesTolerance.add(RED_TOLERANCE);
        labelValuesTolerance.add(GREEN_TOLERANCE);
        labelValuesTolerance.add(BLUE_TOLERANCE);
        labelValuesTolerance.add(VIOLET_TOLERANCE);
        labelValuesTolerance.add(GRAY_TOLERANCE);
    }

    public String getValueByPosition(int position){
        return labelValuesTolerance.get(position);
    }
}
