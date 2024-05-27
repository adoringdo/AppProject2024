package com.example.apppojektas;

import android.icu.text.DecimalFormat;

public class CalculateOhms {

    private int labelAposition;
    private int labelBposition;
    private int labelCposition;
    private int multiplierPosition;
    private int tolerancePosition;
    private int ppmPosition;
    RingABCColorValues labelABC = new RingABCColorValues();
    RingMultiplierColorValues labelD = new RingMultiplierColorValues();
    RingToleranceColorValues labelE = new RingToleranceColorValues();
    RingPPMColorValues labelF = new RingPPMColorValues();


    public CalculateOhms(int labelAposition, int labelBposition, int multiplierPosition, int tolerancePosition) {
        this.labelAposition = labelAposition;
        this.labelBposition = labelBposition;
        this.multiplierPosition = multiplierPosition;
        this.tolerancePosition = tolerancePosition;
    }

    public CalculateOhms(int labelAposition, int labelBposition, int labelCposition, int multiplierPosition, int tolerancePosition) {
        this.labelAposition = labelAposition;
        this.labelBposition = labelBposition;
        this.labelCposition = labelCposition;
        this.multiplierPosition = multiplierPosition;
        this.tolerancePosition = tolerancePosition;
    }

    public CalculateOhms(int labelAposition, int labelBposition, int labelCposition, int multiplierPosition, int tolerancePosition, int ppmPosition) {
        this.labelAposition = labelAposition;
        this.labelBposition = labelBposition;
        this.labelCposition = labelCposition;
        this.multiplierPosition = multiplierPosition;
        this.tolerancePosition = tolerancePosition;
        this.ppmPosition = ppmPosition;
    }

    public String calculateFourRings() {
        double result = ((labelABC.getValueByPosition(labelAposition) * 10) + (labelABC.getValueByPosition(labelBposition)) * labelD.getValueByPosition(multiplierPosition));
        String prettifiedResult = prettifyCalculationsResult(result);
        return prettifiedResult + " " + labelE.getValueByPosition(tolerancePosition);
    }

    public String calculateFiveRings() {
        double result = (((labelABC.getValueByPosition(labelAposition) * 100) + labelABC.getValueByPosition(labelBposition) * 10) + labelABC.getValueByPosition(labelCposition)) * labelD.getValueByPosition(multiplierPosition);
        String prettifiedResult = prettifyCalculationsResult(result);
        return prettifiedResult + " " + labelE.getValueByPosition(tolerancePosition);
    }

    public String calculateSixRings() {
        double result = (((labelABC.getValueByPosition(labelAposition) * 100) + labelABC.getValueByPosition(labelBposition) * 10) + labelABC.getValueByPosition(labelCposition)) * labelD.getValueByPosition(multiplierPosition);
        String prettifiedResult = prettifyCalculationsResult(result);
        return prettifiedResult + " " + labelE.getValueByPosition(tolerancePosition) + " " + labelF.getValueByPosition(ppmPosition);
    }
    private String prettifyCalculationsResult(double power) {
        int precision = 2;
        String nFormat;
        String suffix;

        if (power < 999) {
            nFormat = formatNumber(power, precision);
            suffix = "";
        } else if (power < 999999) {
            nFormat = formatNumber(power / 1000, precision);
            suffix = "K";
        } else if (power < 999999999) {
            nFormat = formatNumber(power / 1000000, precision);
            suffix = "M";
        } else {
            nFormat = formatNumber(power / 1000000000, precision);
            suffix = "G";
        }
        // Remove trailing zeros and unnecessary decimal points
        nFormat = stripTrailingZeros(nFormat, precision);

        return nFormat + suffix + " Ohms";
    }

    private static String formatNumber(double value, int precision) {
        StringBuilder pattern = new StringBuilder("0");
        if (precision > 0) {
            pattern.append(".");
            for (int i = 0; i < precision; i++) {
                pattern.append("0");
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat(pattern.toString());
        return decimalFormat.format(value);
    }

    private static String stripTrailingZeros(String number, int precision) {
        if (precision > 0 && number.contains(".")) {
            int dotIndex = number.indexOf('.');
            int endIndex = number.length() - 1;
            while (endIndex > dotIndex && number.charAt(endIndex) == '0') {
                endIndex--;
            }
            if (number.charAt(endIndex) == '.') {
                endIndex--;
            }
            number = number.substring(0, endIndex + 1);
        }
        return number;
    }
}
