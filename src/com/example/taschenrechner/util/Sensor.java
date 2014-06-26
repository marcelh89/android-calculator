package com.example.taschenrechner.util;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Helper class for managing Sensors like G
 * 
 * @author marcman
 * 
 */
public class Sensor extends Activity implements SensorEventListener {

	private SensorManager sManager;
	Float foreignvalue = 0f;

	@Override
	public void onAccuracyChanged(android.hardware.Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub

	}
}
