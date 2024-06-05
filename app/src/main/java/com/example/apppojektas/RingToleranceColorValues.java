package com.example.apppojektas;

import java.util.ArrayList;

public class RingToleranceColorValues {
    public static final String BROWN_TOLERANCE = "1%";
    public static final String RED_TOLERANCE = "2%";
    public static final String ORANGE_TOLERANCE = "3%";
    public static final String YELLOW_TOLERANCE = "4%";
    public static final String GREEN_TOLERANCE = "0.5%";
    public static final String BLUE_TOLERANCE = "0.25%";
    public static final String VIOLET_TOLERANCE = "0.1%";
    public static final String GRAY_TOLERANCE = "0.05%";
    public static final String GOLD_TOLERANCE = "5%";
    public static final String SILVER_TOLERANCE = "10%";

    private ArrayList<String> labelValuesTolerance;

    public RingToleranceColorValues() {
        labelValuesTolerance = new ArrayList<>(10); // Initialize ArrayList with fixed size
        labelValuesTolerance.add(BROWN_TOLERANCE);
        labelValuesTolerance.add(RED_TOLERANCE);
        labelValuesTolerance.add(ORANGE_TOLERANCE);
        labelValuesTolerance.add(YELLOW_TOLERANCE);
        labelValuesTolerance.add(GREEN_TOLERANCE);
        labelValuesTolerance.add(BLUE_TOLERANCE);
        labelValuesTolerance.add(VIOLET_TOLERANCE);
        labelValuesTolerance.add(GRAY_TOLERANCE);
        labelValuesTolerance.add(GOLD_TOLERANCE);
        labelValuesTolerance.add(SILVER_TOLERANCE);
    }

    public String getValueOfToleranceByPosition(int position) {
        return labelValuesTolerance.get(position);
    }
}
