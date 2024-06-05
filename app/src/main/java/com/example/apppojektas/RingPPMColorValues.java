package com.example.apppojektas;

import java.util.ArrayList;

public class RingPPMColorValues {
    public static final String BLACK_PPM = "250 ppm";
    public static final String BROWN_PPM = "100 ppm";
    public static final String RED_PPM = "50 ppm";
    public static final String ORANGE_PPM = "15 ppm";
    public static final String YELLOW_PPM = "25 ppm";
    public static final String GREEN_PPM = "20 ppm";
    public static final String BLUE_PPM = "10 ppm";
    public static final String VIOLET_PPM = "5 ppm";
    public static final String GREY_PPM = "1 ppm";

    private ArrayList<String> labelValuesPpm;

    public RingPPMColorValues() {
        labelValuesPpm = new ArrayList<>(9); // Initialize ArrayList with fixed size
        labelValuesPpm.add(BLACK_PPM);
        labelValuesPpm.add(BROWN_PPM);
        labelValuesPpm.add(RED_PPM);
        labelValuesPpm.add(ORANGE_PPM);
        labelValuesPpm.add(YELLOW_PPM);
        labelValuesPpm.add(GREEN_PPM);
        labelValuesPpm.add(BLUE_PPM);
        labelValuesPpm.add(VIOLET_PPM);
        labelValuesPpm.add(GREY_PPM);
    }

    public String getValueOfPPMByPosition(int position) {
        return labelValuesPpm.get(position);
    }
}