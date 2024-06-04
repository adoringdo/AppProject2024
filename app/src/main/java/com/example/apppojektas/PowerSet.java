package com.example.apppojektas;

import java.util.List;

public class PowerSet {
    private String name;
    private String power;
    private String date;
    private List<String> colors;

    public PowerSet(String name, String power, String date, List<String> colors) {
        this.name = name;
        this.power = power;
        this.date = date;
        this.colors = colors;
    }

    // Getters and setters for the fields
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPower() { return power; }
    public void setPower(String power) { this.power = power; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public List<String> getColors() { return colors; }
    public void setColors(List<String> colors) { this.colors = colors; }
}