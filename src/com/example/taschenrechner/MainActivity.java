package com.example.taschenrechner;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private static String SHARED_PREFERENCES_FILE = "MemoryFile";

	TextView output;
	float result = 0;
	boolean setPoint = false;
	String a = "", b = "";
	String type = "";

	float m1, m2, m3, m4;
	String M1 = "m1";
	String M2 = "m2";
	String M3 = "m3";
	String M4 = "m4";

	void loadPreferences() {
		// Restore preferences
		SharedPreferences settings = getSharedPreferences(
				SHARED_PREFERENCES_FILE, 0);
		setM1(settings.getFloat("memorystorage1", Float.NaN));
		setM2(settings.getFloat("memorystorage2", Float.NaN));
		setM3(settings.getFloat("memorystorage3", Float.NaN));
		setM4(settings.getFloat("memorystorage4", Float.NaN));
	}

	void savePreferences() {
		SharedPreferences settings = getSharedPreferences(
				SHARED_PREFERENCES_FILE, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putFloat("memorystorage1", m1);
		editor.putFloat("memorystorage2", m2);
		editor.putFloat("memorystorage3", m3);
		editor.putFloat("memorystorage4", m4);
		editor.commit();
	}

	void saveButtonHandling(String buttonKey, float buttonValue, String inputAsString) {
		loadPreferences();
		
		if (inputAsString.equals("")) {

			if (buttonValue != Float.NaN) {
				output.setText(inputAsString + buttonValue);
			}

		} else {
			if (inputAsString.contains(String.valueOf(Float.NaN))) {
				output.setText("ERROR");
			} else {

				if (buttonKey.equals(M1)) {
					setM1(Float.parseFloat(inputAsString));
				} else if (buttonKey.equals(M2)) {
					setM2(Float.parseFloat(inputAsString));
				} else if (buttonKey.equals(M3)) {
					setM3(Float.parseFloat(inputAsString));
					savePreferences();

				} else if (buttonKey.equals(M4)) {
					setM4(Float.parseFloat(inputAsString));
					savePreferences();

				}

			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		loadPreferences();

		output = (TextView) this.findViewById(R.id.tv_result);
		output.setText("");

		Button buttons[] = { (Button) findViewById(R.id.buttonM1),
				(Button) findViewById(R.id.buttonM2),
				(Button) findViewById(R.id.buttonM3),
				(Button) findViewById(R.id.buttonM4),
				(Button) findViewById(R.id.button1),
				(Button) findViewById(R.id.button2),
				(Button) findViewById(R.id.button3),
				(Button) findViewById(R.id.button3),
				(Button) findViewById(R.id.button4),
				(Button) findViewById(R.id.button5),
				(Button) findViewById(R.id.button6),
				(Button) findViewById(R.id.button7),
				(Button) findViewById(R.id.button8),
				(Button) findViewById(R.id.button9),
				(Button) findViewById(R.id.buttonPlus),
				(Button) findViewById(R.id.buttonMinus),
				(Button) findViewById(R.id.buttonMal),
				(Button) findViewById(R.id.buttonDiv),
				(Button) findViewById(R.id.buttonCalc),
				(Button) findViewById(R.id.buttonDELONE),
				(Button) findViewById(R.id.buttonDELALL), };

		for (Button button : buttons) {
			button.setOnClickListener(this);
		}

	}

	@Override
	public void onClick(View view) {

		output = (TextView) this.findViewById(R.id.tv_result);
		String inputAsString = String.valueOf(output.getText());

		switch (view.getId()) {

		case R.id.buttonM1:
			saveButtonHandling(M1, m1, inputAsString);
			break;
		case R.id.buttonM2:
			saveButtonHandling(M2, m2, inputAsString);
			break;
		case R.id.buttonM3:
			saveButtonHandling(M3, m3, inputAsString);
			break;
		case R.id.buttonM4:
			saveButtonHandling(M4, m4, inputAsString);
			break;

		case R.id.button0:
			if (!String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + "0");
			}
			break;

		case R.id.button1:
			if (String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + ".1");
				setPoint = true;
			} else {
				output.setText(output.getText() + "1");
			}
			break;
		case R.id.button2:
			if (String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + ".2");
				setPoint = true;
			} else {
				output.setText(output.getText() + "2");
			}
			break;
		case R.id.button3:
			if (String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + ".3");
				setPoint = true;
			} else {
				output.setText(output.getText() + "3");
			}
			break;
		case R.id.button4:
			if (String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + ".4");
				setPoint = true;
			} else {
				output.setText(output.getText() + "4");
			}
			break;
		case R.id.button5:
			if (String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + ".5");
				setPoint = true;
			} else {
				output.setText(output.getText() + "5");
			}
			break;
		case R.id.button6:
			if (String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + ".6");
				setPoint = true;
			} else {
				output.setText(output.getText() + "6");
			}
			break;
		case R.id.button7:
			if (String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + ".7");
				setPoint = true;
			} else {
				output.setText(output.getText() + "7");
			}
			break;
		case R.id.button8:
			if (String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + ".8");
				setPoint = true;
			} else {
				output.setText(output.getText() + "8");
			}
			break;
		case R.id.button9:
			if (String.valueOf(output.getText()).equals("0")) {
				output.setText(output.getText() + ".9");
				setPoint = true;
			} else {
				output.setText(output.getText() + "9");
			}
			break;

		case R.id.buttonPlus:
			type = "add";
			setInf();
			break;
		case R.id.buttonMinus:
			type = "subtract";
			setInf();
			break;
		case R.id.buttonMal:
			type = "multiply";
			setInf();
			break;
		case R.id.buttonDiv:
			type = "divide";
			setInf();
			break;
		case R.id.buttonDELONE:
			if (!String.valueOf(output.getText()).equals("")) {
				if (String.valueOf(
						output.getText().subSequence(
								output.getText().length() - 1,
								output.getText().length())).equals(".")) {
					setPoint = false;
				}
				output.setText(output.getText().subSequence(0,
						output.getText().length() - 1));
			}
			break;
		case R.id.buttonDELALL:
			result = 0;
			a = "0";
			b = "0";
			output.setText("");
			type = "";
			setPoint = false;
			break;

		case R.id.buttonCalc:
			b = String.valueOf(output.getText());
			if (!b.equals("") && !a.equals("")) {
				if (type.equals("add")) {
					result = Float.valueOf(a) + Float.valueOf(b);

				} else if (type.equals("subtract")) {
					result = Float.valueOf(a) - Float.valueOf(b);
				} else if (type.equals("divide")) {
					result = Float.valueOf(a) / Float.valueOf(b);
				} else if (type.equals("multiply")) {
					result = Float.valueOf(a) * Float.valueOf(b);
				}
				setPoint = false;
				a = "0";
				output.setText(String.valueOf(result));
			}
			break;

		default:
			break;
		}

	}

	private void setInf() {
		a = String.valueOf(output.getText());
		output.setText("");
		setPoint = false;
	}

	@Override
	protected void onStop() {
		super.onStop();
		savePreferences();
	}

	public float getM1() {
		return m1;
	}

	public void setM1(float m1) {
		this.m1 = m1;
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

}
