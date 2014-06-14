package com.example.taschenrechner.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Memory {

	private static String SHARED_PREFERENCES_FILE = "MemoryFile";
	private Context context;
	SharedPreferences settings;

	float m1, m2, m3, m4;
	public static String M1 = "m1", M2 = "m2", M3 = "m3", M4 = "m4";

	public Memory(Context context) {
		this.context = context;
		loadPreferences();
	}

	public void loadPreferences() {
		// Restore preferences
		settings = context.getSharedPreferences(SHARED_PREFERENCES_FILE, 0);
		setM1(settings.getFloat("memorystorage1", Float.NaN));
		setM2(settings.getFloat("memorystorage2", Float.NaN));
		setM3(settings.getFloat("memorystorage3", Float.NaN));
		setM4(settings.getFloat("memorystorage4", Float.NaN));
	}

	public void savePreferences() {
		SharedPreferences settings = context.getSharedPreferences(
				SHARED_PREFERENCES_FILE, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putFloat("memorystorage1", m1);
		editor.putFloat("memorystorage2", m2);
		editor.putFloat("memorystorage3", m3);
		editor.putFloat("memorystorage4", m4);
		editor.commit();
	}

	public float getM1() {
		return m1;
	}

	public String handleSaving(String buttonKey, String input) {
		String returnValue = "";
		float buttonValue;

		if (buttonKey == M1) {
			buttonValue = m1;
		} else if (buttonKey == M2) {
			buttonValue = m2;
		} else if (buttonKey == M3) {
			buttonValue = m3;
		} else {
			buttonValue = m4;
		}

		loadPreferences();

		if (input.equals("")) {

			if (buttonValue != Float.NaN) {
				returnValue = input + buttonValue;
			}

		} else {
			if (input.contains(String.valueOf(Float.NaN))
					|| input.contains("ERROR")) {
				returnValue = "ERROR";
			} else {

				if (buttonKey.equals(M1)) {
					setM1(Float.parseFloat(input));
				} else if (buttonKey.equals(M2)) {
					setM2(Float.parseFloat(input));
				} else if (buttonKey.equals(M3)) {
					setM3(Float.parseFloat(input));
					savePreferences();

				} else if (buttonKey.equals(M4)) {
					setM4(Float.parseFloat(input));
					savePreferences();

				}
				returnValue = input;

			}
		}

		return returnValue;
	}

	public float getM2() {
		return m2;
	}

	public void setM2(float m2) {
		this.m2 = m2;
	}

	public float getM3() {
		return m3;
	}

	public void setM3(float m3) {
		this.m3 = m3;
	}

	public float getM4() {
		return m4;
	}

	public void setM4(float m4) {
		this.m4 = m4;
	}

	public void setM1(float m1) {
		this.m1 = m1;
	}

}
