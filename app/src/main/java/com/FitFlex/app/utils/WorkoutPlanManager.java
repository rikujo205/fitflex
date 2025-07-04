package com.FitFlex.app.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;

public class WorkoutPlanManager {

    private static final String FILE_NAME = "workout_plans.json";

    // ✅ Used for full plans with a name and multiple exercises
    public static void savePlan(Context context, String name, List<String> exercises) {
        try {
            JSONArray plans = loadAllPlans(context);
            JSONObject newPlan = new JSONObject();
            newPlan.put("name", name);
            newPlan.put("exercises", new JSONArray(exercises));
            plans.put(newPlan);
            saveAllPlans(context, plans);
        } catch (Exception e) {
            Log.e("WorkoutPlanManager", "Error saving plan", e);
        }
    }

    // ✅ Used for quick saves (e.g., single input)
    public static void saveWorkout(Context context, String workout) {
        try {
            JSONArray plans = loadAllPlans(context);
            JSONObject quickPlan = new JSONObject();
            quickPlan.put("name", "Quick Save");
            quickPlan.put("exercises", new JSONArray().put(workout));
            plans.put(quickPlan);
            saveAllPlans(context, plans);
        } catch (Exception e) {
            Log.e("WorkoutPlanManager", "Error saving workout", e);
        }
    }

    public static JSONArray loadAllPlans(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            fis.close();
            return new JSONArray(builder.toString());
        } catch (Exception e) {
            return new JSONArray(); // return empty array if file not found or error
        }
    }

    public static void overwritePlans(Context context, JSONArray plans) {
        saveAllPlans(context, plans);
    }

    private static void saveAllPlans(Context context, JSONArray plans) {
        try {
            FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(plans.toString().getBytes());
            fos.close();
        } catch (Exception e) {
            Log.e("WorkoutPlanManager", "Error saving plans file", e);
        }
    }
}

