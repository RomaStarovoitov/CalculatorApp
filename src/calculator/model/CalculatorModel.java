package calculator.model;

import java.util.ArrayList;

import calculator.model.database.DataBase;
import calculator.model.database.SqliteStrategyImpl;

public class CalculatorModel {
	private String value1; // Первое число. Учитывается отрицательное
	private String value2; // Второе число
	private String operation; // Операция: +,-,×,÷,^,√.
	private DataBase db;   // Для хранения вычислений
	
	public CalculatorModel() {
		db=new DataBase();
		db.setDBMS(new SqliteStrategyImpl());
		clearModel();
	}
	
	public void setValue(String value) {
		if (operation.equals("")) {
			setValue1(value);
		} else {
			setValue2(value);
		}
	}
	
	private void setValue1(String value1) {
		if (isNotDot(value1, this.value1))
			this.value1 = this.value1 + value1;
	}

	private void setValue2(String value2) {
		if (isNotDot(value2, this.value2))
			this.value2 = this.value2 + value2;
	}

	private boolean isNotDot(String isNotDot, String value) {
		if (isNotDot.equals(".")) {
			if (value.contains(".")) {
				return false;
			} else
				return true;
		} else
			return true;
	}

	public void setOperation(String operation) {
		if (value1.equals("")) {
			if (operation.equals("-")) {
				value1 = "-";
			}
		} else if (!value1.equals("-"))
			this.operation = operation;
	}

	public String getCalculation() {
		if (!value1.equals("")) {
			if (!operation.equals("")) {
				if (!value2.equals("")) {
					return getResult();
				}
				return "Введите второе число";
			}
			return "Выберите операцию";
		}
		return "Введите первое число";
	}
	
	private String getResult() {
		double result=0;
		double value1 = Double.parseDouble(this.value1);
		double value2 = Double.parseDouble(this.value2);
		switch (operation) {
		case "+":
			result = value1 + value2;
			break;
		case "-":
			result = value1 - value2;
			break;
		case "×":
			result = value1 * value2;
			break;
		case "÷":
			if(value2==0) {
				return "Делить на 0 нельзя!";
			}
			result = value1 / value2;
			break;
		case "^":
			result = Math.pow(value1, value2);
			break;
		case "√":
			result = Math.pow(value2, 1.0 / value1);
			break;
		}

		addHistory(this.value1+this.operation+this.value2+"="+result);
		clearModel();
		if(result!=0) {
			this.value1 = "" + result;
		}
		return "" + result;
	}
	
	public void clearModel() {
		value1 = "";
		value2 = "";
		operation = "";
	}

	public String getText() {
		if (value1.equals("")) {
			return "0";
		} else
			return value1 + operation + value2;
	}
	
	public ArrayList<String> getHistory(){
		return db.readDB();
	}
	
	private void addHistory(String history) {
		db.writeBD(history);
	}

}
