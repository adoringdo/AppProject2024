package com.example.apppojektas;

import java.util.ArrayList;

public class RingMultiplierColorValues {

    public static final double SILVER_VALUE = 0.01;
    public static final double GOLD_VALUE = 0.1;
    public static final double BLACK_VALUE = 1;
    public static final double BROWN_VALUE = 10;
    public static final double RED_VALUE = 100;
    public static final double ORANGE_VALUE = 1000;
    public static final double YELLOW_VALUE = 10000;
    public static final double GREEN_VALUE = 100000;
    public static final double BLUE_VALUE = 1000000;
    public static final double VIOLET_VALUE = 10000000;
    public static final double GRAY_VALUE = 100000000;
    public static final double WHITE_VALUE = 1000000000;

    private ArrayList<Double> labelValuesMultiplier;

    public RingMultiplierColorValues() {
        labelValuesMultiplier = new ArrayList<>(12); // Initialize ArrayList with fixed size

        labelValuesMultiplier.add(SILVER_VALUE);
        labelValuesMultiplier.add(GOLD_VALUE);
        labelValuesMultiplier.add(BLACK_VALUE);
        labelValuesMultiplier.add(BROWN_VALUE);
        labelValuesMultiplier.add(RED_VALUE);
        labelValuesMultiplier.add(ORANGE_VALUE);
        labelValuesMultiplier.add(YELLOW_VALUE);
        labelValuesMultiplier.add(GREEN_VALUE);
        labelValuesMultiplier.add(BLUE_VALUE);
        labelValuesMultiplier.add(VIOLET_VALUE);
        labelValuesMultiplier.add(GRAY_VALUE);
        labelValuesMultiplier.add(WHITE_VALUE);
    }

    public double getValueOfMultiplierByPosition(int position) {
        return labelValuesMultiplier.get(position);
    }
}
