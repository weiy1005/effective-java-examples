// The strategy enum pattern
package org.effectivejava.examples.chapter06.item30;

//p150のコード
enum PayrollDay150 {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

//	private final PayType payType ;
	private static final int HOURS_PER_SHIFT = 8;

	double pay(double hoursWorked, double payRate) {
		double basePay = hoursWorked*payRate;
		double overtimePay;
		switch (this) {
			case SATURDAY: case SUNDAY:
				overtimePay = hoursWorked*payRate/2;
				break;
	
			default:
				overtimePay = hoursWorked <= HOURS_PER_SHIFT?
							0:(hoursWorked - HOURS_PER_SHIFT)*payRate/2;
				break;
		}
		return basePay + overtimePay;
		
		
	}
	
	// Test program to perform all operations on given operands
	public static void main(String[] args) {

		
		for (PayrollDay150 pay : PayrollDay150.values())
			System.out.printf("%s pay=%s %n",  pay,pay.pay(8,1));
		
		//９時間働いたら
		PayrollDay150 monday2 = PayrollDay150.MONDAY;
		System.out.printf("%s pay=%s %n",  monday2,monday2.pay(9, 1));
	}
}
