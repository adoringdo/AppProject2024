package com.example.apppojektas;

import java.util.ArrayList;

public class RingABCColorValues {

    ArrayList<Integer> labelValuesABC = new ArrayList<>();

    public RingABCColorValues() {
        for (int value = 0; value < 9; value++) {
            labelValuesABC.add(value);
        }
    }
    public int getValueByPosition(int position){
        return labelValuesABC.get(position);
    }
}
