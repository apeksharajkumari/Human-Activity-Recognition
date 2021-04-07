package com.example.accelerometer_data;


import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import java.io.File;
import java.lang.String;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Accelerometer_Data extends MainActivity implements SensorEventListener { private float lastX, lastY, lastZ;

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private float deltaX = 0;
    private float deltaY = 0;
    private float deltaZ = 0;
    private String activityName = "Push-Up"; //Change as the activity name for each activity recorded


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_accelerometer__data);


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {


            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);


        } else {
            Toast.makeText(getBaseContext(), "Data not found", Toast.LENGTH_LONG).show();
        }

    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        deltaX = event.values[0];
        deltaY = event.values[1];
        deltaZ = event.values[2];

        String entry =  activityName + "," + String.valueOf(deltaX) + "," + String.valueOf(deltaY) + "," + String.valueOf(deltaZ) + "\n";
        try {

            File sdCard = Environment.getExternalStorageDirectory();
            System.out.println(Environment.getExternalStorageDirectory());

            File file = new File(sdCard, "output.csv");
            FileOutputStream f = new FileOutputStream(file,true);

            try {
                f.write(entry.getBytes());
                f.flush();
                f.close();
                Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void stop (View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}