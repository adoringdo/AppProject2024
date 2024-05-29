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
    private ArrayList<String> labelValuesPPM = new ArrayList<>();

    RingPPMColorValues() {
        labelValuesPPM.add(BLACK_PPM);
        labelValuesPPM.add(BROWN_PPM);
        labelValuesPPM.add(RED_PPM);
        labelValuesPPM.add(ORANGE_PPM);
        labelValuesPPM.add(YELLOW_PPM);
        labelValuesPPM.add(GREEN_PPM);
        labelValuesPPM.add(BLUE_PPM);
        labelValuesPPM.add(VIOLET_PPM);
        labelValuesPPM.add(GREY_PPM);
    }

    public String getValueByPosition(int position) {
        return labelValuesPPM.get(position);
    }
}
