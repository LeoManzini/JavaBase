package br.com.leomanzini.strings;

public class StringsFunctions {

	public static void main(String[] args) {
		
		String original = "abcde FGHIJ ABC abc DEFG    ";
		String s = "potato apple lemon";
		
		String[] vect = s.split(" ");
		
		String s01 = original.toLowerCase();
		String s02 = original.toUpperCase();
		String s03 = original.trim();
		String s04 = original.substring(2);
		String s05 = original.substring(2, 9);
		String s06 = original.replace('a', 'x');
		String s07 = original.replace("abc", "xy");
		int s08 = original.indexOf("bc");
		int s09 = original.lastIndexOf("bc");
		
		System.out.println("Original: " + original);
		System.out.println("ToLowerCase: " + s01);
		System.out.println("ToUpperCase: " + s02);
		System.out.println("Trim: " + s03);
		System.out.println("Substring (2): " + s04);
		System.out.println("Substring (2, 9): " + s05);
		System.out.println("Replace: " + s06);
		System.out.println("Replace substring: " + s07);
		System.out.println("IndexOf (bc): " + s08);
		System.out.println("LastIndexOf (bc): " + s09);
		
		System.out.println("Split word: " + s);
		System.out.println("Vect[0]: " + vect[0]);
		System.out.println("Vect[1]: " + vect[1]);
		System.out.println("Vect[2]: " + vect[2]);
	}
}
