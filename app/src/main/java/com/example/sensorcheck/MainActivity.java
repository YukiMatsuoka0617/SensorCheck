package com.example.sensorcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SensorManager mSensorManager;
    TextView textView;

    private int[] sensorList = {
            Sensor.TYPE_ACCELEROMETER,
            Sensor.TYPE_ACCELEROMETER_UNCALIBRATED,
            Sensor.TYPE_AMBIENT_TEMPERATURE,
            Sensor.TYPE_DEVICE_PRIVATE_BASE,
            Sensor.TYPE_GAME_ROTATION_VECTOR,
            //
            Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,
            Sensor.TYPE_GRAVITY,
            Sensor.TYPE_GYROSCOPE,
            Sensor.TYPE_GYROSCOPE_UNCALIBRATED,
            Sensor.TYPE_HEART_BEAT,
            //
            Sensor.TYPE_HEART_RATE,
            Sensor.TYPE_LIGHT,
            Sensor.TYPE_LINEAR_ACCELERATION,
            Sensor.TYPE_LOW_LATENCY_OFFBODY_DETECT,
            Sensor.TYPE_MAGNETIC_FIELD,
            //
            Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED,
            Sensor.TYPE_MOTION_DETECT,
            Sensor.TYPE_POSE_6DOF,
            Sensor.TYPE_PRESSURE,
            Sensor.TYPE_PROXIMITY,
            //
            Sensor.TYPE_RELATIVE_HUMIDITY,
            Sensor.TYPE_ROTATION_VECTOR,
            Sensor.TYPE_SIGNIFICANT_MOTION,
            Sensor.TYPE_STATIONARY_DETECT,
            Sensor.TYPE_STEP_COUNTER,
            //
            Sensor.TYPE_STEP_DETECTOR
    };

    private String[] sensorNameList = {
            "ACCELEROMETER",
            "ACCELEROMETER_UNCALIBRATED",
            "AMBIENT_TEMPERATURE",
            "DEVICE_PRIVATE_BASE",
            "GAME_ROTATION_VECTOR",
            //
            "GEOMAGNETIC_ROTATION_VECTOR",
            "GRAVITY",
            "GYROSCOPE",
            "GYROSCOPE_UNCALIBRATED",
            "HEART_BEAT",
            //
            "HEART_RATE",
            "LIGHT",
            "LINEAR_ACCELERATION",
            "LOW_LATENCY_OFFBODY_DETECT",
            "MAGNETIC_FIELD",
            //
            "MAGNETIC_FIELD_UNCALIBRATED",
            "MOTION_DETECT",
            "POSE_6DOF",
            "PRESSURE",
            "PROXIMITY",
            //
            "RELATIVE_HUMIDITY",
            "ROTATION_VECTOR",
            "SIGNIFICANT_MOTION",
            "STATIONARY_DETECT",
            "STEP_COUNTER",
            //
            "STEP_DETECTOR",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        textView = findViewById(R.id.text_view);
        checkSensors();
    }

    private void checkSensors() {
        StringBuffer strbuf = new StringBuffer("Sensor List:\n\n");

        for (int i = 0; i < sensorList.length; i++) {
            Sensor sensor = mSensorManager.getDefaultSensor(sensorList[i]);

            if (sensor != null) {
                String strTmp = String.format("%s: %s: 使用可能\n",
                        String.valueOf(i + 1), sensorNameList[i]);
                strbuf.append(strTmp);
            } else {
                String strTmp = String.format("%s: %s: XXX 不可\n",
                        String.valueOf(i + 1), sensorNameList[i]);
                strbuf.append(strTmp);
            }
        }
        textView.setText(strbuf);
    }
}

