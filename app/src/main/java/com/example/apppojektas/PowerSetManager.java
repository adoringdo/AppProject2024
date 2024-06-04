package com.example.apppojektas;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PowerSetManager {
    private static final String PREF_NAME = "PowerSetsPrefs";
    private static final String SET_KEY_PREFIX = "PowerSet_";
    private SharedPreferences sharedPreferences;

    public PowerSetManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void savePowerSet(PowerSet powerSet) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String key = SET_KEY_PREFIX + powerSet.getName();
        editor.putString(key + "_power", powerSet.getPower());
        editor.putString(key + "_date", powerSet.getDate());
        editor.putString(key + "_colors", Utils.listToJson(powerSet.getColors()));
        editor.apply();
    }

    public List<PowerSet> getAllPowerSets() {
        Map<String, ?> allEntries = sharedPreferences.getAll();
        List<PowerSet> powerSets = new ArrayList<>();
        for (String key : allEntries.keySet()) {
            if (key.startsWith(SET_KEY_PREFIX) && key.endsWith("_power")) {
                String name = key.substring(SET_KEY_PREFIX.length(), key.length() - "_power".length());
                String power = sharedPreferences.getString(key, "");
                String date = sharedPreferences.getString(SET_KEY_PREFIX + name + "_date", "");
                List<String> colors = Utils.jsonToList(sharedPreferences.getString(SET_KEY_PREFIX + name + "_colors", "[]"));
                powerSets.add(new PowerSet(name, power, date, colors));
            }
        }
        return powerSets;
    }

    public void deletePowerSet(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(SET_KEY_PREFIX + name + "_power");
        editor.remove(SET_KEY_PREFIX + name + "_date");
        editor.remove(SET_KEY_PREFIX + name + "_colors");
        editor.apply();
    }
}