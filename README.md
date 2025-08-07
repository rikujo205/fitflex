# FITFLEX 

Fitflex is a workout app that is designed to help users who are new to the gym environment. By providing images of the human body with the target area shown in red, for visualization on exactly what techniques and equipment to use for certain body area. Come join us in this community and  help each other to build a healthy body!

## Why Build This?

As college students, we understand how hard it is to manage work, classes and sleep. We know first hand that anything else can become difficult to find time for and we know that stress and lack of sleep can cause one to become unhealthy. It is with these things in mind that we created this app. It is not here to take any more time than the time that it takes to do the workout and with what little time you may have, minutes can add up FAST. With all of these things in mind and the motivational drive to excersise, we do not want you to become unmotivated by complex routines and tasks. Simply get in there, load the app, complete the workout and go!

## Build Status

Currently the app is still under development and some features have either not been added or are not functioning properly yet but everything listed in functionality should be working.

## Contributors 

- Angel Nguyen 

- Harvey Brunner 

- Dalton Reed 

- Guillermo Torralva 

## Video Demonstration

[FitFlex Demo](https://youtu.be/xX2xz4yYsKY)
 
## Installation 

To run FitFlex, follow these steps: 

- Clone this reposity and open the repository in Android Studio. 

- Create an account that will ask for what you would like your username and password to be. After setting up your account, you're ready to use the app.

- Decide on what what type of workout to do. Click on the respective choice for your workout.

- After completing the workout, click the complete button to keep track your progress. (If you accidently clicked on the complete button, you are able to undo it by using the undo button).


## Functionality 

This app has 4 core features (Select a Workout, Workout Plan and Settings).
- Workout Plan: Allows you to select a premade workout based on what group of muscles you would like to train (Core, Upper Body, Lower Body and Back).
- Settings: Allows you to select the workout difficulty of the premade workouts offered in Workout Plan.
- View Progress: Allows the user to view how many times out of 100 they finished that workout.
- Workout Plan: Allows for the user to create a workout and/or workout date that better tailors to their needs and schedule.

## Hardware, software and Coding Used

We used are currently using a "google pixel 6" emulator running through "android studios" to produce the results stated and while Java is the primary is the primary language used, we are using XML for the design layout and compiling it in android studios which can use "Kotlin" and "gratle".

## Known Issues

While there isn't any program crashing bugs in the latest release of the program, usernames and passwords are not saving, and the program cannot save progress once the app has been exited.

## How to Use

Once the app's zip file has been downloaded from github, ensure that you install "Android Studios" and upload the zip file into it (once it has been unzipped on your machine). On the right side of Android Studios you should now see a "Manage Devices" option. Select the + icon to add an emulated device and select "Google Pixel 6". Now you should be able to select the run button at the top and the app should load after 15sec-1min.

Once in the app enter a username and password (anything will work if you do not have one) and enjoy the simple self guided layout of the app!

## Code Example of AndroidManifest.XML

This code shows all the java process/activities that will run in the app.

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.FitFlex.app"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.FitFlex"
        tools:targetApi="31">

        <!-- LoginActivity is launcher -->
        <activity
            android:name="com.FitFlex.app.activities.LoginActivity"
            android:exported="true"
            android:theme="@style/Theme.FitFlex">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <!-- Other activities -->
        <activity android:name="com.FitFlex.app.activities.MainActivity" />
        <activity android:name="com.FitFlex.app.activities.SettingsActivity" />
        <activity android:name="com.FitFlex.app.activities.SuggestionActivity" />
        <activity android:name="com.FitFlex.app.activities.WorkoutPlanActivity" />
        <activity android:name=".activities.WorkoutSelectionActivity" />
        <activity android:name="com.FitFlex.app.activities.UpperBodyWorkoutActivity" />
        <activity android:name="com.FitFlex.app.activities.LowerBodyWorkoutActivity" />
        <activity android:name="com.FitFlex.app.activities.BackWorkoutActivity" />
        <activity android:name="com.FitFlex.app.activities.CoreWorkoutActivity" />
        <activity android:name="com.FitFlex.app.activities.RegisterActivity" />

    </application>
</manifest>


