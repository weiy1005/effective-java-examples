// Using a nested EnumMap to associate data with enum pairs - Pags 163-164
package org.effectivejava.examples.chapter06.item33;

import java.util.EnumMap;
import java.util.Map;

//p157
public enum PhaseBad {
	SOLID, LIQUID, GAS;

	public enum Transition {
		MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

		private static final Transition[][] TRANSITIONS = {
			{null,MELT,SUBLIME},
			{FREEZE,null,BOIL},
			{DEPOSIT,CONDENSE,null}
		};
		

		public static Transition from(PhaseBad src, PhaseBad dst) {
			return TRANSITIONS[src.ordinal()][dst.ordinal()];
		}
	}

	// Simple demo program - prints a sloppy table
	public static void main(String[] args) {
		for (PhaseBad src : PhaseBad.values())
			for (PhaseBad dst : PhaseBad.values())
				if (src != dst)
					System.out.printf("%s to %s : %s %n", src, dst,
							Transition.from(src, dst));
	}
}
