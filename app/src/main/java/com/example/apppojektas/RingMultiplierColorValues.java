package com.example.apppojektas;

import java.util.ArrayList;

public class RingMultiplierColorValues {

    private static final double SILVER_VALUE = 0.01;
    private static final double GOLD_VALUE = 0.1;
    private static final double BLACK_VALUE = 1;
    private static final double BROWN_VALUE = 10;
    private static final double RED_VALUE = 100;
    private static final double ORANGE_VALUE = 1000;
    private static final double YELLOW_VALUE = 10000;
    private static final double GREEN_VALUE = 100000;
    private static final double BLUE_VALUE = 1000000;
    private static final double VIOLET_VALUE = 10000000;
    private static final double GRAY_VALUE = 100000000;
    private static final double WHITE_VALUE = 1000000000;

    ArrayList<Double> labelValuesMultiplier = new ArrayList<>();

    public RingMultiplierColorValues() {

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
    public double getValueByPosition(int position){
        return labelValuesMultiplier.get(position);
    }
}
