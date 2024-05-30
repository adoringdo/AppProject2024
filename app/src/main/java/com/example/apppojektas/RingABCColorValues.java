package com.example.apppojektas;

import java.util.ArrayList;

public class RingABCColorValues {
    private final int BLACK = 0;
    private final int BROWN = 1;
    private final int RED = 2;
    private final int ORANGE = 3;
    private final int YELLOW = 4;
    private final int GREEN = 5;
    private final int BLUE = 6;
    private final int VIOLET = 7;
    private final int GRAY = 8;
    private final int WHITE = 9;

    ArrayList<Integer> labelValuesABC = new ArrayList<>();

    public RingABCColorValues() {
        labelValuesABC.add(BLACK);
        labelValuesABC.add(BROWN);
        labelValuesABC.add(RED);
        labelValuesABC.add(ORANGE);
        labelValuesABC.add(YELLOW);
        labelValuesABC.add(GREEN);
        labelValuesABC.add(BLUE);
        labelValuesABC.add(VIOLET);
        labelValuesABC.add(GRAY);
        labelValuesABC.add(WHITE);
    }

    public int getValueByPosition(int position) {
        return labelValuesABC.get(position);
    }
}
