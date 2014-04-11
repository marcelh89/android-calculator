package com.example.taschenrechner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	TextView output;
	float result = 0;
	boolean setPoint = false;
	String a = "", b = "";
	String type = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		output = (TextView) this.findViewById(R.id.tv_result);
		output.setText("");

		Button buttons[] = { (Button) findViewById(R.id.button1),
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

		switch (view.getId()) {
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

}
