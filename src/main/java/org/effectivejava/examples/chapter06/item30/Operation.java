// Enum type with constant-specific class bodies and data - Page 153
package org.effectivejava.examples.chapter06.item30;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.TIMEOUT;

public enum Operation {
	PLUS("+") {
		double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		double apply(double x, double y) {
			return x / y;
		}
	};
	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	abstract double apply(double x, double y);

	// Implementing a fromString method on an enum type - Page 154
	private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();
	static { // Initialize map from constant name to enum constant
		for (Operation op : values())
			stringToEnum.put(op.toString(), op);
	}

	// Returns Operation for string, or null if string is invalid
	public static Operation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
	
	//欠けてるメソッドをシミュレートする？？
	public static Operation inverse(Operation op){
		switch (op) {
			case PLUS:return Operation.MINUS;
			case MINUS:return Operation.PLUS;
			case TIMES:return Operation.DIVIDE;
			case DIVIDE:return Operation.TIMES;
			default:
				throw new AssertionError("Unknown op:"+op);
		}
	}

	// Test program to perform all operations on given operands
	public static void main(String[] args) {
		//double x = Double.parseDouble(args[0]);
		//double y = Double.parseDouble(args[1]);
		double x = 16.0;
		double y = 8.0;
		for (Operation op : Operation.values()){
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
			System.out.printf("inverse %f %s %f = %f%n", x, Operation.inverse(op), y, Operation.inverse(op).apply(x, y));
		}
		
	}
}
