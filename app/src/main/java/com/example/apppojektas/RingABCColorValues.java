package com.example.apppojektas;

import java.util.ArrayList;

public class RingABCColorValues {
    public static final int BLACK = 0;
    public static final int BROWN = 1;
    public static final int RED = 2;
    public static final int ORANGE = 3;
    public static final int YELLOW = 4;
    public static final int GREEN = 5;
    public static final int BLUE = 6;
    public static final int VIOLET = 7;
    public static final int GRAY = 8;
    public static final int WHITE = 9;

    private ArrayList<Integer> labelValuesAbc;

    public RingABCColorValues() {
        labelValuesAbc = new ArrayList<>(10); // Initialize ArrayList with fixed size
        labelValuesAbc.add(BLACK);
        labelValuesAbc.add(BROWN);
        labelValuesAbc.add(RED);
        labelValuesAbc.add(ORANGE);
        labelValuesAbc.add(YELLOW);
        labelValuesAbc.add(GREEN);
        labelValuesAbc.add(BLUE);
        labelValuesAbc.add(VIOLET);
        labelValuesAbc.add(GRAY);
        labelValuesAbc.add(WHITE);
    }

    public int getValueOfABCPosition(int position) {
        return labelValuesAbc.get(position);
    }
}
