package com.example.taschenrechner;

import com.example.taschenrechner.util.Calculator;
import com.example.taschenrechner.util.Memory;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author marcman
 * 
 */
public class MainActivity extends Activity implements OnClickListener {

	TextView output;
	Memory memory;
	Calculator calculator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		memory = new Memory(getBaseContext());
		calculator = new Calculator();

		output = (TextView) this.findViewById(R.id.tv_result);
		output.setText("");

		Integer buttons[] = { R.id.buttonM1, R.id.buttonM2, R.id.buttonM3,
				R.id.buttonM4, R.id.button0, R.id.button1, R.id.button2,
				R.id.button3, R.id.button4, R.id.button5, R.id.button6,
				R.id.button7, R.id.button8, R.id.button9, R.id.buttonPlus,
				R.id.buttonMinus, R.id.buttonMal, R.id.buttonDiv,
				R.id.buttonCalc, R.id.buttonDEL, R.id.buttonComma };

		for (Integer buttonID : buttons) {
			Button button = (Button) this.findViewById(buttonID);
			button.setOnClickListener(this);
		}

	}

	@Override
	public void onClick(View view) {
		Log.i("test", view.getId() + "");

		output = (TextView) findViewById(R.id.tv_result);

		String input = String.valueOf(output.getText());

		switch (view.getId()) {
		case R.id.buttonM1:
			output.setText(memory.handleSaving(Memory.M1, input));
			break;
		case R.id.buttonM2:
			output.setText(memory.handleSaving(Memory.M2, input));
			break;
		case R.id.buttonM3:
			output.setText(memory.handleSaving(Memory.M3, input));
			break;
		case R.id.buttonM4:
			output.setText(memory.handleSaving(Memory.M4, input));
			break;
		case R.id.button0:
			output.setText(calculator.calc('0', input, output));
			break;
		case R.id.button1:
			output.setText(calculator.calc('1', input, output));
			break;
		case R.id.button2:
			output.setText(calculator.calc('2', input, output));
			break;
		case R.id.button3:
			output.setText(calculator.calc('3', input, output));
			break;
		case R.id.button4:
			output.setText(calculator.calc('4', input, output));
			break;
		case R.id.button5:
			output.setText(calculator.calc('5', input, output));
			break;
		case R.id.button6:
			output.setText(calculator.calc('6', input, output));
			break;
		case R.id.button7:
			output.setText(calculator.calc('7', input, output));
			break;
		case R.id.button8:
			output.setText(calculator.calc('8', input, output));
			break;
		case R.id.button9:
			output.setText(calculator.calc('9', input, output));
			break;
		case R.id.buttonComma:
			output.setText(calculator.calc('.', input, output));
			break;
		case R.id.buttonPlus:
			calculator.calc('+', input, output);
			output.setText("");
			break;
		case R.id.buttonMinus:
			calculator.calc('-', input, output);
			output.setText("");
			break;
		case R.id.buttonMal:
			calculator.calc('*', input, output);
			output.setText("");
			break;
		case R.id.buttonDiv:
			calculator.calc('/', input, output);
			output.setText("");
			break;
		case R.id.buttonDEL:
			output.setText(calculator.calc('D', input, output));
			break;
		case R.id.buttonCalc:
			output.setText(calculator.calc('C', input, output));
			break;
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		memory.savePreferences();
	}
}
