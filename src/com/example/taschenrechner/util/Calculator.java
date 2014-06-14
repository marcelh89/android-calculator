package com.example.taschenrechner.util;

import android.content.Context;
import android.widget.TextView;

public class Calculator {

	float result = 0;
	boolean setPoint = false;
	String a = "", b = "";
	char optype = '_';

	public String calc(char operation, String input, TextView output) {

		String returnValue = "";

		// 0-9
		if (String.valueOf(operation).matches("[0-9]")) {
			if (input.equals("0")) {
				returnValue = output.getText() + "." + operation;
				setPoint = true;
			} else {
				returnValue = output.getText() + "" + operation;
			}

			// operations + - * /

		} else if ("+-*/".contains(operation + "")) {

			optype = operation;
			a = String.valueOf(output.getText());
			setPoint = false;
			returnValue = output.getText() + "";

		} else {
			// Comma

			if (operation == '.') {
				boolean check = input != ""
						&& input != String.valueOf(Float.NaN)
						&& input != "Error" && !input.contains(".");

				if (!setPoint && check) {
					returnValue = input + ".";
				}
			}

			// DELONE

			if (operation == 'D') {

				result = 0;
				a = "0";
				b = "0";
				returnValue = "";
				setPoint = false;

			}

			// CALC

			if (operation == 'C') {

				b = String.valueOf(output.getText());
				if (!b.equals("") && !a.equals("")) {

					switch (optype) {
					case '+':
						result = Float.valueOf(a) + Float.valueOf(b);
						break;
					case '-':
						result = Float.valueOf(a) - Float.valueOf(b);
						break;
					case '*':
						result = Float.valueOf(a) * Float.valueOf(b);
						break;
					case '/':
						result = Float.valueOf(a) / Float.valueOf(b);
						break;
					}

					setPoint = false;
					a = "0";
					returnValue = result + "";

				}

			}

		}
		return returnValue;
	}
}
