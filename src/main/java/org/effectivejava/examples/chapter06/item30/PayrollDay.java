// The strategy enum pattern
package org.effectivejava.examples.chapter06.item30;

enum PayrollDay {
	MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(
			PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY), SATURDAY(
			PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

	private final PayType payType;

	PayrollDay(PayType payType) {
		this.payType = payType;
	}

	double pay(double hoursWorked, double payRate) {
		return payType.pay(hoursWorked, payRate);
	}

	// The strategy enum type
	private enum PayType {
		WEEKDAY {
			double overtimePay(double hours, double payRate) {
				return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT)
						* payRate / 2;
			}
		},
		WEEKEND {
			double overtimePay(double hours, double payRate) {
				return hours * payRate / 2;
			}
		};
		private static final int HOURS_PER_SHIFT = 8;

		abstract double overtimePay(double hrs, double payRate);

		double pay(double hoursWorked, double payRate) {
			double basePay = hoursWorked * payRate;
			return basePay + overtimePay(hoursWorked, payRate);
		}
	}
	
	// Test program to perform all operations on given operands
	public static void main(String[] args) {
		for (PayrollDay pay : PayrollDay.values())
			System.out.printf("%s pay=%s %n",  pay,pay.pay(8,1));
		
		//９時間働いたら
		PayrollDay monday2 = PayrollDay.MONDAY;
		System.out.printf("%s pay=%s %n",  monday2,monday2.pay(9, 1));
	}
}
