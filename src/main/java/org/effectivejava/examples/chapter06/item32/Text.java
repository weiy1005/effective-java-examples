// EnumSet - a modern replacement for bit fields - Page 160
package org.effectivejava.examples.chapter06.item32;

import java.util.EnumSet;
import java.util.Set;

//ビットフィールドの代わりにEnumSetを使用する - Strategic Choice <http://d.hatena.ne.jp/asakichy/20111130/1322604410>
public class Text {
	public enum Style {
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}

	// Any Set could be passed in, but EnumSet is clearly best
	public void applyStyles(Set<Style> styles) {
		// Body goes here
		for(Style st:styles){
			System.out.printf("%s %d %n",st,st.ordinal());
		}
	}

	// Sample use
	public static void main(String[] args) {
		Text text = new Text();
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
		System.out.println("=====================================");
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC,Style.STRIKETHROUGH));
		//System.out.printf("%s %d %n",Style.BOLD,Style.BOLD.ordinal());
		//System.out.printf("%s %d %n",Style.UNDERLINE,Style.UNDERLINE.ordinal());
	}
}
