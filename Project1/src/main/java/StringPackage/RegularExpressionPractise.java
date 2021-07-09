package StringPackage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionPractise {
	/*
	 * "." - Matches the single character
	 * [a-z] - These is a range of small character a-z we can have in our pattern
	 * 
	 */
	public static void main(String[] args) {
		//Method1
		Pattern pattern0 = Pattern.compile(".");
		Matcher match1 = pattern0.matcher("ee");
		boolean result0 = match1.matches();
		System.out.println(result0);
		
		//Method2
		System.out.println(Pattern.compile("..w").matcher("saw").matches());
		System.out.println("*********************");
		//Method3
		System.out.println(Pattern.matches("...r", "Amarandren"));
		System.out.println("*********************");
		//[a-z]
		System.out.println(Pattern.matches("[a-z]", "a")); //It will check only first occuring character
		System.out.println(Pattern.matches("[a-z]", "aw")); //Eventhough matching characters also it won't check throughout the string
		System.out.println(Pattern.matches("[a-z]+", "prasanna"));//It will check throughout the string and return true
		System.out.println(Pattern.matches("[a-z]+", "prasannA"));
		System.out.println("*********************");
		//[A-Z]
		System.out.println(Pattern.matches("[A-Z]", "G"));//return true
		System.out.println(Pattern.matches("[A-Z]", "GRAPES"));//return false
		System.out.println("*********************");
		//we can combine two condition
		System.out.println(Pattern.matches("[a-zA-Z]", "A"));//return true
		System.out.println(Pattern.matches("[a-zA-Z]", "a"));//return true
		System.out.println("*********************");
		//Union condition
		System.out.println(Pattern.matches("[a-d[m-o]]", "n"));
		System.out.println(Pattern.matches("[a-dm-o]", "a"));
		System.out.println("*********************");
		//Intersection //As per below example it will match only the exact "pra" pattern continuously
		System.out.println(Pattern.matches("[a-z&&[pra]]+", "pra"));
		System.out.println(Pattern.matches("[a-z&&[pra]]+", "prrra"));
		System.out.println(Pattern.matches("[a-z&&[pra]]+", "rprrra"));
		System.out.println(Pattern.matches("[a-z&&[pra]]+", "reprrra"));//Due to e the pattern breaks so it will fail we can make combination between these pra
		System.out.println("*********************");
		//Base on occurence we have to compare
		//A? - meaning it will occur only once or won't
		System.out.println(Pattern.matches("[A-Z]?", "S"));
		System.out.println(Pattern.matches("SP?", "SSP"));//S coming more than once
		System.out.println("*********************");
		// '+' -> Occurence once or more times
		System.out.println(Pattern.matches("A+", "AAAA"));
		System.out.println(Pattern.matches("A+", "ABAAA"));//return false A should occur continuously
		System.out.println("*********************");
		//{n} - it has to occur n times
		System.out.println(Pattern.matches("N{10}", "NNNNN"));//return false
		System.out.println(Pattern.matches("N{10}", "NNNNNNNNNN"));//return true
		System.out.println(Pattern.matches("N{10}", "NNNNNNNNNNN"));//return false more than N times
		System.out.println("*********************");
		//{n,} - it has to occur n times, more than n times and not less than ntimes
		System.out.println(Pattern.matches("N{10,}", "NNNNN"));//return false
		System.out.println(Pattern.matches("N{10,}", "NNNNNNNNNN"));//return true
		System.out.println(Pattern.matches("N{10,}", "NNNNNNNNNNN"));//return true (acceptable)
		System.out.println("*********************");
		//{start,end} - it was range character should be within the range
		System.out.println(Pattern.matches("P{2,8}", "PPP")); // return true
		System.out.println(Pattern.matches("P{2,8}", "P")); // return false
		System.out.println(Pattern.matches("P{2,8}", "PPPPPPPPP")); // return false
	}

}
